package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.mobilecomputing.example.bluetoothmeshservice.MainActivity;
import com.mobilecomputing.example.bluetoothmeshservice.client.IDebugInterface;
import com.mobilecomputing.example.bluetoothmeshservice.client.INetworkEventsListener;
import com.mobilecomputing.example.bluetoothmeshservice.service.MeshnetworkService;

import java.util.List;

/**
 *
 * This client provides methods to communicate with the service.
 *
 *
 * Created by Jan Urbansky on 02.03.2016.
 */
public class BluetoothMeshnetworkClient {
    private static final String TAG = "fhflBTMeshClient";
    private INetworkEventsListener networkEventsListener = null;
    private IDebugInterface debugInterface = null;
    private MeshnetworkService mMeshnetworkService = null;
    private Activity mActivity;

    public void setDebugInterface(IDebugInterface debugInterface) {
        Log.d(TAG, "setDebugInterface");
        this.debugInterface = debugInterface;
    }





    public BluetoothMeshnetworkClient(Activity mActivity, INetworkEventsListener networkEventsListener) {
        Log.d(TAG, "BluetoothMeshnetworkClient");
        this.networkEventsListener = networkEventsListener;
        this.mActivity = mActivity;
    }

    /**
     * Use this in your activities' onResume method.
     */
    public void connectToMeshnetworkService()throws SecurityException{
        Log.i(TAG, "connecting to Meshnetwork Service");
        Log.d(TAG, "connectToMeshnetworkService");
        //First, start the service. Then bind to it. This results into a started service. The binding
        //enables a nice message interface. TODO: Test if service is already running!
        Intent meshNetworkServiceIntent = new Intent(mActivity, MeshnetworkService.class);

        Log.i(TAG, "starting Service");

        mActivity.startService(meshNetworkServiceIntent); //the service handles the evaluation of
                                                        //  multiple onStartCommands

        Log.i(TAG, "binding to Service");
        mActivity.bindService(meshNetworkServiceIntent, mConnection, Context.BIND_AUTO_CREATE);

    }

    public List<BluetoothDevice> getConnectedDevices(){
        return null;
    }

    public void setNetworkEventsListener(INetworkEventsListener networkEventsListener){
        Log.d(TAG, "setNetworkEventsListener");
        this.networkEventsListener = networkEventsListener;
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        private final static String TAG = "fhflBTServiceConnection";
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected");
            mMeshnetworkService = ((MeshnetworkService.MeshnetworkBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected");

        }
    };

    public void doSomeDebugging(){
        mMeshnetworkService.say_hello();
    }


    /**
     * Use this in your activities' onPause method.
     */
    public void disconnectFromMeshnetworkService(){
        Log.i(TAG, "disconnecting from Meshnetwork Service");
        Log.d(TAG, "disconnectFromMeshnetworkService");
        mActivity.unbindService(mConnection);
        mConnection = null;

    }

    public void stopMeshnetworkService(){

    }


}
