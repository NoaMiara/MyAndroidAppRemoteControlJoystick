package com.example.androidappremotecontroljoystick.View_Model;

import android.content.Context;
import android.view.View;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.androidappremotecontroljoystick.Views.JoystickActivity;


public class ViewModel extends View {
    private String aileronSetCommand = "set controls/flight/aileron ";
    private String elavatorSetCommand = "set controls/flight/elevator ";
    private String rudderSetCommand = "set controls/flight/rudder ";
    private String throttleSetCommand = "set controls/flight/throttle ";
    private float aileron;
    private float elevator;
    private float rudder;
    private float throttle;
    private JoystickActivity joystick;

    public ViewModel(Context context) {
        super(context);
        rudder=joystick.getRudder();
        throttle=joystick.getThrottle();
    }


    public void setAileron(float aileron) {
        this.aileron = aileron;
    }

    public void setElevator(float elevator) {
        this.elevator = elevator;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //לצייר את הגוייסטיק

    }

    public boolean onTouch(View v, MotionEvent motionEvent) {
       /*
        if(){
            //אם יש תזוזה של הגוייסטיק
             FGPlayer.getInstance().SendCommandsToSimulator(aileronSetCommand + aileron + "\r\n");
        FGPlayer.getInstance().SendCommandsToSimulator(elavatorSetCommand + elevator + "\r\n");
        FGPlayer.getInstance().SendCommandsToSimulator(rudderSetCommand + rudder + "\r\n");
        FGPlayer.getInstance().SendCommandsToSimulator(throttleSetCommand + throttle + "\r\n");
        }
       else{
        onDraw();
               FGPlayer.getInstance().SendCommandsToSimulator(aileronSetCommand + 0 + "\r\n");
        FGPlayer.getInstance().SendCommandsToSimulator(elavatorSetCommand + 0 + "\r\n");
        FGPlayer.getInstance().SendCommandsToSimulator(rudderSetCommand + 0 + "\r\n");
        FGPlayer.getInstance().SendCommandsToSimulator(throttleSetCommand + 0 + "\r\n");
        return true;
       }

        */

        return true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    }
}
