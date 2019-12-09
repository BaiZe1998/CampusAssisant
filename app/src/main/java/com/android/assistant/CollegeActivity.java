package com.android.assistant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollegeActivity extends AppCompatActivity {

    public static final String COLLEGE_NAME = "college_name";

    public static final String COLLEGE_IMAGE_ID = "college_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        Intent intent = getIntent();
        String collegeName = intent.getStringExtra(COLLEGE_NAME);
        String collegeImageId = intent.getStringExtra(COLLEGE_IMAGE_ID);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView collegeImageView = (ImageView)findViewById(R.id.college_image_view);
        TextView collegeContentText = (TextView)findViewById(R.id.college_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        int imageId = getResources().getIdentifier(collegeImageId, "drawable", getBaseContext().getPackageName());
        Log.i("图片id", "onCreate: " + imageId);
        collapsingToolbarLayout.setTitle(collegeName);
        Glide.with(this).load(imageId).into(collegeImageView);
        String collegeContent = generateCollegeContent(collegeName);
        collegeContentText.setText(collegeContent);
    }

    private String generateCollegeContent(String collegeName){
        StringBuilder collegeContent = new StringBuilder();
        for(int i = 0; i < 500; i++){
            collegeContent.append(collegeName);
        }
        return collegeContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
