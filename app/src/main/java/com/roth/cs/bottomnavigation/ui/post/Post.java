package com.roth.cs.bottomnavigation.ui.post;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.roth.cs.bottomnavigation.LecturerModel.LecturerModel;
import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.postModel.PostModel;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Post extends AppCompatActivity {
    ImageView back;
    ImageView set_image;
    ImageView btn_pick_image;
    TextView post;
    EditText caption;
    Uri FilePathUri;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    private static final int PICK_IMAGE_REQUEST = 1;
    ProgressBar progressBar;
    StorageTask UploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caption_post);
        back = findViewById(R.id.back);
        post = findViewById(R.id.post);
        caption = findViewById(R.id.write_title);
        btn_pick_image = findViewById(R.id.btn_pick_image);
        set_image = findViewById(R.id.set_image);
        storageReference = FirebaseStorage.getInstance().getReference("Images");
        databaseReference = FirebaseDatabase.getInstance().getReference("Images");

        btn_pick_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (UploadTask != null && UploadTask.isInProgress()){
                    Toast.makeText(Post.this, "Upload in progress", Toast.LENGTH_LONG).show();
                }
                else{
                    uploadFile();
                    finish();



                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode== RESULT_OK && data != null && data.getData() !=null ){
            FilePathUri = data.getData();
            Picasso.get().load(FilePathUri).into(set_image);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile(){
        if (FilePathUri != null){
            StorageReference fileReference = storageReference.child(System.currentTimeMillis()+"."+getFileExtension(FilePathUri));

            UploadTask = fileReference.putFile(FilePathUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
//                                    progressBar.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(Post.this,"Upload successful", Toast.LENGTH_LONG).show();
                            //Upload upload = new Upload(mLecturerName.getText().toString().trim(),taskSnapshot.toString());
                            taskSnapshot.getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Uri downloadUri = uri;
                                    Log.e("Download URI",downloadUri.toString());
                                    PostModel model = new PostModel();

                                    //Upload upload = new Upload();
                                    model.setImageURL(downloadUri.toString());
                                    model.setImageName(caption.getText().toString().trim());
                                    String uploadId = databaseReference.push().getKey();
                                    databaseReference.child(uploadId).setValue(model);
                                }
                            });


                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Post.this,e.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            //progressBar.setProgress((int) progress);
                        }
                    });
        }
        else {
            Toast.makeText(this,"No file selected",Toast.LENGTH_LONG).show();
        }
    }
}

