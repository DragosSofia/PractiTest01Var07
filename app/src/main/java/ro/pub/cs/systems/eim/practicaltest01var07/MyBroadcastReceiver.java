package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

public class MyBroadcastReceiver extends BroadcastReceiver {
    EditText text00, text01, text11, text10;

    public MyBroadcastReceiver(EditText text00, EditText text01, EditText text11, EditText text10) {
        this.text00 = text00;
        this.text01 = text01;
        this.text11 = text11;
        this.text10 = text10;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //get the media arithmetic and media geometrica
        int val00 = intent.getIntExtra(Constants.Val00, 0);
        int val01 = intent.getIntExtra(Constants.Val01, 0);
        int val10 = intent.getIntExtra(Constants.Val10, 0);
        int val11 = intent.getIntExtra(Constants.Val11, 0);

        Log.d("PracticalTest01Service", "onReceive: " + val00 + " " + val01 + " " + val10 + " " + val11);

        //write the values in edittext fields
        text00.setText(String.valueOf(val00));
        text01.setText(String.valueOf(val01));
        text10.setText(String.valueOf(val10));
        text11.setText(String.valueOf(val11));

    }
}