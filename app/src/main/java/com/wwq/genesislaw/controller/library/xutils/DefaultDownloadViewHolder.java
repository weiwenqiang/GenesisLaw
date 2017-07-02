package com.wwq.genesislaw.controller.library.xutils;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import com.wwq.genesislaw.view.base.BaseApplication;

import org.xutils.common.Callback;
import org.xutils.x;

import java.io.File;

/**
 * Created by wyouflf on 15/11/11.
 */
public class DefaultDownloadViewHolder extends DownloadViewHolder {

    public DefaultDownloadViewHolder(View view, DownloadInfo downloadInfo) {
        super(view, downloadInfo);
    }

    @Override
    public void onWaiting() {

    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onLoading(long total, long current) {

    }

    @Override
    public void onSuccess(File result) {
        Toast.makeText(x.app(), "下载完成", Toast.LENGTH_LONG).show();
        if(result.getName().endsWith(".apk")){
            Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(result),
                    "application/vnd.android.package-archive");
            BaseApplication.getApplication().startActivity(intent);
        }
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Toast.makeText(x.app(), "下载失败", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCancelled(Callback.CancelledException cex) {
    }
}

