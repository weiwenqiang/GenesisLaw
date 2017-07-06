package com.wwq.genesislaw.mvp.presenter.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.mvp.contract.activity.VesselContract;
import com.wwq.genesislaw.mvp.model.activity.VesselModel;

/**
 * Created by wwq on 2017/6/8.
 */

public class VesselPresenter extends VesselContract.Presenter {
    public VesselPresenter(VesselContract.View view) {
        mView = view;
        mModel = new VesselModel();
    }

    //切换Fragment方法
    @Override
    public void switchFragment(String fragmentString, FragmentManager fm) {
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.activity_frame, mModel.FragmentFactory(fragmentString));
        transaction.addToBackStack(null);
        transaction.commit();

        mView.initToolbar(mModel.getFragmentTitle(fragmentString));
    }

    //移除Fragment方法
    @Override
    public void removeFragment(String fragmentName, FragmentManager fm) {
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment = fm.findFragmentByTag(fragmentName);
        transaction.remove(fragment);
        transaction.commit();
    }

}