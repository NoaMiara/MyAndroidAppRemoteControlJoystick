package com.example.androidappremotecontroljoystick.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidappremotecontroljoystick.R;

public class MainActivity extends AppCompatActivity {

    private String ip;
    private int port;
    private Button connectButton;
    private EditText editIp;
    private EditText editPort;
    private JoystickActivity joystick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, JoystickActivity.class);
        // find the ip and port
        editIp = (EditText) findViewById(R.id.IP);
        ip=editIp.toString();
        editPort = (EditText) findViewById(R.id.PORT);
       // port=editPort
        intent.putExtra("ip",editIp.getText().toString());
        intent.putExtra("port",editPort.getText().toString());
        sendJoystickActivity(intent);
    }

    public void sendJoystickActivity(Intent intent) {
        startActivity(intent);
    }

}
