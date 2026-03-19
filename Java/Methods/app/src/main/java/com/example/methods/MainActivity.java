package com.example.methods;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        showToast("onCreate called");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Button Clicked!");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy called");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
