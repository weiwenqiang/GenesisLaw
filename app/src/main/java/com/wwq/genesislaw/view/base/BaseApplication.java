package com.wwq.genesislaw.view.base;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.multidex.MultiDex;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.navi.AMapNavi;
import com.dou361.dialogui.DialogUIUtils;
import com.squareup.leakcanary.LeakCanary;
import com.wwq.genesislaw.R;
import com.wwq.genesislaw.controller.library.typefacehelper.TypefaceCollection;
import com.wwq.genesislaw.controller.library.typefacehelper.TypefaceHelper;
import com.wwq.genesislaw.view.widget.custom.CustomViewWithTypefaceSupport;
import com.wwq.genesislaw.view.widget.custom.TextField;

import org.xutils.x;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.sms.SMSSDK;
import cn.sharesdk.framework.ShareSDK;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by 魏文强 on 2017/2/18.
 */

public class BaseApplication extends Application {
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;

    private List<Activity> activitys = new LinkedList<Activity>();
    private List<Service> services = new LinkedList<Service>();

    private TypefaceCollection microsoftAccor;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mainTid = android.os.Process.myTid();
        handler = new Handler();
        //xUtils3 初始化
        x.Ext.init(this);
//		x.Ext.setDebug(BuildConfig.DEBUG); // 开启debug会影响性能
        //极光初始化
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
        //发短信初始化
        SMSSDK.getInstance().initSdk(this);
        SMSSDK.getInstance().setIntervalTime(60000);
        //分享初始化
        ShareSDK.initSDK(this);
        //初始化字体
        initTypeface();
        //内存检测初始化
        LeakCanary.install(this);
        //对话框初始化
        DialogUIUtils.init(this);
        //高德地图初始化-定位
        AMapLocationClient.setApiKey("4b54bfbc246ad250504df0fd1d1d07fb");
        //高德地图初始化-导航
        AMapNavi.setApiKey(this, "4b54bfbc246ad250504df0fd1d1d07fb");
    }

    public void addActivity(Activity activity) {
        activitys.add(activity);
    }

    public void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }

    public void closeApplication() {
        closeActivitys();
        closeServices();
//		Process.killProcess(pid);
    }

    public void closeActivitys() {
        ListIterator<Activity> iterator = activitys.listIterator();
        while (iterator.hasNext()) {
            Activity activity = iterator.next();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private void closeServices() {
        ListIterator<Service> iterator = services.listIterator();
        while (iterator.hasNext()) {
            Service service = iterator.next();
            if (service != null) {
                stopService(new Intent(this, service.getClass()));
            }
        }
    }

    public static BaseApplication getApplication() {
        return application;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static Handler getHandler() {
        return handler;
    }

    private void initTypeface() {
        microsoftAccor = new TypefaceCollection.Builder()
                .set(Typeface.NORMAL, Typeface.createFromAsset(getAssets(), "fonts/microsoft_accor.ttf"))
                .create();
        TypefaceHelper.init(microsoftAccor);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/microsoft_accor.ttf")
                .setFontAttrId(R.attr.fontPath)
                .addCustomViewWithSetTypeface(CustomViewWithTypefaceSupport.class)
                .addCustomStyle(TextField.class, R.attr.textFieldStyle)
                .build()
        );
    }

    public TypefaceCollection getMicrosoftAccor() {
        return microsoftAccor;
    }
}
