package com.morgan.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.morgan.library.widget.PullToRefreshListView;
import com.morgan.library.widget.PullToRefreshListView.OnLoadDataListener;
import com.morgan.library.widget.PullToRefreshListView.OnRefreshDataListener;

public class PullToRefreshListViewDemo extends BaseActionBarActivity {

    private List<String> mList = new ArrayList<String>();
    private TextView mHeaderTopView, mHeadBootomView;
    private ListAdapter mAdapter;
    private PullToRefreshListView mListViewWidget;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_to_refresh_listview_demo);
        mListViewWidget = (PullToRefreshListView) findViewById(R.id.pullToRefreshListView);
        mListViewWidget.setLoadDataListener(loadDataListener);
        mListViewWidget.setRefreshDataListener(refreshDataListener);
        mAdapter = new ArrayAdapter<String>(PullToRefreshListViewDemo.this, android.R.layout.simple_list_item_1, mList);
        mListViewWidget.setAdapter(mAdapter);
        mHeaderTopView = new TextView(PullToRefreshListViewDemo.this);
        mHeadBootomView = new TextView(PullToRefreshListViewDemo.this);
        mHeaderTopView.setText("head");
        mHeadBootomView.setText("bottom");
        mListViewWidget.addUserTopHeaderView(mHeaderTopView);
        mListViewWidget.addUserBottomHeaderView(mHeadBootomView);
        mListViewWidget.setOnScrollListener(mListViewWidget);
    }

    private OnRefreshDataListener refreshDataListener = new OnRefreshDataListener() {

        @Override
        public void onRefreshData() {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    mList.clear();
                    mList.addAll(Arrays.asList((getResources().getStringArray(R.array.test_data))));
                    mListViewWidget.getPartialData();
                }
            }, 3 * 1000);
        }
    };

    private OnLoadDataListener loadDataListener = new OnLoadDataListener() {

        @Override
        public void onLoadData() {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    mList.addAll(Arrays.asList((getResources().getStringArray(R.array.test_data))));
                    mListViewWidget.getPartialData();
                }
            }, 3 * 1000);
        }
    };
}
