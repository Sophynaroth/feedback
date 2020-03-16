package com.roth.cs.bottomnavigation.LecturerHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.R;


public class LecturerHolder extends RecyclerView.ViewHolder {
    public ImageView lecturerImg;
    public TextView lecturerName, jobTile, major;
    public CardView cardView;
    public LecturerHolder(@NonNull View itemView) {

        super(itemView);
        this.lecturerImg=itemView.findViewById(R.id.profile_image);
        this.lecturerName=itemView.findViewById(R.id.lecturer_name);
        this.jobTile=itemView.findViewById(R.id.job_title);
        this.major=itemView.findViewById(R.id.major);
        this.cardView=itemView.findViewById(R.id.card);

    }
}
