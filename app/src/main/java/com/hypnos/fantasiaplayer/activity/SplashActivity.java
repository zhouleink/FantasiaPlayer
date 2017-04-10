package com.hypnos.fantasiaplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

import com.hypnos.fantasiaplayer.R;

public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    private Handler handler = new Handler();

    private boolean isMainStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行在主线程中
                startMainActivity();
                Log.e(TAG, "当前线程 == " + Thread.currentThread().getName());
            }
        }, 5000);
    }

    /**
     * 跳转到主页面，关掉当前的启动页面
     */
    private void startMainActivity() {
        //只启动一次主页面
        if (!isMainStarted) {
            isMainStarted = true;
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "Action = " + event.getAction());
        startMainActivity();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
