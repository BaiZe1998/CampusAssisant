package com.android.assistant.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.assistant.College;
import com.android.assistant.CollegeAdapter;
import com.android.assistant.R;
import com.android.assistant.SimpleDividerItemDecoration;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private BottomNavigationView bottomNavigationView;
    private List<College> collegeList = new ArrayList<>();
    private int scrollY;
    Boolean isBottom;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initColleges();
        RecyclerView recyclerView = (RecyclerView)root.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity(),20, 5));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        CollegeAdapter adapter = new CollegeAdapter(collegeList);
        recyclerView.setAdapter(adapter);

        /**
         * 底部导航栏的显示与隐藏
         */
        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        isBottom = true;
//        recyclerView.setOnScrollChangeListener(new RecyclerView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                //上划 并且正在显示底部导航
//                if(scrollY - oldScrollY > 0 && isBottom){
//                    isBottom = false;
//                    //将y属性变为底部栏高度 相当于隐藏了
//                    bottomNavigationView.animate().translationY(bottomNavigationView.getHeight());
//                }else if(scrollY - oldScrollY < 0 && !isBottom){
//                    isBottom = true;
//                    bottomNavigationView.animate().translationY(0);
//                }
//            }
//        });
        scrollY = 0;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            /**
             * 关于滑动部分尚且存在理解上的问题
             * @param recyclerView
             * @param dx
             * @param dy
             */
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY += dy;

                if(scrollY - bottomNavigationView.getHeight() > 0 && isBottom){
                    isBottom = false;
                    bottomNavigationView.animate().translationY(bottomNavigationView.getHeight());
                    Log.i("测试1", "onScrolled: " + scrollY);
                }else if(scrollY - bottomNavigationView.getHeight() <= 0 && !isBottom){
                    isBottom = true;
                    bottomNavigationView.animate().translationY(0);
                    Log.i("测试2", "onScrolled: " + scrollY);
                }
                Log.i("测试", "onScrolled: " + bottomNavigationView.getHeight());
            }
        });
        return root;
    }

    private void initColleges(){
        College nengyuan = new College("冶金与能源工程学院", R.drawable.ic_nengyuan_black_24dp);
        collegeList.add(nengyuan);
        College computer = new College("信息与技术学院", R.drawable.ic_computer_black_24dp);
        collegeList.add(computer);
        College jingji = new College("经济与对外贸易学院", R.drawable.ic_jingji_black_24dp);
        collegeList.add(jingji);
        College jixie = new College("机械与自动化学院", R.drawable.ic_jixie_black_24dp);
        collegeList.add(jixie);
        College shengming = new College("生命与化工学院", R.drawable.ic_shengming_black_24dp);
        collegeList.add(shengming);
        College shipin = new College("食品与药理学院", R.drawable.ic_shipin_black_24dp);
        collegeList.add(shipin);
        College tance = new College("探测与材料金属", R.drawable.ic_tance_black_24dp);
        collegeList.add(tance);
        College tiyu = new College("体育与人体健美学院", R.drawable.ic_tiyu_24dp);
        collegeList.add(tiyu);
        College xinxi = new College("通信与电力工程学院", R.drawable.ic_xinxi_black_24dp);
        collegeList.add(xinxi);
        College yishu = new College("服装设计与艺术学院", R.drawable.ic_yishu_black_24dp);
        collegeList.add(yishu);
        College yixue = new College("医学与生命安全学院", R.drawable.ic_yixue_black_24dp);
        collegeList.add(yixue);
        College yingshi = new College("影视与摄像学院", R.drawable.ic_yingshi_black_24dp);
        collegeList.add(yingshi);
        College shufa = new College("兰亭书法艺术学院", R.drawable.ic_shufa_black_24dp);
        collegeList.add(shufa);
        College yanjiu = new College("学术与研究学院", R.drawable.ic_yanjiu_black_24dp);
        collegeList.add(yanjiu);
        College jiaotong = new College("社会与交通管理学院", R.drawable.ic_jiaotong_black_24dp);
        collegeList.add(jiaotong);
    }

}