package com.morgan.demo;

import java.util.List;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.morgan.demo.mockdata.MainActivityListAdapter;
import com.morgan.library.utils.AppUtils;

public class MainActivity extends ListActivity {
    private PackageManager mPackageManager;
    private static final String FIRST_TIME_START = "isfrist";
    private static final String DEMO_ACTION = "com.morgan.demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("first", Context.MODE_PRIVATE);
        boolean isFirst = preferences.getBoolean(FIRST_TIME_START, true);
        if (isFirst) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            AppUtils.installLauncherShortCut(intent, getString(R.string.app_label),
                    BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        }
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(FIRST_TIME_START, false);
        editor.commit();
        mPackageManager = getPackageManager();
        List<ResolveInfo> activities = mPackageManager.queryIntentActivities(makeDemoActivityIntent(),
                PackageManager.GET_META_DATA);
        getListView().setAdapter(new MainActivityListAdapter(this, activities, mPackageManager));
    }

    protected Intent makeDemoActivityIntent() {
        return new Intent(DEMO_ACTION);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        ActivityInfo resolveInfo = ((ResolveInfo) l.getItemAtPosition(position)).activityInfo;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(resolveInfo.packageName, resolveInfo.name));
        startActivity(intent);
    }
}
