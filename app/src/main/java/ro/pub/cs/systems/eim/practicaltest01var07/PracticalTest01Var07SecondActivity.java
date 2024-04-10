package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var07SecondActivity extends AppCompatActivity {

    Button sumButton, prodButton;
    EditText text00, text01, text11, text10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_second);

        text00 = findViewById(R.id.val00);
        text01 = findViewById(R.id.val01);
        text10 = findViewById(R.id.val10);
        text11 = findViewById(R.id.val11);
        sumButton = findViewById(R.id.sum);
        prodButton = findViewById(R.id.prod);

        Intent intent = getIntent();

        text00.setText(intent.getStringExtra("val00"));
        text01.setText(intent.getStringExtra("val01"));
        text10.setText(intent.getStringExtra("val10"));
        text11.setText(intent.getStringExtra("val11"));

        sumButton.setOnClickListener(v -> {
            int val00 = Integer.parseInt(text00.getText().toString());
            int val01 = Integer.parseInt(text01.getText().toString());
            int val10 = Integer.parseInt(text10.getText().toString());
            int val11 = Integer.parseInt(text11.getText().toString());

            int sum = val00 + val01 + val10 + val11;

            Toast.makeText(this, "Sum:  " + sum , Toast.LENGTH_LONG).show();
        });

        prodButton.setOnClickListener(v -> {
            int val00 = Integer.parseInt(text00.getText().toString());
            int val01 = Integer.parseInt(text01.getText().toString());
            int val10 = Integer.parseInt(text10.getText().toString());
            int val11 = Integer.parseInt(text11.getText().toString());

            int prod = val00 * val01 * val10 * val11;

            Toast.makeText(this, "Prod:  " + prod , Toast.LENGTH_LONG).show();
        });

    }
}