package com.android.assistant.ui.sign;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.assistant.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SignFragment extends Fragment implements View.OnClickListener {

    private SignViewModel signViewModel;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1){
                /**
                 * 自动弹出的提醒部分
                 */
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("来自制作人的提醒");
                builder.setMessage("按序点击图片显示新生报到流程");
                builder.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setNegativeButton("不再提醒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                        editor.putString("提醒", "0");
                        editor.apply();
                    }
                });
                builder.show();
            }
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        signViewModel =
                ViewModelProviders.of(this).get(SignViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sign, container, false);
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String flag = preferences.getString("提醒", "");
        if(flag.equals("1")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                        Message message = new Message();
                        message.what = 1;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        imageButton = (ImageButton)getActivity().findViewById(R.id.imageView);
        imageButton2 = (ImageButton)getActivity().findViewById(R.id.imageView2);
        imageButton3 = (ImageButton)getActivity().findViewById(R.id.imageView3);
        imageButton4 = (ImageButton)getActivity().findViewById(R.id.imageView4);
        imageButton5 = (ImageButton)getActivity().findViewById(R.id.imageView5);
        imageButton6 = (ImageButton)getActivity().findViewById(R.id.imageView6);
        imageButton.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("①注意报到时间和地点");
                builder.setMessage("录取通知书里会详细说明报到时间和地点，要注意的是，如果录取通知书规定的报到时间是两天，建议你第一天就过来，如果是一天，建议你最好早点达到校园；其次是地点，一般学校会集中在一个地点为新生办理入学手续，比如运动场等，你可以提前在手机地图上查好报名地点的具体位置，这样不至于到时候走冤枉路。");
                builder.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
            case R.id.imageView2:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setTitle("②办理报名注册");
                builder2.setMessage("到达指定的报名地点后，找到本学院的伞棚，一般会有辅导员或者学姐学长在，他们会具体说明你需要交纳的东西，然后会要求你在新生报到表上签名，总之，工作人员让你怎么做你就怎么做（值得注意的是一定要先带好报名需要的东西，这个在录取通知书里都会写到），最后，他们会发给你一些单子，比如报到单、新生开学安排表、保险单等，这些都要收好。还会告诉你到指定地点购买军训服装。");
                builder2.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder2.show();
                break;
            case R.id.imageView3:
                AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
                builder3.setTitle("③在带领下进入宿舍");
                builder3.setMessage("由于大学较大，所以宿舍和报名地点隔得比较远，不过一般会有学姐学长带你找到宿舍。到达宿舍后，现在宿舍门口的宿管阿姨那里报道，他会给你你所在寝室的钥匙（人手一把），当然学校也会统一售卖床上用品，一般都是一整套，价格比较便宜，寝室楼下会有摆点，如果需要，可以购买。然后整理宿舍，注意如果要把电脑等放在宿舍，记得锁上柜子。");
                builder3.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder3.show();
                break;
            case R.id.imageView5:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(getActivity());
                builder4.setTitle("④办理卡和这种必需品");
                builder4.setMessage("要办理需要用的一些卡，还要买教材，这个在报名时会具体告诉你，你只需要带上钱到具体地点办理就行了。还要买保险，有的学校是在网上缴费的，有的是现场缴费，视具体情况而定。");
                builder4.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder4.show();
                break;
            case R.id.imageView4:
                AlertDialog.Builder builder5 = new AlertDialog.Builder(getActivity());
                builder5.setTitle("⑤检查身体");
                builder5.setMessage("不是所有的学生都需要检查身体，只是一些特殊的专业需要在报名时检查身体，比如公费师范等。基本流程就是如此，关于开学的注意事项，我前面有很多文章都有介绍，感兴趣可以看一下");
                builder5.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder5.show();
                break;
            case R.id.imageView6:
                AlertDialog.Builder builder6 = new AlertDialog.Builder(getActivity());
                builder6.setTitle("⑥点赞投币加关注");
                builder6.setMessage("“绍兴大学伟人手创不同凡响的建校历史、与国家民族同呼吸共命运的红色基因、敢为人先追求卓越的办学传统，是一代一代中大人创造和积淀出来的伟大精神力量，是引领我们前行的宝贵精神财富，是每一位中大人应该传承和追求的内在精神境界。身为中大人，对我们来说，不仅是荣耀，更是继往开来、发扬光大的责任。”");
                builder6.setPositiveButton("了解", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder6.show();
                break;
        }
    }
}