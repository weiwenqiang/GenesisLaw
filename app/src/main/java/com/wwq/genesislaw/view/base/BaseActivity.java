package com.wwq.genesislaw.view.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wwq.genesislaw.R;
import com.wwq.genesislaw.controller.utils.SPUtils;
import com.wwq.genesislaw.controller.utils.T;
import com.wwq.genesislaw.mvp.base.BasePresenter;

import org.xutils.x;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jpush.android.api.JPushInterface;
import cn.pedant.SweetAlert.SweetAlertDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by 魏文强 on 2017/2/18.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;
    private Unbinder unbinder;

    public abstract P onCreatePresenter();

    public static final List<BaseActivity> mActivityList = new LinkedList<BaseActivity>();

    private KillAllReceiver receiver;
    private SweetAlertDialog mLoadingDialog;


    private class KillAllReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResouceId());
        unbinder = ButterKnife.bind(this);
        //初始化xUtils3
        x.view().inject(this);

        ((BaseApplication) getApplication()).addActivity(this);

        receiver = new KillAllReceiver();
        IntentFilter filter = new IntentFilter("com.wwq.activity.killall");
        registerReceiver(receiver, filter);

        if (onCreatePresenter() != null) {
            mPresenter = onCreatePresenter();
        }
        synchronized (mActivityList) {//为了线程安全加同步锁
            mActivityList.add(this);
        }

        JPushInterface.init(BaseApplication.getApplication());
        initView();
        initData();
        initEvent();
    }

    /**
     * 设置根布局资源id
     */
    protected abstract int setLayoutResouceId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApplication) getApplication()).removeActivity(this);

        synchronized (mActivityList) {//为了线程安全加同步锁
            mActivityList.remove(this);
        }
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
        unbinder.unbind();
    }

    protected abstract void initView();
    protected void initData() {}
    protected void initEvent() {}

    //管理运行的所有activity
    public void killAll() {
        List<BaseActivity> copy;
        synchronized (mActivityList) {//为了线程安全加同步锁
            copy = new LinkedList<BaseActivity>(mActivityList);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        //杀死当前进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void showLoadingDialog() {
//        if (mLoadingDialog == null) {
//            mLoadingDialog = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
//            mLoadingDialog.setCustomImage(R.drawable.loading_anim);
//            mLoadingDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.colorPrimary));
//            mLoadingDialog.setCancelable(false);
//            mLoadingDialog.setTitleText("数据加载中...");
//        }
//        mLoadingDialog.show();
    }

    public void dismissLoadingDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void showDialog() {
        showLoadingDialog();
    }

    public void onFail(String err) {
        T.showShort(BaseApplication.getApplication(), err);
    }

    public void hideDialog() {
        dismissLoadingDialog();
    }

    public void isEmptyToken() {
//        SPUtils.put(BaseApplication.getApplication(), "login", false);
//        SPUtils.put(BaseApplication.getApplication(), "login_token", "");
//        GlobalContants.TOKEN = "";
//        BaseApplication.getApplication().closeActivitys();
//        startActivity(new Intent(this, LoginActivity.class));
    }
}
