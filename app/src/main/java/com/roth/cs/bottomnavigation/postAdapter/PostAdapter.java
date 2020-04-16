package com.roth.cs.bottomnavigation.postAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;
import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.postHolder.PostHolder;
import com.roth.cs.bottomnavigation.postModel.PostModel;
import com.roth.cs.bottomnavigation.ui.post.MoreComment;
import com.roth.cs.bottomnavigation.ui.post.Post;
import com.roth.cs.bottomnavigation.ui.post.ViewPostImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostHolder> {
    Context context;
    ArrayList<PostModel> arrayList;
    DatabaseReference databaseReference;
    StorageReference storageReference;
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
    public void onBindViewHolder(@NonNull final PostHolder holder, final int position) {
        Picasso.get().load(arrayList.get(position).getImageURL()).into(holder.imageURL);
        Picasso.get().load(arrayList.get(position).getProfile()).into(holder.profile);
        Picasso.get().load(arrayList.get(position).getProfile_comment()).into(holder.profile_comment);
        holder.text_comment.setText(arrayList.get(position).getText_comment());
        holder.comment.setText(arrayList.get(position).getComment());
        holder.imageName.setText(arrayList.get(position).getImageName());
        holder.user_name.setText(arrayList.get(position).getUser_name());
        holder.time.setText(arrayList.get(position).getTime());
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoreComment.class);
                context.startActivity(intent);
            }
        });
        holder.imageURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewPostImage.class);
                intent.putExtra("imageURL",arrayList.get(position).getImageURL());
                intent.putExtra("imageName",arrayList.get(position).getImageName());
                context.startActivity(intent);
            }
        });
        holder.btn_submit_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.text_comment.setText("");
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
