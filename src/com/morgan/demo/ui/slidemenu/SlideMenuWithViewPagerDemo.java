package com.morgan.demo.ui.slidemenu;

import android.support.v4.view.ViewPager;

import com.morgan.demo.R;
import com.morgan.demo.mockdata.MockFragmentPagerAdapter;

/**
 * 包含ViewPager的SlideMenu。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-18
 */
public class SlideMenuWithViewPagerDemo extends BaseSlideMenuActivity {

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		setSlideRole(R.layout.demo_slidemenu_with_view_pager);
		setSlideRole(R.layout.slidemenu_primary_menu);
		setSlideRole(R.layout.slidemenu_secondary_menu);

		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setAdapter(new MockFragmentPagerAdapter(this,
				getSupportFragmentManager()));
	}

}
