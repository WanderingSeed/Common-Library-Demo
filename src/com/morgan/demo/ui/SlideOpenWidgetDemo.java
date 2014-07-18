package com.morgan.demo.ui;

import android.os.Bundle;

import com.morgan.demo.R;
import com.morgan.demo.base.BaseActionBarActivity;

/**
 * 向上拉开图片的demo，类似一个向上拉开的门。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-18
 */
public class SlideOpenWidgetDemo extends BaseActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_slide_open_widget);
	}
}
