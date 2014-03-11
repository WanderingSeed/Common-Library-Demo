package com.morgan.demo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>  {


    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Log.e("hhahaah", "execute");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testMakeDemoIntent() {
        assertEquals("com.morgan.demo", getActivity().makeDemoActivityIntent().getAction());
    }
}
