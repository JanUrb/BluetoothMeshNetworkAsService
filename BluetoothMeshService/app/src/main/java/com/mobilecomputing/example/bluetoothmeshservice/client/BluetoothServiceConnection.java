package com.mobilecomputing.example.bluetoothmeshservice.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class BluetoothServiceConnection implements ServiceConnection {
    protected BluetoothServiceConnection() {
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
