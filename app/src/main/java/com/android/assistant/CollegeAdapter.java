package com.android.assistant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CollegeAdapter extends RecyclerView.Adapter<CollegeAdapter.ViewHolder>{

    private List<College> mCollegeList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        College college = mCollegeList.get(position);
        holder.collegeImage.setImageResource(college.getImageId());
        holder.collegeName.setText(college.getName());
    }

    @Override
    public int getItemCount() {
        return mCollegeList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView collegeImage;
        TextView collegeName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            collegeImage = (ImageView) itemView.findViewById(R.id.college_image);
            collegeName = (TextView) itemView.findViewById(R.id.college_name);
        }
    }

    public CollegeAdapter(List<College> collegeList){
        mCollegeList = collegeList;
    }



}
