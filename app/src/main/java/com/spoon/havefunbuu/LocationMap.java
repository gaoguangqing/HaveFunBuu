package com.spoon.havefunbuu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

public class LocationMap extends Activity {

    private MapView mMapView;
    private BaiduMap mBaiduMap;

    private ToggleButton tgTraffic;

    private EditText editText;
    private Button btSearch;

    private PoiSearch mPoiSearch;//检索对象

    //检索监听器
    OnGetPoiSearchResultListener poiSearchResultListener=new OnGetPoiSearchResultListener() {
        @Override
        public void onGetPoiResult(PoiResult result) {
            //poi检索结果
            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
                return;
            }
            //遍历所有POI
            for (PoiInfo poi : result.getAllPoi()) {
                //构建Marker图标
                BitmapDescriptor bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_marka);
//构建MarkerOption，用于在地图上添加Marker
                OverlayOptions option = new MarkerOptions()
                        .position(poi.location)
                        .icon(bitmap);
                mBaiduMap.addOverlay(option);
            }


        }

        @Override
        public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {
            //poi详细检索结果

        }

        @Override
        public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {
            //门址类的搜索结果
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // /在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_location_map);

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap=mMapView.getMap();
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        showBUUHotPlace();


        tgTraffic= (ToggleButton) findViewById(R.id.tgTraffic);
        tgTraffic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked){
                    mBaiduMap.setTrafficEnabled(true);//交通
                }
                else {
                    mBaiduMap.setTrafficEnabled(false);//交通
                }
            }
        });


        mPoiSearch= PoiSearch.newInstance();
        mPoiSearch.setOnGetPoiSearchResultListener(poiSearchResultListener);
        editText= (EditText) findViewById(R.id.etSearch);
        btSearch= (Button) findViewById(R.id.btnSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBaiduMap.clear();
                mPoiSearch.searchInCity((new PoiCitySearchOption()).city("北京").keyword(editText.getText().toString().trim()).pageNum(10));
            }
        });
    }

    private void showBUUHotPlace() {
        //定义Maker坐标点
        //116.433312,39.996494
        LatLng point = new LatLng(39.996494, 116.433312);
//构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.mipmap.icon_buu);
//构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
//在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

}
