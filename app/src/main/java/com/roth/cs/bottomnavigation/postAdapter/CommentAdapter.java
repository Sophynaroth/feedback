package com.roth.cs.bottomnavigation.postAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.postHolder.CommentHolder;
import com.roth.cs.bottomnavigation.postModel.CommentModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {
    Context context;
    ArrayList<CommentModel> commentModelArrayList;

    public CommentAdapter(Context context, ArrayList<CommentModel> commentModelArrayList) {
        this.context = context;
        this.commentModelArrayList = commentModelArrayList;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item,null);
        return new CommentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        Picasso.get().load(commentModelArrayList.get(position).getUser_profiles()).into(holder.user_profiles);
        holder.user_names.setText(commentModelArrayList.get(position).getUser_names());
        holder.comments.setText(commentModelArrayList.get(position).getComments());

    }

    @Override
    public int getItemCount() {
        return commentModelArrayList.size();
    }
}
