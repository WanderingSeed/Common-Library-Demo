package com.morgan.demo;

import com.morgan.demo.data.Constants;

import android.test.ActivityInstrumentationTestCase2;

/**
 * 测试MainActivity。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-15
 */
public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testMakeDemoIntent() {
		assertEquals(Constants.DEMO_ACTION, getActivity()
				.createDemoActivityIntent().getAction());
	}
}
