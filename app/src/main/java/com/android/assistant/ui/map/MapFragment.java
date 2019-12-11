package com.android.assistant.ui.map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.assistant.R;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

public class MapFragment extends Fragment {

    private int flag = 0;               //是否首次定位
    private MapViewModel mapViewModel;
    private MapView mMapView = null;
    private BaiduMap baiduMap;
    private LocationClient locationClient;
    private MyLocationListener myLocationListener;
    private MyLocationData myLocationData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mapViewModel =
                ViewModelProviders.of(this).get(MapViewModel.class);
        View root = inflater.inflate(R.layout.fragment_map, container, false);

        //获取地图控件引用
        mMapView = (MapView) root.findViewById(R.id.bmapView);
        // 找到MapView控件，并通过getMap()方法获得BaiduMap类的对象；
        baiduMap = mMapView.getMap();
        //定位初始化
        locationClient = new LocationClient(getActivity());
        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        //设置locationClientOption
        locationClient.setLocOption(option);
        //注册LocationListener监听器
        myLocationListener = new MyLocationListener();
        locationClient.registerLocationListener(myLocationListener);
        locationClient.start();
        //开启地图的图层定位
//        MapStatus.Builder builder = new MapStatus.Builder();
//        builder.zoom(18.0f);
//        builder.target(latLng);
//        baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
        //开启地图定位图层
        baiduMap.setMyLocationEnabled(true);
        return root;
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            baiduMap.setMyLocationData(locData);
            if(flag == 0){//首次打开时获取图层定位
                flag = 1;
                //开启地图的图层定位
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.zoom(18.0f);
                builder.target(latLng);
                baiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        locationClient.stop();
        baiduMap.setMyLocationEnabled(false);
        mMapView = null;
    }

}
