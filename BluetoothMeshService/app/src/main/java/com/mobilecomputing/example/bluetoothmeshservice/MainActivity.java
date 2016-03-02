package com.mobilecomputing.example.bluetoothmeshservice;

import android.app.Activity;
import android.os.Bundle;

import com.mobilecomputing.example.bluetoothmeshservice.client.BluetoothMeshnetworkClient;

public class MainActivity extends Activity {

    private BluetoothMeshnetworkClient meshnetworkClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        meshnetworkClient = new BluetoothMeshnetworkClient();
        meshnetworkClient.connectToMeshnetworkService();
    }

    @Override
    protected void onPause() {
        meshnetworkClient.disconnectFromMeshnetworkService();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
