package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class ContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ImageButton btnBack = findViewById(R.id.btnBack);
        MaterialButton btnShareContact = findViewById(R.id.btnShareContact);

        btnBack.setOnClickListener(v -> finish());

        btnShareContact.setOnClickListener(v -> {
            String contactInfo = "Contact Details:\n" +
                    "Email: contact.sahanpramuditha@gmail.com\n" +
                    "Phone: +94 76 415 8980\n" +
                    "GitHub: SahanPramuditha-Dev\n" +
                    "Portfolio: sahanpramuditha.me";

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, contactInfo);
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });
    }
}
