package com.mobilecomputing.example.bluetoothmeshservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.mobilecomputing.example.bluetoothmeshservice.service.bluetooth.BluetoothComController;

/**
 * Created by Jan Urbansky on 02.03.2016.
 */
public final class MeshnetworkService extends Service {

    private final static String TAG = "fhflMeshnetworkService";

    private final IBinder mBinder = new MeshnetworkBinder();

    private BluetoothComController mBluetoothController = null;


    private boolean IS_RUNNING = false;

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
        IS_RUNNING = false; //not needed! -> if the service is killed, it has to be recreated
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        if(!IS_RUNNING){
            //do something
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mBluetoothController = new BluetoothComController();

                }
            }).start();
            IS_RUNNING = true;

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
