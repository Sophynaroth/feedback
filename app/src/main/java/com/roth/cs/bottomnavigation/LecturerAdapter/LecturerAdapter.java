package com.roth.cs.bottomnavigation.LecturerAdapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.roth.cs.bottomnavigation.LecturerHolder.LecturerHolder;
import com.roth.cs.bottomnavigation.LecturerModel.LecturerModel;
import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.ui.lecturer.LecturerDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LecturerAdapter extends RecyclerView.Adapter<LecturerHolder> {

    Context context;
    ArrayList<LecturerModel> arrayList;

    public LecturerAdapter (Context context, ArrayList<LecturerModel> arrayList){
        this.context= context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public LecturerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lecturer_item,null);
        return new LecturerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LecturerHolder holder, final int position) {
        //Log.e("MY_DATA" , arrayList.get(position));
        Picasso.get().load(arrayList.get(position).getUrl()).into(holder.lecturerImg);
        holder.lecturerName.setText(arrayList.get(position).getLecturerName());
        holder.major.setText(arrayList.get(position).getMajor());
        holder.jobTile.setText(arrayList.get(position).getJobTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LecturerDetail.class);
                intent.putExtra("url", arrayList.get(position).getUrl());
                intent.putExtra("Lecturer_Name",arrayList.get(position).getLecturerName());
                intent.putExtra("Major",arrayList.get(position).getMajor());
                intent.putExtra("Job_Title",arrayList.get(position).getJobTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
