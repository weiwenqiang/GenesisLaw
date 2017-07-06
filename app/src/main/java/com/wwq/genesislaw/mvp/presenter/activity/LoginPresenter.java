package com.wwq.genesislaw.mvp.presenter.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.mvp.contract.activity.LoginContract;
import com.wwq.genesislaw.mvp.model.activity.LoginModel;

/**
 * Created by wwq on 2017/6/6.
 */

public class LoginPresenter extends LoginContract.Presenter {
    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mModel = new LoginModel();
    }
    /**
     * 切换Fragment
     */
    @Override
    public void cutFragment(FragmentManager fm, String tag) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.contanier_login, mModel.createFragmentFactory(tag), tag);
        ft.addToBackStack(tag);
        ft.commit();
    }

    /**
     * 协议文本
     */
    @Override
    public void go2ProtocolString(FragmentManager fm, int number) {
//        Fragment fragment = fm.findFragmentByTag(LoginModel.TAG_PROTOCOL_STRING);
//        if (fragment == null) {
//            fragment = new ProtocolStringFragment();
//        }
//        Bundle bundle = new Bundle();
//        bundle.putInt("number", number);
//        fragment.setArguments(bundle);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.contanier_login, fragment, LoginModel.TAG_PROTOCOL_STRING);
//        ft.addToBackStack(LoginModel.TAG_AGREEMENT_SIGNING);
//        ft.commit();
    }
}