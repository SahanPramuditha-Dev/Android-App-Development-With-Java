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

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tasks);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0); // Bottom padding handled by nav
            return insets;
        });

        // Add Task FAB functionality
        findViewById(R.id.fab).setOnClickListener(v -> showAddTaskDialog());

        // Navigation
        findViewById(R.id.nav_profile).setOnClickListener(v -> {
            startActivity(new Intent(this, ProfileActivity.class));
            finish();
        });

        findViewById(R.id.nav_about).setOnClickListener(v -> {
            startActivity(new Intent(this, AboutActivity.class));
            finish();
        });

        // Active state for Tasks tab
        findViewById(R.id.pill_tasks).setVisibility(android.view.View.VISIBLE);
        ((android.widget.TextView)findViewById(R.id.tv_tasks)).setTextColor(getResources().getColor(R.color.button_green));
        ((android.widget.ImageView)findViewById(R.id.iv_tasks)).setColorFilter(getResources().getColor(R.color.button_green));
    }

    private void showAddTaskDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add_task);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button btnCancel = dialog.findViewById(R.id.btn_cancel);
        Button btnAdd = dialog.findViewById(R.id.btn_add);

        btnCancel.setOnClickListener(v -> dialog.dismiss());
        btnAdd.setOnClickListener(v -> {
            // Logic to add task would go here
            dialog.dismiss();
        });

        dialog.show();
    }
}
