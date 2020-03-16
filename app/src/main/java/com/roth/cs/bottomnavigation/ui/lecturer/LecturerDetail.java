package com.roth.cs.bottomnavigation.ui.lecturer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.roth.cs.bottomnavigation.R;
import com.squareup.picasso.Picasso;

public class LecturerDetail extends AppCompatActivity {

    public ImageView lecturerImg;
    public TextView lecturerName, jobTile, major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_detail);

        lecturerImg = findViewById(R.id.profile_image);
        lecturerName = findViewById(R.id.lecturer_name);
        jobTile = findViewById(R.id.job_title);
        major = findViewById(R.id.major);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String mLecturerName = intent.getStringExtra("Lecturer_Name");
        String mMajor = intent.getStringExtra("Major");
        String mJobTile = intent.getStringExtra("Job_Title");

        Picasso.get().load(url).into(lecturerImg);
        lecturerName.setText(mLecturerName);
        jobTile.setText(mJobTile);
        major.setText(mMajor);

    }
}
