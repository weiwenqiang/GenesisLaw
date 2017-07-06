package com.wwq.genesislaw.mvp.contract.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wwq.genesislaw.mvp.base.BaseModel;
import com.wwq.genesislaw.mvp.base.BasePresenter;
import com.wwq.genesislaw.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/8.
 */

public interface VesselContract {
    interface View extends BaseView {
        void initToolbar(String title);
    }

    interface Model extends BaseModel {
        Fragment FragmentFactory(String str);

        String getFragmentTitle(String str);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void switchFragment(String fragmentStr, FragmentManager fm);

        public abstract void removeFragment(String fragmentName, FragmentManager fm);
    }
}