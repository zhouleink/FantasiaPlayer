package com.hypnos.fantasiaplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hypnos.fantasiaplayer.base.BasePager;

/**
 * Created by HYPNOS on 4/9/17.
 */

public class PagerFragment extends Fragment {

    private static final String PAGER_KEY = "pagerKey";

    private BasePager currentPager;

    public static PagerFragment newInstance(BasePager pager) {
        PagerFragment fragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(PAGER_KEY, pager);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        currentPager = getArguments().getParcelable(PAGER_KEY);
        if (currentPager != null) {
            return currentPager.rootView;
        }
        return null;
    }
}
