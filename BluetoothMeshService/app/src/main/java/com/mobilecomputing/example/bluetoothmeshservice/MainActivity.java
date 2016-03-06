package com.mobilecomputing.example.bluetoothmeshservice;

/**
 * Example usage!
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mobilecomputing.example.bluetoothmeshservice.service.BluetoothMeshnetworkClient;

public class MainActivity extends Activity {
    private static final String TAG = "fhflMainActivity";

    private BluetoothMeshnetworkClient meshnetworkClient;

    private Button startServiceButton, bindServiceButton, unbindButton, sendMessageViaBound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startServiceButton = (Button) findViewById(R.id.startServiceButton);
        bindServiceButton = (Button) findViewById(R.id.bindServiceButton);
        unbindButton = (Button) findViewById(R.id.unbindButton);
        sendMessageViaBound = (Button) findViewById(R.id.sendMessageViaBound);


        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindServiceButton.setEnabled(true);
                try{
                    meshnetworkClient.connectToMeshnetworkService();

                }catch (SecurityException e){
                    Log.e(TAG, e.getMessage());
                }

            }
        });

        bindServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindServiceButton.setEnabled(false);
                unbindButton.setEnabled(true);
                sendMessageViaBound.setEnabled(true);
                meshnetworkClient.connectToMeshnetworkService();
            }
        });

        unbindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindServiceButton.setEnabled(true);
                unbindButton.setEnabled(false);
                sendMessageViaBound.setEnabled(false);
                meshnetworkClient.disconnectFromMeshnetworkService();
            }
        });

        sendMessageViaBound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        meshnetworkClient = new BluetoothMeshnetworkClient(this, null); //Todo: Transistent storage!

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
