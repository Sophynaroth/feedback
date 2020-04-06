package com.roth.cs.bottomnavigation.postAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.postHolder.PostHolder;
import com.roth.cs.bottomnavigation.postModel.PostModel;
import com.roth.cs.bottomnavigation.ui.post.MoreComment;
import com.roth.cs.bottomnavigation.ui.post.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostHolder> {
    Context context;
    ArrayList<PostModel> arrayList;
    public PostAdapter(Context context, ArrayList<PostModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, null);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Picasso.get().load(arrayList.get(position).getImage_post()).into(holder.image_post);
        Picasso.get().load(arrayList.get(position).getProfile()).into(holder.profile);
        Picasso.get().load(arrayList.get(position).getProfile_comment()).into(holder.profile_comment);
        holder.text_comment.setText(arrayList.get(position).getText_comment());
        holder.status.setText(arrayList.get(position).getStatus());
        holder.user_name.setText(arrayList.get(position).getUser_name());
        holder.time.setText(arrayList.get(position).getTime());
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoreComment.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
