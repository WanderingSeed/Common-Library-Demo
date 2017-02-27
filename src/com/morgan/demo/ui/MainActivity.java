package com.morgan.demo.ui;

import java.util.List;

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
import android.widget.Toast;

import com.morgan.demo.R;
import com.morgan.demo.adapter.MainActivityListAdapter;
import com.morgan.demo.base.BaseActionBarListActivity;
import com.morgan.demo.data.Constants;
import com.morgan.library.app.ActicityManager;
import com.morgan.library.utils.AppUtils;

/**
 * 程序主界面，包含跳忘各个模块的入口。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-15
 */
public class MainActivity extends BaseActionBarListActivity {
	private PackageManager mPackageManager;
	private long mExitTime = 0; // 记录第一次按键时间，连续按两次back键退出程序

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		firstStartCheck();
		mPackageManager = getPackageManager();
		List<ResolveInfo> activities = mPackageManager.queryIntentActivities(
				createDemoActivityIntent(), PackageManager.GET_META_DATA);
		getListView().setAdapter(
				new MainActivityListAdapter(this, activities, mPackageManager));
	}

	/**
	 * 检查是否为第一次运行，如果是则在桌面添加一个快捷方式。
	 */
	private void firstStartCheck() {
		SharedPreferences preferences = getSharedPreferences(
				Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
		boolean isFirst = preferences.getBoolean(Constants.FIRST_TIME_START,
				true);
		if (isFirst) { // 第一次启动则在桌面添加快捷方式
			Intent intent = new Intent(getApplicationContext(),
					MainActivity.class);
			AppUtils.installLaunchShortCut(intent,
					getString(R.string.app_label), BitmapFactory
							.decodeResource(getResources(),
									R.drawable.icon_launcher), false);
			SharedPreferences.Editor editor = preferences.edit();
			editor.putBoolean(Constants.FIRST_TIME_START, false);
			editor.commit();
		}
	}

	/**
	 * 创建一个包含{@link Constants#DEMO_ACTION}的Intent。
	 * 
	 * @return
	 */
	public Intent createDemoActivityIntent() {
		return new Intent(Constants.DEMO_ACTION);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		ActivityInfo resolveInfo = ((ResolveInfo) l.getItemAtPosition(position)).activityInfo;
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(resolveInfo.packageName,
				resolveInfo.name));
		startActivity(intent);
	}

	@Override
	public void onBackPressed() {
		if ((System.currentTimeMillis() - mExitTime) > 3000) {
			Toast.makeText(getApplicationContext(),
					R.string.another_click_exit_app, Toast.LENGTH_SHORT).show();
			mExitTime = System.currentTimeMillis();
		} else {
			ActicityManager.getInstance().exitApp(MainActivity.this);
		}
	}
}
