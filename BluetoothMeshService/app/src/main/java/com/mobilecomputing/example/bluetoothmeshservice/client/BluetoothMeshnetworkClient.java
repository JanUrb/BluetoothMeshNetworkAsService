package com.mobilecomputing.example.bluetoothmeshservice.client;

import android.bluetooth.BluetoothDevice;

import java.util.List;

/**
 *
 * This client provides methods to communicate with the service.
 *
 *
 * Created by Jan Urbansky on 02.03.2016.
 */
public class BluetoothMeshnetworkClient {

    private INetworkEventsListener networkEventsListener;

    /**
     * Use this in your activities' onResume method.
     */
    public void connectToMeshnetworkService(){

    }

    public List<BluetoothDevice> getConnectedDevices(){
        return null;
    }

    public void setNetworkEventsListener(INetworkEventsListener networkEventsListener){
        this.networkEventsListener = networkEventsListener;
    }

    /**
     * Use this in your activities' onPause method.
     */
    public void disconnectFromMeshnetworkService(){

    }


}
