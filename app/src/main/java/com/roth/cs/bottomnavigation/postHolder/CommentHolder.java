package com.roth.cs.bottomnavigation.postHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.R;

public class CommentHolder extends RecyclerView.ViewHolder {
    public ImageView user_profiles;
    public TextView user_names, comments;
    public CommentHolder(@NonNull View itemView) {
        super(itemView);
        user_profiles = itemView.findViewById(R.id.user_profiles);
        user_names = itemView.findViewById(R.id.user_names);
        comments = itemView.findViewById(R.id.comments);
    }
}
