package com.morgan.demo.mockdata;

import java.util.List;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivityListAdapter extends BaseAdapter {
    private List<ResolveInfo> mData;
    private LayoutInflater mInflater;
    private PackageManager mPackageManager;

    public MainActivityListAdapter(Context context, List<ResolveInfo> data, PackageManager packageManager) {
        mData = data;
        mInflater = LayoutInflater.from(context);
        mPackageManager = packageManager;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public ResolveInfo getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResolveInfo resolveInfo = getItem(position);
        if (null == convertView) {
            convertView = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        ((TextView) convertView).setText(resolveInfo.loadLabel(mPackageManager));
        return convertView;
    }
}
