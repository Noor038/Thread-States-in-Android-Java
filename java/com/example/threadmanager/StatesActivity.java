package com.example.threadmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StatesActivity extends AppCompatActivity {

    TextView txtState;

    Boolean isCreated = false;
    Boolean isSleep = false;
    Boolean isBlocked = false;
    Boolean isWait = false;

    static String data = "I want monitor lock ;)";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);
        txtState = findViewById(R.id.statetxv);
        this.setTitle("Thread Managaer");
    }

    public void onBtnCreateClicked(View view) {
        //create, start thread
        //states { new, runnable, terminated}

        if (isCreated == true)
            Toast.makeText(getApplicationContext(), "The new thread has already been created :/", Toast.LENGTH_LONG).show();

        else {
            isCreated = true;
            Toast.makeText(getApplicationContext(), "Thread 1 is set for run() function! \n Plzz wait......", Toast.LENGTH_LONG).show();


            try {
                MyThread1 th1 = new MyThread1(data);

                txtState.append("\nButton Create and start Thread has been pressed!\nThe states followed by thread are :\n");
                txtState.append("   > " + th1.getState().toString());

                th1.start();
                txtState.append("   > " + th1.getState().toString());

                th1.sleep(5000);
                txtState.append("   > " + th1.getState().toString());
            } catch (Exception ex) {
                Log.e("TM", ex.getMessage());
            }
            txtState.append("\n_______________________________________\n");

        }
    }



   public void onBtnSleepClicked(View view) {
       //thread timed waiting
       //states followed will be {Timed waiting}

       if (isSleep == true)
           Toast.makeText(getApplicationContext(), "Thread 2 is already sleeping ;/", Toast.LENGTH_LONG).show();

       else {
           isSleep = true;
           Toast.makeText(getApplicationContext(), "Thread 2 is set for sleep() ! \n Plzz wait......", Toast.LENGTH_LONG).show();

           try {
               Thread.currentThread().sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           try {
               MyThread2 th2 = new MyThread2(data);
               th2.start();

               txtState.append("\nButton Sleep Thread has been pressed!\nThe current state of thread is :\n");
               txtState.append("   > " + th2.getState().toString());

           } catch (Exception ex) {
               Log.e("TM", ex.getMessage());
           }

           txtState.append("\n_______________________________________\n");
       }
   }


    public void onBtnWaitClicked(View view) {

        //thread waiting
        //state will be {waiting}

        if (isWait == true)
            Toast.makeText(getApplicationContext(), "Thread 4 is already on waiting ;/", Toast.LENGTH_LONG).show();

        else {
            isWait = true;
            Toast.makeText(getApplicationContext(), "Thread 4 is set for waiting ! \n Plzz wait......", Toast.LENGTH_LONG).show();

            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MyThread3 th3 = new MyThread3();
            th3.start();

            txtState.append("\nButton Wait Thread has been pressed!\nThe current state of thread is :\n");
            txtState.append("   > " + th3.getState().toString());
            txtState.append("\n_______________________________________\n");

            th3.end_wait();//thread frees synchronized block to end the indefinite wait


        }
    }

   public void onBtnBlockClicked(View view) {
        //thread blocking
       //state will be block

       if (isBlocked == true)
           Toast.makeText(getApplicationContext(), "Thread 3 already been blocked ;/", Toast.LENGTH_LONG).show();

       else {
           isBlocked = true;
           Toast.makeText(getApplicationContext(), "Thread 3 is set for blocking ! \n Plzz wait......", Toast.LENGTH_LONG).show();
           try {
               Thread.currentThread().sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           try {
               MyThread2 th4 = new MyThread2(data);
               MyThread1 th3 = new MyThread1(data);

               th4.start();

               th3.sleep(5000);
               th3.start();

               txtState.append("\nButton Block Thread has been pressed!\nThe current state of thread is :\n");
               txtState.append("   > " + th3.getState().toString());

           } catch (Exception ex) {
               Log.e("TM", ex.getMessage());
           }

           txtState.append("\n_______________________________________\n");
       }
   }
}
