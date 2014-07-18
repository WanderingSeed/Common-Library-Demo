package com.morgan.demo.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.morgan.demo.R;
import com.morgan.demo.base.BaseActionBarActivity;
import com.morgan.library.widget.PullToRefreshListView;
import com.morgan.library.widget.PullToRefreshListView.OnLoadDataListener;
import com.morgan.library.widget.PullToRefreshListView.OnRefreshDataListener;

/**
 * 一个下拉刷新，上拉加载的例子。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-18
 */
public class PullToRefreshListViewDemo extends BaseActionBarActivity {

	private List<String> mList = new ArrayList<String>();
	private TextView mHeaderTopView, mHeadBootomView;
	private ListAdapter mAdapter;
	private PullToRefreshListView mListViewWidget;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_pull_to_refresh_listview);
		initView();
	}

	/**
	 * 初始化界面
	 */
	private void initView() {
		mListViewWidget = (PullToRefreshListView) findViewById(R.id.pullToRefreshListView);
		mListViewWidget.setLoadDataListener(mLoadDataListener); // 设置上拉监听器
		mListViewWidget.setRefreshDataListener(mRefreshDataListener);// 设置下拉监听器
		mAdapter = new ArrayAdapter<String>(PullToRefreshListViewDemo.this,
				android.R.layout.simple_list_item_1, mList);
		mListViewWidget.setAdapter(mAdapter);
		mHeaderTopView = new TextView(PullToRefreshListViewDemo.this);
		mHeadBootomView = new TextView(PullToRefreshListViewDemo.this);
		mHeaderTopView.setText("head");
		mHeadBootomView.setText("bottom");
		mListViewWidget.addUserTopHeaderView(mHeaderTopView);
		mListViewWidget.addUserBottomHeaderView(mHeadBootomView);
		mListViewWidget.setOnScrollListener(mListViewWidget); // TODO： 设置滑动监听器
	}

	private OnRefreshDataListener mRefreshDataListener = new OnRefreshDataListener() {

		@Override
		public void onRefreshData() {
			//模拟数据加载
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					mList.clear();
					mList.addAll(Arrays.asList((getResources()
							.getStringArray(R.array.test_data))));
					mListViewWidget.getPartialData();
				}
			}, 3 * 1000);
		}
	};

	private OnLoadDataListener mLoadDataListener = new OnLoadDataListener() {

		@Override
		public void onLoadData() {
			//模拟数据加载
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					mList.addAll(Arrays.asList((getResources()
							.getStringArray(R.array.test_data))));
					mListViewWidget.getPartialData();
				}
			}, 3 * 1000);
		}
	};
}
