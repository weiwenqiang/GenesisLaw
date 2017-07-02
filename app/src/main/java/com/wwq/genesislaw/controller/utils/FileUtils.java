package com.wwq.genesislaw.controller.utils;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by 魏文强 on 2016/11/3.
 */
public class FileUtils {


    public static final String CACHE = "cache";
    public static final String ICON = "icon";
    public static final String ROOT = "GooglePlay";

    /**
     * 获取图片的缓存的路径
     *
     * @return
     */
    public static File getIconDir() {
        return getDir(ICON);

    }

    /**
     * 获取缓存路径
     *
     * @return
     */
    public static File getCacheDir() {
        return getDir(CACHE);
    }

    public static File getDir(String cache) {
        StringBuilder path = new StringBuilder();
        if (isSDAvailable()) {
            path.append(Environment.getExternalStorageDirectory()
                    .getAbsolutePath());
            path.append(File.separator);// '/'
            path.append(ROOT);// /mnt/sdcard/GooglePlay
            path.append(File.separator);
            path.append(cache);// /mnt/sdcard/GooglePlay/cache

        } else {
            File filesDir = UiUtils.getContext().getCacheDir();    //  cache  getFileDir file
            path.append(filesDir.getAbsolutePath());// /data/data/com.itheima.googleplay/cache
            path.append(File.separator);///data/data/com.itheima.googleplay/cache/
            path.append(cache);///data/data/com.itheima.googleplay/cache/cache
        }
        File file = new File(path.toString());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();// 创建文件夹
        }
        return file;

    }

    private static boolean isSDAvailable() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static File uri2File(Activity activity, Uri uri) {
        File file = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor actualimagecursor = activity.managedQuery(uri, proj, null,
                null, null);
        int actual_image_column_index = actualimagecursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        actualimagecursor.moveToFirst();
        String img_path = actualimagecursor
                .getString(actual_image_column_index);
        file = new File(img_path);
        return file;
    }
}
