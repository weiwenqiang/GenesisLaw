package com.wwq.genesislaw.view.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.wwq.genesislaw.R;
import com.wwq.genesislaw.controller.utils.T;
import com.wwq.genesislaw.mvp.base.BasePresenter;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 魏文强 on 2017/2/18.
 */

public abstract class BaseMvpFragment<P extends BasePresenter> extends Fragment {
    public P mPresenter;
    private Unbinder unbinder;

    public abstract P onCreatePresenter();
    /**
     * 贴附的activity
     */
    protected BaseActivity mActivity;

    /**
     * 根view
     */
    protected View mRootView;

    /**
     * 是否对用户可见
     */
//    protected boolean mIsVisible;
    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
//    protected boolean mIsPrepare;
    /**
     * xUtils 注解使用
     */
    private boolean injected = false;

    /**
     * Gson
     */
    protected Gson gson;
    /**
     * xUtils 图片规范参数
     */
    protected ImageOptions imageOptions;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mRootView = inflater.inflate(setLayoutResouceId(), container, false);

        unbinder = ButterKnife.bind(this, mRootView);
        //xUtils
        injected = true;
        x.view().inject(this, mRootView);

        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }

        initParam(getArguments());
        initView();
        initData();

//        mIsPrepare = true;

        setListener();
        processLogic(savedInstanceState);

        gson = new Gson();

        imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                .setRadius(DensityUtil.dip2px(5))
                .setCrop(true)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();

        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!injected) {
            x.view().inject(this, this.getView());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 初始化数据
     */
    protected void initParam(Bundle arguments) {
    }

    /**
     * 初始化View
     */
    protected void initView(){
    }

    /**
     * 初始化Data
     */
    protected void initData() {
    }

    /**
     * 设置监听事件
     */
    protected void setListener() {
    }

    /**
     * 处理业务逻辑，状态恢复等操作
     *
     * @param savedInstanceState
     */
    protected void processLogic(Bundle savedInstanceState){};

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        this.mIsVisible = isVisibleToUser;
        if (isVisibleToUser) {
//            onVisibleToUser();
            onLazyLoad();
        }
    }

    /**
     * 用户可见时执行的操作
     */
//    protected void onVisibleToUser() {
//        if (mIsPrepare && mIsVisible) {
//            onLazyLoad();
//        }
//    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     */
    protected void onLazyLoad(){

    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(int id) {
        if (mRootView == null) {
            return null;
        }
        return (T) mRootView.findViewById(id);
    }

    /**
     * 设置根布局资源id
     */
    protected abstract int setLayoutResouceId();

    protected void showLoadingDialog() {
        mActivity.showLoadingDialog();
    }

    protected void dismissLoadingDialog() {
        if (isVisible()) {
            mActivity.dismissLoadingDialog();
        }
    }

    public void showDialog() {
        mActivity.showLoadingDialog();
    }

    public void onFail(String err) {
        T.showShort(mActivity, err);
    }

    public void hideDialog() {
        mActivity.dismissLoadingDialog();
    }

    public void isEmptyToken() {
//        SPUtils.put(mActivity, "login", false);
//        SPUtils.put(mActivity, "login_token", "");
//        GlobalContants.TOKEN = "";
//        BaseApplication.getApplication().closeActivitys();
//        mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
    }
}
