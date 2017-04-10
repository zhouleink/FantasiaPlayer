package com.hypnos.fantasiaplayer.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.hypnos.fantasiaplayer.base.BasePager;
import com.hypnos.fantasiaplayer.utils.LogUtil;

/**
 * Created by HYPNOS on 4/6/17.
 */

public class OnlineVideoPager extends BasePager {
    private TextView textView;

    public OnlineVideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        LogUtil.e("网络视频页面被初始化了");
        textView = new TextView(context);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("网络视频页面的数据被初始化了");
        textView.setText("网络视频页面");
    }
}
