package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    Button setButton;
    EditText text00, text01, text11, text10;
    MyBroadcastReceiver myBroadcastReceiver;
    IntentFilter intentFilter;

    private boolean containsNumber(String text) {
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(text).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        setButton = findViewById(R.id.button);
        text00 = findViewById(R.id.val00);
        text01 = findViewById(R.id.val01);
        text10 = findViewById(R.id.val10);
        text11 = findViewById(R.id.val11);

        setButton.setOnClickListener(v -> {
            //check if text texts are number
            String val00 = text00.getText().toString();
            String val01 = text01.getText().toString();
            String val10 = text10.getText().toString();
            String val11 = text11.getText().toString();

            if(containsNumber(val00) && containsNumber(val01) && containsNumber(val10) && containsNumber(val11)) {
                //start second activity
                Intent intent = new Intent(this, PracticalTest01Var07SecondActivity.class);
                intent.putExtra("val00", val00);
                intent.putExtra("val01", val01);
                intent.putExtra("val10", val10);
                intent.putExtra("val11", val11);
                startActivity(intent);
            }

        });

        Intent intent = new Intent(this, PracticalTest01Var07Service.class);
        startService(intent);

        myBroadcastReceiver = new MyBroadcastReceiver(text00, text01, text11, text10);

        intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ACTION_STRING);
    }

    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("val00", text00.getText().toString());
        savedInstanceState.putString("val01", text01.getText().toString());
        savedInstanceState.putString("val10", text10.getText().toString());
        savedInstanceState.putString("val11", text11.getText().toString());
    }

    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("val00")) {
            text00.setText(savedInstanceState.getString("val00"));
        }
        if (savedInstanceState.containsKey("val01")) {
            text01.setText(savedInstanceState.getString("val01"));
        }
        if (savedInstanceState.containsKey("val10")) {
            text10.setText(savedInstanceState.getString("val10"));
        }
        if (savedInstanceState.containsKey("val11")) {
            text11.setText(savedInstanceState.getString("val11"));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    protected void onResume() {

        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(myBroadcastReceiver, intentFilter, RECEIVER_EXPORTED);
        }
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myBroadcastReceiver);
        super.onPause();

    }
}