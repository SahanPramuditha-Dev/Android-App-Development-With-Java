package com.example.tasky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MaterialButton btnCreateAccount = findViewById(R.id.btn_create_account);
        TextView tvSignIn = findViewById(R.id.tv_sign_in);

        btnCreateAccount.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, MainActivity.class));
            finishAffinity();
        });

        tvSignIn.setOnClickListener(v -> finish());
    }
}