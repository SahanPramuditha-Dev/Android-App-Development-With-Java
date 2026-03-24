package com.example.tasky;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class DevInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_info);

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());

        MaterialButton btnExit = findViewById(R.id.btn_exit);
        btnExit.setOnClickListener(v -> finishAffinity());
    }
}