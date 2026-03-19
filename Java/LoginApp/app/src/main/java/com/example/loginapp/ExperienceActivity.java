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

public class ExperienceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        LinearLayout container = findViewById(R.id.experienceContainer);
        if (container == null) return;
        container.removeAllViews();

        List<Experience> experienceList = new ArrayList<>();
        
        experienceList.add(new Experience(
                "E-Commerce Administrator & Website Manager",
                "Wybe Fashion",
                "Dec 2024 – Present",
                "Manages wybe.lk including product uploads, pricing, and catalog updates. Optimizes store performance and digital marketing to drive online sales."
        ));
        
        experienceList.add(new Experience(
                "Assistant Manager & Head Cashier",
                "Wybe Fashion",
                "Previous Role",
                "Led store staff and oversaw POS operations with high accuracy."
        ));

        experienceList.add(new Experience(
                "Production Systems Technician",
                "Star Garments Group",
                "Sep 2023 – Dec 2023",
                "Maintained Leadtec production tracking systems and ensured data logging reliability. Assisted industrial engineers with workflow optimization."
        ));

        for (Experience exp : experienceList) {
            addExperienceCard(container, exp);
        }
    }

    private void addExperienceCard(LinearLayout container, Experience exp) {
        MaterialCardView card = new MaterialCardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 
                ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(0, 0, 0, 24);
        card.setLayoutParams(cardParams);
        card.setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
        card.setCardElevation(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics()));
        card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface));
        card.setStrokeWidth(2);
        card.setStrokeColor(ContextCompat.getColor(this, R.color.divider));

        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setPadding(40, 40, 40, 40);

        TextView role = new TextView(this);
        role.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        role.setText(exp.getRole());
        role.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        role.setTextColor(ContextCompat.getColor(this, R.color.primary));
        role.setTypeface(null, Typeface.BOLD);

        TextView company = new TextView(this);
        company.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        company.setText(exp.getCompany());
        company.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        company.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        company.setPadding(0, 8, 0, 4);

        TextView duration = new TextView(this);
        duration.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        duration.setText(exp.getDuration());
        duration.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        duration.setTextColor(ContextCompat.getColor(this, R.color.accent));
        duration.setPadding(0, 0, 0, 16);

        TextView responsibilities = new TextView(this);
        responsibilities.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        responsibilities.setText(exp.getResponsibilities());
        responsibilities.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        responsibilities.setTextColor(ContextCompat.getColor(this, R.color.text_secondary));
        responsibilities.setLineSpacing(1.1f, 1.1f);

        innerLayout.addView(role);
        innerLayout.addView(company);
        innerLayout.addView(duration);
        innerLayout.addView(responsibilities);
        card.addView(innerLayout);
        container.addView(card);
    }
}
