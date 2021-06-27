package com.example.androidappremotecontroljoystick.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.androidappremotecontroljoystick.R;
import com.example.androidappremotecontroljoystick.View_Model.ViewModel;

public class MainActivity extends AppCompatActivity {

    private String ip;
    private int port;
    private Button connectButton;
    private EditText editIp;
    private EditText editPort;
    private ViewModel viewModel = new ViewModel();
    private View.OnClickListener btnClick;
    private SeekBar rudder;
    private SeekBar throttle;
    private JoystickActivity joystickActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent intent = new Intent(this, JoystickActivity.class);
        // find the ip and port
        editIp = findViewById(R.id.IP);
        editPort = findViewById(R.id.PORT);
        connectButton = findViewById(R.id.CONNECT);
        joystickActivity = (JoystickActivity) findViewById(R.id.joystick);
        joystickActivity.myOnChange=(a,e)->{
            viewModel.setAileron((float) ((a * 2 - 500) / 360));
            viewModel.setElevator((float) ((e * 2 - 500) / 360));

        };
        //declaring OnClickListener as an object
        btnClick = v -> {
            ip = editIp.getText().toString();
            port = Integer.parseInt(editPort.getText().toString());
            viewModel.connect(ip, port);
        };
        connectButton.setOnClickListener(btnClick);
        rudder = findViewById(R.id.rudder);

        rudder.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                viewModel.setRudder(progress);
            }
        });
        throttle = findViewById(R.id.throttle);
        throttle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                viewModel.setThrottle(progress);
            }
        });

    }

    public void connect() {

    }

    public void sendJoystickActivity(Intent intent) {
        startActivity(intent);
    }

}
