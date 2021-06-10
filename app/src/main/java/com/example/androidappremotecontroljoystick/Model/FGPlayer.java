package com.example.androidappremotecontroljoystick.Model;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class FGPlayer {
    private String aileronSetCommand = "set controls/flight/aileron ";
    private String elavatorSetCommand = "set controls/flight/elevator ";
    private String rudderSetCommand = "set controls/flight/rudder ";
    private String throttleSetCommand = "set controls/flight/throttle ";

    private String ip;
    private int port;
    private Socket fg = null;
    private PrintWriter out;
    private static FGPlayer instance = null;

    //singleton design pattern
    public static FGPlayer getInstance() {
        if(instance == null){
            instance = new FGPlayer();
        }
        return instance;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    // connect server
    public void Connect() {
        //active object design pattern
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    InetAddress Ip = InetAddress.getByName(ip);
                    // create new socket
                    fg = new Socket(Ip, port);
                    out = new PrintWriter(fg.getOutputStream());
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void SendCommandsToSimulator(final String command)
    {
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    if (fg != null && out != null) {
                        out.print(command);
                        out.flush();
                    }
                }
                catch(Exception e) {
                    Log.e("TCP", "S: Error", e);
                }
            }
        };
        //separate thread for runnable
        Thread thread = new Thread(runnable);
        thread.start();
    }

    // close the connection with the server
    public void closeSocket() {
        try {
            if(fg != null) {
                fg.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}