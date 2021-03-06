package com.drowsyatmidnight.client;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by haint on 29/06/2017.
 */

public class RestApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(new FlowConfig.Builder(this).build());
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.V);

        RestApplication.context = this;
    }

    public static RestClient getRestClient(){
        return (RestClient) RestClient.getInstance(RestClient.class, RestApplication.context);
    }
}
