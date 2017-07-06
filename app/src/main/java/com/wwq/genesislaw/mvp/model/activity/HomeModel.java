package com.wwq.genesislaw.mvp.model.activity;

import android.support.v4.app.Fragment;

import com.wwq.genesislaw.model.json.RequestErrorEntity;
import com.wwq.genesislaw.mvp.api.ApiEngine;
import com.wwq.genesislaw.mvp.api.RxSchedulers;
import com.wwq.genesislaw.mvp.contract.activity.HomeContract;

import rx.Observable;

/**
 * Created by wwq on 2017/6/6.
 */

public class HomeModel implements HomeContract.Model {
    @Override
    public String[] getContent() {
        return new String[]{"新订单", "进行中", "催单", "已完成", "退单"};
    }

    @Override
    public Fragment FragmentFactory(int position) {
        Fragment fragment = null;
//        if (position == 0) {
//            fragment = new NewOrdersFragment();
//        } else if (position == 1) {
//            fragment = new OngoingFragment();
//        } else if (position == 2) {
//            fragment = new ReminderFragment();
//        } else if (position == 3) {
//            fragment = new CompletedFragment();
//        } else if (position == 4) {
//            fragment = new SingleBackFragment();
//        }
        return fragment;
    }

    @Override
    public Observable<RequestErrorEntity> IsRest(String token, int state) {
//        return ApiEngine.getInstance().getApiService()
//                .IsRest(token, state)
//                .compose(RxSchedulers.<RequestErrorEntity>switchThread());
        return null;
    }
}