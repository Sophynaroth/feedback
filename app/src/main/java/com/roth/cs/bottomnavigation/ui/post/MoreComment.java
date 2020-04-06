package com.roth.cs.bottomnavigation.ui.post;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.postAdapter.CommentAdapter;
import com.roth.cs.bottomnavigation.postModel.CommentModel;

import java.util.ArrayList;

public class MoreComment extends AppCompatActivity {
    RecyclerView recyclerViewComment;
    CommentAdapter commentAdapter;
    ArrayList<CommentModel> commentModelArrayList;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment);
        recyclerViewComment = findViewById(R.id.recyclerView_comment);
        commentModelArrayList = new ArrayList<>();
        back = findViewById(R.id.btn_back);
        for (int i=0 ; i<5 ; i++){
            CommentModel commentModel = new CommentModel();
            commentModel.setUser_profiles("https://upload.wikimedia.org/wikipedia/commons/6/66/An_up-close_picture_of_a_curious_male_domestic_shorthair_tabby_cat.jpg");
            commentModel.setUser_names("Monica");
            commentModel.setComments("You are so ...");
            commentModelArrayList.add(commentModel);
        }
        recyclerViewComment.setLayoutManager(new GridLayoutManager(this,1));
        commentAdapter = new CommentAdapter(this,commentModelArrayList);
        recyclerViewComment.setAdapter(commentAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
