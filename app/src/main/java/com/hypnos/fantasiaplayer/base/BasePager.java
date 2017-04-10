package com.hypnos.fantasiaplayer.base;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 *
 */

public abstract class BasePager implements Parcelable {

    public final Context context;
    public View rootView;
    public boolean isDataInitialized;

    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    public abstract View initView();

    public void initData() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static BasePager.Creator<BasePager> CREATOR = new Creator<BasePager>() {
        @Override
        public BasePager createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public BasePager[] newArray(int size) {
            return new BasePager[0];
        }
    };
}
