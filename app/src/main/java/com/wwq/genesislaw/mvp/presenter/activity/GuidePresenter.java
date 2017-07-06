package com.wwq.genesislaw.mvp.presenter.activity;

import com.wwq.genesislaw.mvp.contract.activity.GuideContract;
import com.wwq.genesislaw.mvp.model.activity.GuideModel;

/**
 * Created by wwq on 2017/4/17.
 */

public class GuidePresenter extends GuideContract.Presenter {
    public GuidePresenter(GuideContract.View view) {
        mView = view;
        mModel = new GuideModel();
    }

    @Override
    public void initGuide() {
        mView.initGuide();
    }
}