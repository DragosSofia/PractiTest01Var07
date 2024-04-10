package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Random;

import ro.pub.cs.systems.eim.practicaltest01var07.Constants;

public class ProcessingThread extends Thread{
    private int sum;
    private Context context;
    private boolean isRunning = true;
    private double mediaArithmetic, mediaGeometrica;
    public ProcessingThread(Context context){
        this.context = context;
    }

    public void sendMessage(){
        Random random = new Random();
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_STRING);

        intent.putExtra(Constants.Val00, random.nextInt(100));
        intent.putExtra(Constants.Val01, random.nextInt(100));
        intent.putExtra(Constants.Val10, random.nextInt(100));
        intent.putExtra(Constants.Val11, random.nextInt(100));

        context.sendBroadcast(intent);
    }

    public void run(){
        while(isRunning){
            try{
                Log.d("PracticalTest01Service", "Sending brodcast mesage");
                sendMessage();
                sleep(10000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        isRunning = false;
    }
}
