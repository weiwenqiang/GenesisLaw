package com.wwq.genesislaw.view.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.viewpagerindicator.TabPageIndicator;
import com.wwq.genesislaw.R;
import com.wwq.genesislaw.controller.utils.SPUtils;
import com.wwq.genesislaw.model.json.RequestErrorEntity;
import com.wwq.genesislaw.mvp.contract.activity.HomeContract;
import com.wwq.genesislaw.mvp.presenter.activity.HomePresenter;
import com.wwq.genesislaw.view.base.BaseActivity;
import com.wwq.genesislaw.view.base.BaseApplication;
import com.wwq.genesislaw.view.widget.custom.SelectableRoundedImageView;
import com.wwq.genesislaw.view.widget.custom.SwitchButton;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.indicator)
    TabPageIndicator indicator;
    @BindView(R.id.txt_state)
    TextView txtState;
    @BindView(R.id.img_user_round)
    SelectableRoundedImageView imgUserRound;
    @BindView(R.id.swb_tint_color)
    SwitchButton swbTintColor;

    @Override
    public HomePresenter onCreatePresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
//        setState();
        mPresenter.getPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void initPager(PagerAdapter adapter) {
        pager.setOffscreenPageLimit(0);
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }

    @Override
    public void onSucceedIsRest(RequestErrorEntity entity) {
//        if (GlobalContants.WORK_STATE) {
//            SPUtils.put(BaseApplication.getApplication(), "login_state", 1);
//        } else {
//            SPUtils.put(BaseApplication.getApplication(), "login_state", 0);
//        }
//        setState();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
//        swbTintColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    mPresenter.IsRest(GlobalContants.TOKEN, 0);
//                } else {
//                    mPresenter.IsRest(GlobalContants.TOKEN, 1);
//                }
//            }
//        });
    }

    @OnClick(R.id.img_user_round)
    public void onViewClicked() {
        startActivity(new Intent(HomeActivity.this, SettingActivity.class));
    }

//    //设置开工休息状态
//    private void setState() {
//        GlobalContants.WORK_STATE = (int) SPUtils.get(BaseApplication.getApplication(), "login_state", 0) == 0;
//        if (GlobalContants.WORK_STATE) {
//            swbTintColor.setChecked(true);
//            txtState.setText("开工");
//            if ((boolean) SPUtils.get(BaseApplication.getApplication(), "isJupush", true)) {
//                JPushInterface.resumePush(BaseApplication.getApplication());
//            } else {
//                JPushInterface.stopPush(BaseApplication.getApplication());
//            }
//        } else {
//            swbTintColor.setChecked(false);
//            txtState.setText("休息");
//            JPushInterface.stopPush(BaseApplication.getApplication());
//        }
//    }
}
