package com.example.androidappremotecontroljoystick.Model;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class FGPlayer {

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
        try{
            Thread thread = new Thread(() -> {
                try {
                    fg = new Socket(ip, port);
                    System.out.println("noa");
                    out = new PrintWriter(fg.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void SendCommandsToSimulator(final String command) {
        try{
            Thread thread = new Thread(() -> {
                try {
                    if (fg != null && out != null) {
                        out.print(command);
                        System.out.println(command);
                        out.flush();
                    }
                } catch (Exception e) {
                    Log.e("TCP", "S: Error", e);
                }
            });
            thread.start();
            thread.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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