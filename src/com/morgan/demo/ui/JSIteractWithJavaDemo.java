package com.morgan.demo.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.morgan.demo.R;
import com.morgan.demo.base.BaseActionBarActivity;

/**
 * 一个js和java交互的例子。
 * 
 * @author JiGuoChao
 * 
 * @version 1.0
 * 
 * @date 2014-7-18
 */
public class JSIteractWithJavaDemo extends BaseActionBarActivity {

	private WebView mWebView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo_js_interact_with_java);
		mWebView = (WebView) findViewById(R.id.webView);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.addJavascriptInterface(new Object() {

			// 这个annotation用于兼容17以后的版本
			@JavascriptInterface
			public void onClick() {
				Toast.makeText(JSIteractWithJavaDemo.this, R.string.success,
						Toast.LENGTH_SHORT).show();
				mWebView.loadUrl("javascript:updateHtml()");
			}
		}, "jsdemo");
		mWebView.loadUrl("file:///android_asset/index.html");
	}
}
