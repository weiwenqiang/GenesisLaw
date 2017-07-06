package com.wwq.genesislaw.mvp.presenter.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.ViewGroup;

import com.wwq.genesislaw.model.json.RequestErrorEntity;
import com.wwq.genesislaw.mvp.contract.activity.HomeContract;
import com.wwq.genesislaw.mvp.model.activity.HomeModel;
import com.wwq.genesislaw.view.adapter.pager.UpdatableFragmentPagerAdapter;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomePresenter extends HomeContract.Presenter {
    boolean[] fragmentsUpdateFlag = { false, false, false, false, false };

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mModel = new HomeModel();
    }

    @Override
    public void getPagerAdapter(FragmentManager childFragmentManager) {
        PagerAdapter adapter = new GoogleMusicAdapter(childFragmentManager);
        mView.initPager(adapter);
    }

    @Override
    public void IsRest(String token, int state) {
        if(TextUtils.isEmpty(token)){
            mView.isEmptyToken();
            return;
        }
        Subscription subscribe = mModel.IsRest(token, state)
                .subscribe(new Subscriber<RequestErrorEntity>() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(!TextUtils.isEmpty(e.getMessage())){
                            mView.onFail(e.getMessage());
                        }
                        onCompleted();
                    }

                    @Override
                    public void onNext(RequestErrorEntity entity) {
                        if(!entity.getCode().equals("SUCCESS")){
                            mView.onFail(entity.getMsg());
                            if(entity.getCode().equals("INVALID_TOKEN")){
                                mView.isEmptyToken();
                            }
                            if(entity.getCode().equals("SUCCESS")){

                            }
                        }else{
                            mView.onSucceedIsRest(entity);
                        }
                    }
                });
        addSubscribe(subscribe);
    }

    class GoogleMusicAdapter extends UpdatableFragmentPagerAdapter {
        FragmentManager fm;

        public GoogleMusicAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return mModel.FragmentFactory(position % mModel.getContent().length);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mModel.getContent()[position % mModel.getContent().length].toUpperCase();
        }

        @Override
        public int getCount() {
            return mModel.getContent().length;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //得到缓存的fragment
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            //得到tag，这点很重要
            String fragmentTag = fragment.getTag();
            if (fragmentsUpdateFlag[position % fragmentsUpdateFlag.length]) {
                //如果这个fragment需要更新
                FragmentTransaction ft = fm.beginTransaction();
                //移除旧的fragment
                ft.remove(fragment);
                //换成新的fragment
                fragment = mModel.FragmentFactory(position % mModel.getContent().length);
                //添加新fragment时必须用前面获得的tag，这点很重要
                ft.add(container.getId(), fragment, fragmentTag);
                ft.attach(fragment);
                ft.commit();
                //复位更新标志
                fragmentsUpdateFlag[position % fragmentsUpdateFlag.length] = false;
            }
            return fragment;
        }
    }
}