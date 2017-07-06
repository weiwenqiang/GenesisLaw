package com.wwq.genesislaw.mvp.contract.activity;

import android.widget.RelativeLayout;

import com.wwq.genesislaw.mvp.base.BaseModel;
import com.wwq.genesislaw.mvp.base.BasePresenter;
import com.wwq.genesislaw.mvp.base.BaseView;

/**
 * Created by wwq on 2017/6/6.
 */

public interface SplashContract {
    interface View extends BaseView {
        void jumpNextPage(boolean isJump);
    }

    interface Model extends BaseModel {
        boolean getUserGuide();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void startAnim(RelativeLayout relativeLayout);
    }
}