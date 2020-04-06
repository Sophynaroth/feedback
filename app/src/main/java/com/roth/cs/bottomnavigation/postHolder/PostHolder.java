package com.roth.cs.bottomnavigation.postHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.R;

public class PostHolder extends RecyclerView.ViewHolder {
    public TextView time, text_comment, status, user_name, more;
    public ImageView image_post, profile_comment, profile;
    public PostHolder(@NonNull View itemView) {
        super(itemView);
        time = itemView.findViewById(R.id.time);
        text_comment = itemView.findViewById(R.id.comment);
        status = itemView.findViewById(R.id.title);
        user_name = itemView.findViewById(R.id.name);
        image_post = itemView.findViewById(R.id.image_post);
        profile_comment = itemView.findViewById(R.id.comment_profile);
        profile = itemView.findViewById(R.id.profile);
        more = itemView.findViewById(R.id.btn_view_more);
    }
}
