package com.roth.cs.bottomnavigation.LecturerAdapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.roth.cs.bottomnavigation.LecturerHolder.LecturerHolder;
import com.roth.cs.bottomnavigation.LecturerModel.LecturerModel;
import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.ui.lecturer.LecturerDetail;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LecturerAdapter extends RecyclerView.Adapter<LecturerHolder> implements Filterable {

    Context context;
    ArrayList<LecturerModel> arrayList;
    List<LecturerModel> lecturerListFull;

    public LecturerAdapter (Context context, ArrayList<LecturerModel> arrayList){
        this.context= context;
        this.arrayList = arrayList;
        lecturerListFull = new ArrayList<>(arrayList);
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

    /*search*/
    @Override
    public Filter getFilter() {
        return lecturerFilter;
    }

    private Filter lecturerFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
             List<LecturerModel> filteredList = new ArrayList<>();

             if (constraint == null || constraint.length()==0){
                 filteredList.addAll(lecturerListFull);
             } else{
                 String filterPatter = constraint.toString().toLowerCase().trim();
//                 Log.e("search text", filterPatter);
//                 if(lecturerListFull == null){
//                     Log.e("lectureListFull is", "null");
//                 }
                 for (LecturerModel model : lecturerListFull){
                     if( model.getLecturerName().toLowerCase().contains(filterPatter)){
                         filteredList.add(model);
                     }
                 }
             }
             FilterResults results = new FilterResults();
             results.values = filteredList;
//             if(results == null){
//                Log.e("The result is", "null");
//            }else{
//                Log.e("The result is", "not null");
//            }
             return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayList.clear();
            arrayList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    /*end*/




}
