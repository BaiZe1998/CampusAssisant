package com.android.assistant.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.android.assistant.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

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

    public void initBanner(View root){
        images.add(R.drawable.college5);
        images.add(R.drawable.college6);
        images.add(R.drawable.college7);
        images.add(R.drawable.college8);
        images.add(R.drawable.college9);

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
}