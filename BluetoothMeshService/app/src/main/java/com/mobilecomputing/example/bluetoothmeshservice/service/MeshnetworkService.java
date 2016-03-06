package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class MeshnetworkService extends Service {

    private final static String TAG = "fhflMeshnetworkService";

    public static boolean IS_RUNNING = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service created!");
        Log.d(TAG, "onCreate");
        super.onCreate();
        IS_RUNNING = true;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service destroyed!");
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        IS_RUNNING = false; //TODO: not needed!
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }
}
