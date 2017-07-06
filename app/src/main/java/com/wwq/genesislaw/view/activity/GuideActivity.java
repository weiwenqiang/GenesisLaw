package com.wwq.genesislaw.view.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.controller.utils.DensityUtils;
import com.wwq.genesislaw.controller.utils.SPUtils;
import com.wwq.genesislaw.mvp.contract.activity.GuideContract;
import com.wwq.genesislaw.mvp.presenter.activity.GuidePresenter;
import com.wwq.genesislaw.view.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 魏文强 on 2016/11/21.
 */
public class GuideActivity extends BaseActivity<GuidePresenter> implements GuideContract.View {
    @BindView(R.id.vp_guide)
    ViewPager vpGuide;
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.ll_point_group)
    LinearLayout llPointGroup;
    @BindView(R.id.view_red_point)
    View viewRedPoint;

    private ArrayList<ImageView> imageViewArrayList;

    private int[] mImageIds = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};

    private int mPointWidth;

    @Override
    public GuidePresenter onCreatePresenter() {
        return new GuidePresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        vpGuide.setAdapter(new GuideAdapter());
        vpGuide.setOnPageChangeListener(new GuidePageListener());

        mPresenter.initGuide();
    }

    @OnClick(R.id.bt_start)
    void onClickStart(){
        SPUtils.put(GuideActivity.this, "is_user_guide_showed", true);
        startActivity(new Intent(GuideActivity.this, LoginActivity.class));
        finish();
    }

    @Override
    public void initGuide() {
        imageViewArrayList = new ArrayList<ImageView>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageIds[i]);
            imageViewArrayList.add(imageView);
        }

        for (int i = 0; i < mImageIds.length; i++) {
            View point = new ImageView(this);
            int px = DensityUtils.dp2px(this, 10);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(px, px);
            if (i > 0) {
                params.leftMargin = 20;
            }
            point.setLayoutParams(params);
            point.setBackgroundResource(R.drawable.shape_point_guide);
            llPointGroup.addView(point);
        }
        llPointGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mPointWidth = llPointGroup.getChildAt(1).getLeft() - llPointGroup.getChildAt(0).getLeft();
                llPointGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewArrayList.get(position));
            return imageViewArrayList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class GuidePageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            float len = mPointWidth * positionOffset + position * mPointWidth;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewRedPoint.getLayoutParams();//获得红点的布局参数
            layoutParams.leftMargin = (int) len;
            viewRedPoint.setLayoutParams(layoutParams);
        }

        @Override
        public void onPageSelected(int position) {
            if (position == mImageIds.length - 1) {
                btStart.setVisibility(View.VISIBLE);
            } else {
                btStart.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
