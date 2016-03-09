package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.mobilecomputing.example.bluetoothmeshservice.service.bluetooth.BluetoothComController;
import com.mobilecomputing.example.bluetoothmeshservice.service.bluetooth.BluetoothModel;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class MeshnetworkService extends Service {

    private final static String TAG = "fhflMeshnetworkService";

    private final IBinder mBinder = new MeshnetworkBinder();

    private BluetoothComController mBluetoothController = null;
    private BluetoothModel mBluetoothModel = null;


    private boolean IS_STARTED = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service created!");
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service destroyed!");
        Log.d(TAG, "onDestroy");
        super.onDestroy();
        IS_STARTED = false; //not needed! -> if the service is killed, it has to be recreated
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        if(!IS_STARTED){
            Log.d(TAG, "IS_STARTED == FALSE");
            IS_STARTED = true;
            Log.i(TAG, "Starting thread");
            mBluetoothController = new BluetoothComController();
            mBluetoothModel = new BluetoothModel();
            mBluetoothController.init(this, mBluetoothModel);
            //do something
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /*Log.i(TAG, "Starting thread");
                    mBluetoothController = new BluetoothComController();
                    mBluetoothModel = new BluetoothModel();
                    mBluetoothController.init(new Activity(), mBluetoothModel);*/

                }
            }).start();


        }
        return Service.START_STICKY;
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
        return mBinder;
    }

    public void say_hello(){
        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
    }





    public class MeshnetworkBinder extends Binder{
        MeshnetworkService getService(){
            return MeshnetworkService.this;
        }
    }
}
