package com.morgan.demo.slidemenu;

import android.support.v4.view.ViewPager;

import com.morgan.demo.R;
import com.morgan.demo.mockdata.DragableFragmentPagerAdapter;

public class SlideMenuWithViewPagerDemo extends BaseSlideMenuActivity {

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        setSlideRole(R.layout.slidemenu_with_view_pager_demo);
        setSlideRole(R.layout.slidemenu_primary_menu);
        setSlideRole(R.layout.slidemenu_secondary_menu);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new DragableFragmentPagerAdapter(this, getSupportFragmentManager()));
    }

}
