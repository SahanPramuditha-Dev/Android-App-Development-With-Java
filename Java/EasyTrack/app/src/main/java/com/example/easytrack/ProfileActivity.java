package com.example.easytrack;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0); // Bottom handled by nav
            return insets;
        });

        findViewById(R.id.btn_edit_info).setOnClickListener(v -> showEditInfoDialog());
        findViewById(R.id.btn_sign_out).setOnClickListener(v -> showSignOutDialog());

        // Navigation
        findViewById(R.id.nav_tasks).setOnClickListener(v -> {
            startActivity(new Intent(this, TasksActivity.class));
            finish();
        });

        findViewById(R.id.nav_about).setOnClickListener(v -> {
            startActivity(new Intent(this, AboutActivity.class));
            finish();
        });

        // Active state for Profile tab
        findViewById(R.id.pill_profile).setVisibility(android.view.View.VISIBLE);
        ((android.widget.TextView)findViewById(R.id.tv_profile)).setTextColor(getResources().getColor(R.color.button_green));
        ((android.widget.ImageView)findViewById(R.id.iv_profile)).setColorFilter(getResources().getColor(R.color.button_green));
    }

    private void showEditInfoDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit_info);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnSave = dialog.findViewById(R.id.btn_save);

        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnSave.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void showSignOutDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sign_out);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnSignOutConfirm = dialog.findViewById(R.id.btn_sign_out_confirm);

        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnSignOutConfirm.setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        dialog.show();
    }
}
