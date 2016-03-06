package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;


/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class BluetoothServiceConnection implements ServiceConnection {
    private final static String TAG = "fhflBTServiceConnection";
    private Messenger mServiceMessenger = null;
    private boolean mBound = false;

    protected BluetoothServiceConnection() {

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "onServiceConnected");
        mServiceMessenger = new Messenger(service);
        mBound = true;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d(TAG, "onServiceDisconnected");
        mServiceMessenger = null;
        mBound = false;
    }

    public boolean isBound() {
        return mBound;
    }
}
