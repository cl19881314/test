package com.example.administrator.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by ChenHong on 2016/12/18.
 */

public class MyScrollView extends ScrollView{
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private View mCallMeTitle;
    private View mPingLunTitle;
    private View mXiaoXiTitle;
    private View mContentCallMeLL;
    private View mContentPingLunLL;
    private View mContentXiaoXiLL;
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (t >= 0) {
            mCallMeTitle.setVisibility(View.VISIBLE);
        }
        if(t >= mContentCallMeLL.getHeight()) {
            mPingLunTitle.setVisibility(View.VISIBLE);
        } else {
            mPingLunTitle.setVisibility(View.GONE);
        }
        if(t >= mContentCallMeLL.getHeight() + mContentPingLunLL.getHeight()) {
            mXiaoXiTitle.setVisibility(View.VISIBLE);
        } else {
            mXiaoXiTitle.setVisibility(View.GONE);
        }
    }

    public void setMyTitleView(View callTitle, View pingLunTitle, View xiaoXiTitle){
        mCallMeTitle = callTitle;
        mPingLunTitle = pingLunTitle;
        mXiaoXiTitle = xiaoXiTitle;
    }
    public void setMyScrollSizeView(View callLL, View pingLunLL, View xiaoXiLL){
        mContentCallMeLL = callLL;
        mContentPingLunLL = pingLunLL;
        mContentXiaoXiLL = xiaoXiLL;
    }
}
