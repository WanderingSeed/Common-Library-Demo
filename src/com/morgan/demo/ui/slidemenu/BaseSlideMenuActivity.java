package com.morgan.demo.ui.slidemenu;

import android.os.Bundle;

import com.morgan.demo.R;
import com.morgan.demo.base.BaseActionBarFragmentActivity;
import com.morgan.library.widget.slidemenu.SlideMenu;

/**
 * 包含SlideMenu的基类，其子类应该在onContentChanged中添加侧滑菜单页面的各个部分。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-18
 */
public class BaseSlideMenuActivity extends BaseActionBarFragmentActivity {

	private SlideMenu mSlideMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base_slidemenu);
	}

	/*
	 * onContentChanged()是Activity中的一个回调方法
	 * 当Activity的布局改动时，即setContentView()或者addContentView()方法执行完毕时就会调用该方法
	 */
	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mSlideMenu = (SlideMenu) findViewById(R.id.slideMenu);
		mSlideMenu.setMenuWidth(200);
	}

	/**
	 * 设置侧滑菜单页面的各个部分
	 * 
	 * @param res
	 *            该部分的id，在该布局中要有layout_role属性
	 */
	public void setSlideRole(int res) {
		if (null == mSlideMenu) {
			return;
		}
		getLayoutInflater().inflate(res, mSlideMenu, true);
	}

}
