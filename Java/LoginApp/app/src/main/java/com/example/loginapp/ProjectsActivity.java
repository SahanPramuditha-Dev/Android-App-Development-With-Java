package com.example.loginapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
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

public class ProjectsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        View btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        LinearLayout container = findViewById(R.id.projectsContainer);
        if (container == null) return;
        container.removeAllViews();

        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Weather App", "A real-time weather forecasting app using OpenWeather API.", "Java, Retrofit, JSON", "https://github.com/sahan/weather-app"));
        projects.add(new Project("Task Manager", "An offline task management tool with SQLite database.", "Java, SQLite, XML", "https://github.com/sahan/task-manager"));
        projects.add(new Project("Portfolio App", "Personal portfolio app to showcase skills and projects.", "Java, Material Design", "https://github.com/sahan/portfolio-app"));

        for (Project project : projects) {
            addProjectView(container, project);
        }
    }

    private void addProjectView(LinearLayout container, Project project) {
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
        card.setClickable(true);
        card.setFocusable(true);

        LinearLayout innerLayout = new LinearLayout(this);
        innerLayout.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        innerLayout.setPadding(40, 40, 40, 40);

        TextView title = new TextView(this);
        title.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title.setText(project.getTitle());
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
        title.setTextColor(ContextCompat.getColor(this, R.color.primary));
        title.setTypeface(null, Typeface.BOLD);

        TextView tech = new TextView(this);
        tech.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tech.setText("Built with: " + project.getTech());
        tech.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        tech.setTextColor(ContextCompat.getColor(this, R.color.secondary));
        tech.setPadding(0, 8, 0, 16);

        TextView desc = new TextView(this);
        desc.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        desc.setText(project.getDescription());
        desc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        desc.setTextColor(ContextCompat.getColor(this, R.color.text_secondary));
        desc.setLineSpacing(1.1f, 1.1f);

        innerLayout.addView(title);
        innerLayout.addView(tech);
        innerLayout.addView(desc);
        card.addView(innerLayout);

        card.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(project.getGithubUrl()));
            startActivity(intent);
        });

        container.addView(card);
    }

    private static class Project {
        private String title, description, tech, githubUrl;
        public Project(String title, String description, String tech, String githubUrl) {
            this.title = title; this.description = description; this.tech = tech; this.githubUrl = githubUrl;
        }
        public String getTitle() { return title; }
        public String getDescription() { return description; }
        public String getTech() { return tech; }
        public String getGithubUrl() { return githubUrl; }
    }
}
