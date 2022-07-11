package com.example.threadmanager;


public class MyThread2 extends Thread{

    String data;

    MyThread2 (String data)
    {
        this.data = data;
    }



    public void run() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (data){
            data = "I gained my Lock XD";
            try {
                sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
