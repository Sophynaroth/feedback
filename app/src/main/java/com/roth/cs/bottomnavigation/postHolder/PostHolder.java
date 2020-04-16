package com.roth.cs.bottomnavigation.postHolder;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.R;

public class PostHolder extends RecyclerView.ViewHolder {
    public TextView time, imageName, user_name, more, comment;
    public EditText text_comment;
    public ImageView imageURL, profile_comment, profile;
    public ImageButton btn_submit_comment;
    public PostHolder(@NonNull View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.time);
        text_comment = itemView.findViewById(R.id.text_comment);
        imageName = itemView.findViewById(R.id.imageName);
        user_name = itemView.findViewById(R.id.name);
        imageURL = itemView.findViewById(R.id.imageURL);
        profile_comment = itemView.findViewById(R.id.comment_profile);
        profile = itemView.findViewById(R.id.profile);
        more = itemView.findViewById(R.id.btn_view_more);
        btn_submit_comment = itemView.findViewById(R.id.btn_submit_comment);
        comment = itemView.findViewById(R.id.comment);


    }
}
