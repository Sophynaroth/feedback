package com.roth.cs.bottomnavigation.ui.post;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.roth.cs.bottomnavigation.R;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Post extends AppCompatActivity {
    ImageView back;
    ImageView image_pick;
    ImageView btn_pick_image;
    TextView post;
    EditText caption;
    private int  PICK_IMAGE = 101;
    Uri imageUri;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caption_post);
        back = findViewById(R.id.back);
        post = findViewById(R.id.post);
        caption = findViewById(R.id.write_title);
        btn_pick_image = findViewById(R.id.btn_pick_image);
        image_pick = findViewById(R.id.image_pick);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_pick_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();

            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //need some code to work
                finish();
            }
        });

    }
    private void openGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data!=null){
            imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                image_pick.setImageBitmap(bitmap);
                image_pick.setVisibility(View.VISIBLE);
                caption.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

