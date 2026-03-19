package com.example.loginapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

public class EducationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        LinearLayout container = findViewById(R.id.educationContainer);
        if (container == null) return;
        container.removeAllViews();

        List<Education> educationList = new ArrayList<>();
        educationList.add(new Education(
                "University of Colombo - Faculty of Technology",
                "Sep 2024 – Expected Sep 2028",
                "Bachelor of Information and Communication Technology (BICT)",
                "Focus: System & Network Administration, Database Management, DevOps, and Cloud Computing. Coursework: Operating Systems, Programming, Computer Networks, and Databases."
        ));
        
        educationList.add(new Education(
                "Secondary Education",
                "G.C.E. A/L",
                "Engineering Technology Stream",
                "Z-Score: 2.0519 (Island Rank 343). A's in ICT, Science for Technology, and General English."
        ));

        for (Education edu : educationList) {
            addEducationView(container, edu);
        }
    }

    private void addEducationView(LinearLayout container, Education edu) {
        MaterialCardView card = new MaterialCardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(0, 0, 0, 24);
        card.setLayoutParams(cardParams);
        card.setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
        card.setCardElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));
        card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface));
        card.setStrokeColor(ContextCompat.getColor(this, R.color.divider));
        card.setStrokeWidth(2);

        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setPadding(32, 32, 32, 32);

        TextView inst = new TextView(this);
        inst.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        inst.setText(edu.getInstitution());
        inst.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        inst.setTextColor(ContextCompat.getColor(this, R.color.primary));
        inst.setTypeface(null, Typeface.BOLD);

        TextView degree = new TextView(this);
        degree.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        degree.setText(edu.getDegree());
        degree.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        degree.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        degree.setPadding(0, 8, 0, 4);

        TextView duration = new TextView(this);
        duration.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        duration.setText(edu.getDuration());
        duration.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        duration.setTextColor(ContextCompat.getColor(this, R.color.accent));
        duration.setPadding(0, 0, 0, 12);

        TextView desc = new TextView(this);
        desc.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        desc.setText(edu.getDescription());
        desc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        desc.setTextColor(ContextCompat.getColor(this, R.color.text_secondary));
        desc.setLineSpacing(1.1f, 1.1f);

        innerLayout.addView(inst);
        innerLayout.addView(degree);
        innerLayout.addView(duration);
        innerLayout.addView(desc);
        
        card.addView(innerLayout);
        container.addView(card);
    }
}
