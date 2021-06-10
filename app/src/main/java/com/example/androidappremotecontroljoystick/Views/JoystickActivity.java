package com.example.androidappremotecontroljoystick.Views;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import com.example.androidappremotecontroljoystick.Model.FGPlayer;
import com.example.androidappremotecontroljoystick.R;

public class JoystickActivity extends AppCompatActivity {

    private float aileron;
    private float elevator;
    private float rudder;
    private float throttle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // find the rudder and throttle
        SeekBar rudderSeekBar=(SeekBar)findViewById(R.id.rudder);
        rudder=rudderSeekBar.getProgress();
        SeekBar throttleSeekBar=(SeekBar)findViewById(R.id.throttle);
        throttle=throttleSeekBar.getProgress();
        super.onCreate(savedInstanceState);
        FGPlayer.getInstance().Connect();
        setContentView(R.layout.activity_joystick);
    }

    public float getRudder() {
        return this.rudder;
    }

    public float getThrottle() {
        return this.throttle;
    }

    protected void onDestroy() {
        super.onDestroy();
        FGPlayer.getInstance().closeSocket();
    }
}
