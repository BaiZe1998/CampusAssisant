package com.android.assistant;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImage();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_sign, R.id.navigation_dashboard, R.id.navigation_map)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }
    private void initImage(){
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putString("冶金与能源工程学院", "nengyuan");
        editor.putString("信息与技术学院", "xinxi");
        editor.putString("经济与对外贸易学院", "jingji");
        editor.putString("机械与自动化学院", "jixie");
        editor.putString("生命与化工学院", "shengming");
        editor.putString("食品与药理学院", "shipin");
        editor.putString("探测与材料金属", "tance");
        editor.putString("体育与人体健美学院", "tiyu");
        editor.putString("通信与电力工程学院", "tongxin");
        editor.putString("服装设计与艺术学院", "fuzhuang");
        editor.putString("医学与生命安全学院", "yixue");
        editor.putString("影视与摄像学院", "yingshi");
        editor.putString("兰亭书法艺术学院", "shufa");
        editor.putString("学术与研究学院", "xueshu");
        editor.putString("社会与交通管理学院", "jiaotong");
        editor.apply();
    }
}
