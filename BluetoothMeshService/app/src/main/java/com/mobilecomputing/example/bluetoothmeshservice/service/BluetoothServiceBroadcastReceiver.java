package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class BluetoothServiceBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "jaurBTServiceBroadRec";
    protected BluetoothServiceBroadcastReceiver() {
        Log.d(TAG, "BluetoothServiceBroadcastReceiver()");
    }



    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v(TAG, "onReceive");
        String action = intent.getAction();
        switch (action){
            case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                Log.d(TAG, "ACTION_DISCOVERY_STARTED");
                break;
            default:
                //empty
                break;

        }
    }
}
