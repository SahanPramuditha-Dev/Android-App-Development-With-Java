package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class PortfolioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);

        MaterialCardView cardAbout = findViewById(R.id.cardAbout);
        MaterialCardView cardSkills = findViewById(R.id.cardSkills);
        MaterialCardView cardProjects = findViewById(R.id.cardProjects);
        MaterialCardView cardExperience = findViewById(R.id.cardExperience);
        MaterialCardView cardEducation = findViewById(R.id.cardEducation);
        MaterialCardView cardAchievements = findViewById(R.id.cardAchievements);
        MaterialButton btnContact = findViewById(R.id.btnContact);

        cardAbout.setOnClickListener(v -> startActivity(new Intent(this, AboutActivity.class)));
        cardSkills.setOnClickListener(v -> startActivity(new Intent(this, SkillsActivity.class)));
        cardProjects.setOnClickListener(v -> startActivity(new Intent(this, ProjectsActivity.class)));
        cardExperience.setOnClickListener(v -> startActivity(new Intent(this, ExperienceActivity.class)));
        cardEducation.setOnClickListener(v -> startActivity(new Intent(this, EducationActivity.class)));
        cardAchievements.setOnClickListener(v -> startActivity(new Intent(this, AchievementsActivity.class)));
        btnContact.setOnClickListener(v -> startActivity(new Intent(this, ContactActivity.class)));
    }
}
