package com.hypnos.fantasiaplayer.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.hypnos.fantasiaplayer.R;
import com.hypnos.fantasiaplayer.base.BasePager;
import com.hypnos.fantasiaplayer.fragment.PagerFragment;
import com.hypnos.fantasiaplayer.pager.AudioPager;
import com.hypnos.fantasiaplayer.pager.OnlineAudioPager;
import com.hypnos.fantasiaplayer.pager.OnlineVideoPager;
import com.hypnos.fantasiaplayer.pager.VideoPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HYPNOS on 1/7/17.
 */
public class MainActivity extends FragmentActivity {

    private RadioGroup rg_bottom_tag;
    private FrameLayout fl_main_content;

    private List<BasePager> pagers;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fl_main_content = (FrameLayout) findViewById(R.id.fl_main_content);
        rg_bottom_tag = (RadioGroup) findViewById(R.id.rg_bottom_tag);

        pagers = new ArrayList<>();
        pagers.add(new VideoPager(this));
        pagers.add(new AudioPager(this));
        pagers.add(new OnlineVideoPager(this));
        pagers.add(new OnlineAudioPager(this));

        //Set listener for RadioGroup
        rg_bottom_tag.setOnCheckedChangeListener(new RadioGroupOnCheckedChangeListener());

        //Set default page: VideoPager
        rg_bottom_tag.check(R.id.rb_video);

    }


    //Define OnCheckedChangeListener for RadioGroup
    class RadioGroupOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_audio:
                    position = 1;
                    break;
                case R.id.rb_online_video:
                    position = 2;
                    break;
                case R.id.rb_online_audio:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }
            setFragment();
        }
    }

    //Set view in fragment
    private void setFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_main_content, PagerFragment.newInstance(getBasePager()));
        transaction.commit();
    }

    //Get the pager and initialize data
    private BasePager getBasePager() {
        BasePager pager = pagers.get(position);
        if (pager != null && !pager.isDataInitialized) {
            pager.initData();
            pager.isDataInitialized = true;
        }
        return pager;
    }
}
