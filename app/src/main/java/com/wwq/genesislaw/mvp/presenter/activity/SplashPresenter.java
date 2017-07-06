package com.wwq.genesislaw.mvp.presenter.activity;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;

import com.wwq.genesislaw.mvp.contract.activity.SplashContract;
import com.wwq.genesislaw.mvp.model.activity.SplashModel;

/**
 * Created by wwq on 2017/6/6.
 */

public class SplashPresenter extends SplashContract.Presenter {
    public SplashPresenter(SplashContract.View view) {
        mView = view;
        mModel = new SplashModel();
    }

    @Override
    public void startAnim(RelativeLayout relativeLayout) {
        AnimationSet set = new AnimationSet(false);

        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        set.addAnimation(alphaAnimation);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mView.jumpNextPage(mModel.getUserGuide());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        relativeLayout.startAnimation(set);
    }
}