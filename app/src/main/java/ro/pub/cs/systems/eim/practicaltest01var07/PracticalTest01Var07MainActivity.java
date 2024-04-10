package ro.pub.cs.systems.eim.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    Button setButton;
    EditText text00, text01, text11, text10;

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
    }
}