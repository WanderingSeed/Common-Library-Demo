package com.morgan.demo.mockdata;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DragableFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public DragableFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return BaseListFragment.instantiate(mContext, "com.morgan.demo.mockdata.BaseListFragment");
    }

    @Override
    public int getCount() {
        return 3;
    }

}
