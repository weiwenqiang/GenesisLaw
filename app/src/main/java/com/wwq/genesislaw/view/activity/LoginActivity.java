package com.wwq.genesislaw.view.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.mvp.contract.activity.LoginContract;
import com.wwq.genesislaw.mvp.model.activity.LoginModel;
import com.wwq.genesislaw.mvp.presenter.activity.LoginPresenter;
import com.wwq.genesislaw.view.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wwq on 2017/6/6.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    public FragmentManager fm;
    @BindView(R.id.activity_main_toolbar)
    Toolbar toolbar;

    @Override
    public LoginPresenter onCreatePresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int setLayoutResouceId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        fm = getSupportFragmentManager();
        initToolbar();

        mPresenter.cutFragment(fm, LoginModel.TAG_SIGN_IN);
    }

    @Override
    public void login() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        clickBack();
    }

    private void clickBack() {
        int count = fm.getBackStackEntryCount();
        if (count <= 1) {
            finish();
        } else {
            fm.popBackStack();
        }
    }

    private void initToolbar() {
        toolbar.setFitsSystemWindows(true);//解决与状态栏重叠
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBack();
            }
        });
    }

    @Override
    public void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }
}
