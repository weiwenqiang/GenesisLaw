package com.wwq.genesislaw.mvp.contract.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wwq.genesislaw.mvp.base.BaseModel;
import com.wwq.genesislaw.mvp.base.BasePresenter;
import com.wwq.genesislaw.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/6.
 */

public interface LoginContract {
    interface View extends BaseView {
        void login();

        void setToolbarTitle(String title);
    }

    interface Model extends BaseModel {
        Fragment createFragmentFactory(String fragmentStr);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void cutFragment(FragmentManager fm, String tag);

        public abstract void go2ProtocolString(FragmentManager fm, int number);
    }
}