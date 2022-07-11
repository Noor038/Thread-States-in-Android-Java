package com.example.threadmanager;

public class MyThread1 extends Thread {

    String data;

    MyThread1 (String data)
    {
        this.data = data;
    }


    public void run() {
        int i =0;

        while(i!=1000000)
        {
            i++;
        }

        synchronized (data){
            data = "I gained my Lock XD";
        }
    }
}

