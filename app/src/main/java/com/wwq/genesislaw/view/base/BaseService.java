package com.wwq.genesislaw.view.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by wwq on 2017/2/24.
 */

public class BaseService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ((BaseApplication)getApplication()).addService(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((BaseApplication)getApplication()).removeService(this);
    }
}
