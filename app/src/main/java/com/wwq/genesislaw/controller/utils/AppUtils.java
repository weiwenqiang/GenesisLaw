package com.wwq.genesislaw.controller.utils;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2016/4/26.
 * 跟App相关的辅助类
 */
public class AppUtils {
    private AppUtils()
    {
            /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context)
    {
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context)
    {
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static int getVersionCode(Context context)
    {
        try
        {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionCode;

        } catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取设备SN
     * @return
     */
    public static String getSN() {
        String v = "";
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            v = (String) (get.invoke(c, "ro.serialno", "unknown"));
        } catch (Exception e) {
        }
        return v;
    }

    /**
     * 判断服务是否运行
     *
     * @param context
     * @param clazz
     *            要判断的服务的class
     * @return
     */
    public static boolean isServiceRunning(Context context,
                                           Class<? extends Service> clazz) {
        ActivityManager manager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningServiceInfo> services = manager.getRunningServices(100);
        for (int i = 0; i < services.size(); i++) {
            String className = services.get(i).service.getClassName();
            if (className.equals(clazz.getName())) {
                return true;
            }
        }
        return false;
    }
}