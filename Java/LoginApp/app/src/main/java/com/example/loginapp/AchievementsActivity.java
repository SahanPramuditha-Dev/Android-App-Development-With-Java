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

public class AchievementsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        LinearLayout container = findViewById(R.id.achievementsContainer);
        if (container == null) return;
        container.removeAllViews();

        addAchievement(container, "Quiz Runner-Up", "\"Do You Know?\" Zonal Quiz - 2018");
        addAchievement(container, "Leadership", "President of the Under-16 Student Club and Scout Association Member");
        addAchievement(container, "Sports", "Member of the Basketball Team during school");
    }

    private void addAchievement(LinearLayout container, String title, String desc) {
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

        TextView titleTv = new TextView(this);
        titleTv.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        titleTv.setText(title);
        titleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        titleTv.setTextColor(ContextCompat.getColor(this, R.color.primary));
        titleTv.setTypeface(null, Typeface.BOLD);

        TextView descTv = new TextView(this);
        descTv.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        descTv.setText(desc);
        descTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        descTv.setTextColor(ContextCompat.getColor(this, R.color.text_secondary));
        descTv.setPadding(0, 12, 0, 0);
        descTv.setLineSpacing(1.1f, 1.1f);

        innerLayout.addView(titleTv);
        innerLayout.addView(descTv);
        card.addView(innerLayout);
        container.addView(card);
    }
}
