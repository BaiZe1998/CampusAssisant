package com.android.assistant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.collegeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                College college = mCollegeList.get(position);
                String collegeName = college.getName();
                int collegeImageId = college.getImageId();
                SharedPreferences preferences = parent.getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                String imageId = preferences.getString(collegeName, "");
                Intent intent = new Intent(parent.getContext(), CollegeActivity.class);
                intent.putExtra(CollegeActivity.COLLEGE_NAME, collegeName);
                intent.putExtra(CollegeActivity.COLLEGE_IMAGE_ID, imageId);
//                intent.putExtra(CollegeActivity.COLLEGE_IMAGE_ID, collegeImageId);
                parent.getContext().startActivity(intent);
            }
        });
        holder.collegeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                College college = mCollegeList.get(position);
                String collegeName = college.getName();
                SharedPreferences preferences = parent.getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                String imageId = preferences.getString(collegeName, "");
                Intent intent = new Intent(parent.getContext(), CollegeActivity.class);
                intent.putExtra(CollegeActivity.COLLEGE_NAME, collegeName);
                intent.putExtra(CollegeActivity.COLLEGE_IMAGE_ID, "R.id." + imageId);
                parent.getContext().startActivity(intent);
            }
        });
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
