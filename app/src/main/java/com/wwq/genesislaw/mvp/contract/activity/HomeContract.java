package com.wwq.genesislaw.mvp.contract.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;

import com.wwq.genesislaw.model.json.RequestErrorEntity;
import com.wwq.genesislaw.mvp.base.BaseModel;
import com.wwq.genesislaw.mvp.base.BasePresenter;
import com.wwq.genesislaw.mvp.base.BaseView;

import rx.Observable;

/**
 * Created by wwq on 2017/6/6.
 */

public interface HomeContract {
    interface View extends BaseView {
        void initPager(PagerAdapter adapter);

        void onSucceedIsRest(RequestErrorEntity entity);
    }

    interface Model extends BaseModel {
        String[] getContent();

        Fragment FragmentFactory(int position);

        Observable<RequestErrorEntity> IsRest(String token, int state);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getPagerAdapter(FragmentManager childFragmentManager);

        public abstract void IsRest(String token, int state);
    }
}