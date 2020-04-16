package com.roth.cs.bottomnavigation.ui.post;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.roth.cs.bottomnavigation.R;
import com.squareup.picasso.Picasso;

public class ViewPostImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton btnBack;
        ImageView mImage;
        TextView mTitle;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post_image);
        btnBack = findViewById(R.id.btnBack);
        mImage = findViewById(R.id.mImage);
        mTitle = findViewById(R.id.mTitle);
        Intent intent = getIntent();
        String imageURL = intent.getStringExtra("imageURL");
        String imageName = intent.getStringExtra("imageName");
        Picasso.get().load(imageURL).into(mImage);
        mTitle.setText(imageName);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
