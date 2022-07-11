package com.example.threadmanager;

import android.util.Log;
import android.widget.TextView;

public class MyThread3 extends Thread{

    public void run() {
        try {
            synchronized (this) {
                wait();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    void end_wait(){
        try {
            synchronized (this) {
                notify();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
