package com.morgan.demo.slidemenu;

import android.os.Bundle;

import com.morgan.demo.BaseFragmentActivity;
import com.morgan.demo.R;
import com.morgan.library.widget.slidemenu.SlideMenu;

public class BaseSlideMenuActivity extends BaseFragmentActivity {
    private SlideMenu mSlideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_slidemenu_activity);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mSlideMenu = (SlideMenu) findViewById(R.id.slideMenu);
        mSlideMenu.setMenuWidth(200);
    }

    public void setSlideRole(int res) {
        if (null == mSlideMenu) {
            return;
        }
        getLayoutInflater().inflate(res, mSlideMenu, true);
    }

    public SlideMenu getSlideMenu() {
        return mSlideMenu;
    }
}
