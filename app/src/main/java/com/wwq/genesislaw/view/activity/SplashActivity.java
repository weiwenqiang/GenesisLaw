package com.wwq.genesislaw.view.activity;

import android.content.Intent;
import android.widget.RelativeLayout;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.mvp.contract.activity.SplashContract;
import com.wwq.genesislaw.mvp.presenter.activity.SplashPresenter;
import com.wwq.genesislaw.view.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wwq on 2017/6/6.
 */

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.rl_root)
    RelativeLayout rlRoot;

    @Override
    public SplashPresenter onCreatePresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mPresenter.startAnim(rlRoot);
    }

    @Override
    public void jumpNextPage(boolean isJump) {
        if (!isJump) {
            startActivity(new Intent(SplashActivity.this, GuideActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();
    }
}
