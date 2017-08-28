package com.example.administrator.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;


public class ShowWaterAct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_layout);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.showPicRL);
        Bitmap srcBitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.flow_bg)).getBitmap();
        WaterMarkTextUtil.setWaterMarkTextBg(rl,this,"测试效果", srcBitmap);
    }
}
