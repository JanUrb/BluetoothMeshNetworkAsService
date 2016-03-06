package com.mobilecomputing.example.bluetoothmeshservice.client;

import android.bluetooth.BluetoothDevice;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public interface INetworkEventsListener {
    /**
     * Is called when a device directly connects to the client device.
     * @param bluetoothDevice
     */
    public void onDeciveConnected(BluetoothDevice bluetoothDevice);

    /**
     * Is called when a directly connected device disconnects.
     * @param bluetoothDevice
     */
    public void onDeviceDisconnected(BluetoothDevice bluetoothDevice);

    /**
     * Is called when the client receives a message directed at it.
     * TODO: Implement Argument
     */
    public void onMessageReceived();

    /**
     * Is called in case of receiving messages not directed at the client.
     */
    public void onMessageTrafficReceived();
}
