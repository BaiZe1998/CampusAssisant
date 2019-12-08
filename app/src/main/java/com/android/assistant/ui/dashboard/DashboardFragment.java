package com.android.assistant.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.assistant.College;
import com.android.assistant.CollegeAdapter;
import com.android.assistant.R;
import com.android.assistant.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private List<College> collegeList = new ArrayList<>();

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

        //       final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
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