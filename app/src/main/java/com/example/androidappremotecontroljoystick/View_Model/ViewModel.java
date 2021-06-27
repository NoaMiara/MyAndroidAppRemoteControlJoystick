package com.example.androidappremotecontroljoystick.View_Model;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.androidappremotecontroljoystick.Model.FGPlayer;
import com.example.androidappremotecontroljoystick.Views.JoystickActivity;


public class ViewModel{
    private String aileronSetCommand = "set controls/flight/aileron ";
    private String elavatorSetCommand = "set controls/flight/elevator ";
    private float aileron;
    private float elevator;
    private FGPlayer fgPlayer=new FGPlayer();




    public void setAileron(float aileron) {
        String commend = "set controls/flight/aileron "+aileron+"\r\n";
        fgPlayer.SendCommandsToSimulator(commend);
    }

    public void setElevator(float elevator) {
        this.elevator = elevator;
        String commend = "set controls/flight/elevator "+elevator+"\r\n";
        fgPlayer.SendCommandsToSimulator(commend);
    }


    public void connect(String ip, int port) {
        fgPlayer.setIp(ip);
        fgPlayer.setPort(port);
        fgPlayer.Connect();
    }

    public void setRudder(int progress) {
        float f=(float)progress;
        String r= "set controls/flight/rudder " + (f-50)/50 + "\r\n";
        fgPlayer.SendCommandsToSimulator(r);
    }

    public void setThrottle(int progress) {
        float f=(float)progress;
        String t= "set /controls/engines/current-engine/throttle " + f/100 + "\r\n";
        fgPlayer.SendCommandsToSimulator(t);
    }
}