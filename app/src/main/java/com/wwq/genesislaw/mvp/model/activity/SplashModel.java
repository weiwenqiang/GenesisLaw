package com.wwq.genesislaw.mvp.model.activity;

import com.wwq.genesislaw.controller.utils.SPUtils;
import com.wwq.genesislaw.mvp.contract.activity.SplashContract;
import com.wwq.genesislaw.view.base.BaseApplication;

/**
 * Created by wwq on 2017/6/6.
 */

public class SplashModel implements SplashContract.Model {
    @Override
    public boolean getUserGuide() {
        return (boolean) SPUtils.get(BaseApplication.getApplication(), "is_user_guide_showed", false);
    }
}