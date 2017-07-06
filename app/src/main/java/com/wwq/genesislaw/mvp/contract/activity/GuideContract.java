package com.wwq.genesislaw.mvp.contract.activity;

import com.wwq.genesislaw.mvp.base.BaseModel;
import com.wwq.genesislaw.mvp.base.BasePresenter;
import com.wwq.genesislaw.mvp.base.BaseView;

/**
 * Created by wwq on 2017/4/17.
 */

public interface GuideContract {
    interface View extends BaseView {
        void initGuide();
    }

    interface Model extends BaseModel {
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void initGuide();
    }
}