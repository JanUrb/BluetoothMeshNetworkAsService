package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class IncommingHandler extends Handler {
    private final static String TAG = "jaurIncommingHandler";

    protected IncommingHandler() {
        Log.d(TAG, "IncommingHandler()");
    }

    @Override
    public void handleMessage(Message msg) {
        Log.v(TAG, "handleMessage");
        super.handleMessage(msg);
    }
}
