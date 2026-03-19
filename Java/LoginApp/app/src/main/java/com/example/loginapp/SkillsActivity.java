package com.example.loginapp;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.card.MaterialCardView;

public class SkillsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        LinearLayout container = findViewById(R.id.skillsContainer);
        if (container == null) return;
        
        container.removeAllViews();
        
        addSkillGroup(container, "Languages", new Skill[] {
                new Skill("Java", 85),
                new Skill("Python", 80),
                new Skill("JavaScript", 75),
                new Skill("HTML/CSS", 90)
        });
        
        addSkillGroup(container, "Frameworks & Databases", new Skill[] {
                new Skill("React.js", 70),
                new Skill("MySQL", 80),
                new Skill("Node.js", 65)
        });
        
        addSkillGroup(container, "Tools & Others", new Skill[] {
                new Skill("Adobe Photoshop", 75),
                new Skill("E-commerce Platforms", 85),
                new Skill("Git & GitHub", 80)
        });
    }

    private void addSkillGroup(LinearLayout container, String title, Skill[] skills) {
        TextView header = new TextView(this);
        header.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header.setText(title);
        header.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        header.setTextColor(ContextCompat.getColor(this, R.color.primary));
        header.setAllCaps(true);
        header.setLetterSpacing(0.1f);
        header.setPadding(16, 32, 16, 16);
        container.addView(header);

        MaterialCardView card = new MaterialCardView(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        cardParams.setMargins(0, 0, 0, 24);
        card.setLayoutParams(cardParams);
        card.setRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
        card.setCardBackgroundColor(ContextCompat.getColor(this, R.color.surface));
        card.setStrokeColor(ContextCompat.getColor(this, R.color.divider));
        card.setStrokeWidth(2);

        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setPadding(32, 32, 32, 32);

        for (Skill skill : skills) {
            addSkillItem(innerLayout, skill.getName(), skill.getLevel());
        }

        card.addView(innerLayout);
        container.addView(card);
    }

    private void addSkillItem(LinearLayout container, String name, int level) {
        LinearLayout skillRow = new LinearLayout(this);
        skillRow.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        skillRow.setOrientation(LinearLayout.VERTICAL);
        skillRow.setPadding(0, 0, 0, 24);

        TextView textView = new TextView(this);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(name);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textView.setTextColor(ContextCompat.getColor(this, R.color.text_primary));
        textView.setPadding(0, 0, 0, 8);

        ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 
                16);
        progressBar.setLayoutParams(params);
        progressBar.setMax(100);
        progressBar.setProgress(level);
        progressBar.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.primary)));
        progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.divider)));

        skillRow.addView(textView);
        skillRow.addView(progressBar);
        container.addView(skillRow);
    }

    private static class Skill {
        private String name;
        private int level;
        public Skill(String name, int level) { this.name = name; this.level = level; }
        public String getName() { return name; }
        public int getLevel() { return level; }
    }
}
