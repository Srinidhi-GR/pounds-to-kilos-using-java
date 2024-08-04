package com.example.poundstokilos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView welcomeTxt, result;
    Button button;
    EditText userInput;
    int pound = 0;

    public static double poundsToKilo(double pounds) {
        return (pounds * 0.45359237);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        welcomeTxt = findViewById(R.id.welcomeTxt);
        result = findViewById(R.id.result);
        button = findViewById(R.id.button);
        userInput = findViewById(R.id.userInput);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pound = Integer.parseInt(userInput.getText().toString());
                result.setText(""+poundsToKilo(pound));
            }
        });

    }
}