package com.android.assistant.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.assistant.FlashActivity;
import com.android.assistant.FoodActivity;
import com.android.assistant.OutActivity;
import com.android.assistant.R;
import com.android.assistant.TravelActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private BottomNavigationView bottomNavigationView;
    private ObservableScrollView scrollView;
    private HomeViewModel homeViewModel;
    List<Integer> images = new ArrayList<Integer>();        //定义图片集合
    private int scrollY;
    Boolean isBottom;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        scrollView = (ObservableScrollView) root.findViewById(R.id.scroll);
        bottomNavigationView = (BottomNavigationView)getActivity().findViewById(R.id.nav_view);



        initBanner(root);

        initMove();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imageButton1 = (ImageButton)getActivity().findViewById(R.id.image1);
        imageButton2 = (ImageButton)getActivity().findViewById(R.id.image2);
        imageButton3 = (ImageButton)getActivity().findViewById(R.id.image3);
        imageButton4 = (ImageButton)getActivity().findViewById(R.id.image4);
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);

    }

    public void initBanner(View root){
        images.add(R.drawable.college5);
        images.add(R.drawable.college6);
        images.add(R.drawable.college7);
        images.add(R.drawable.college8);
        images.add(R.drawable.college9);
        images.add(R.drawable.college10);
        images.add(R.drawable.college11);
        images.add(R.drawable.college12);
        images.add(R.drawable.college13);
        images.add(R.drawable.college14);

        Banner banner = (Banner) root.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public void initMove(){
        isBottom = true;
        scrollView.setScrollViewListener(new ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                //上划 并且正在显示底部导航
                if(y - oldy > 10 && isBottom){
                    isBottom = false;
                    //将y属性变为底部栏高度 相当于隐藏了
                    bottomNavigationView.animate().translationY(bottomNavigationView.getHeight());
                }else if(y - oldy < -10 && !isBottom){
                    isBottom = true;
                    bottomNavigationView.animate().translationY(0);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image1:
                Intent intent = new Intent(getActivity(), FoodActivity.class);
                startActivity(intent);
                break;
            case R.id.image2:
                Intent intent3 = new Intent(getActivity(), TravelActivity.class);
                startActivity(intent3);
                break;
            case R.id.image3:
                Intent intent1 = new Intent(getActivity(), OutActivity.class);
                startActivity(intent1);
                break;
            case R.id.image4:
                Intent intent4 = new Intent(getActivity(), FlashActivity.class);
                startActivity(intent4);
                break;
        }
    }
}