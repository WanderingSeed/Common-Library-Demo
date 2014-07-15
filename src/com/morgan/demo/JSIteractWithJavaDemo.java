package com.morgan.demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class JSIteractWithJavaDemo extends BaseActionBarActivity {

    private WebView mWebView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_interact_with_java_demo);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new Object() {
            @JavascriptInterface //这个annotation用于兼容17以后的版本
            public void onClick() {
                Toast.makeText(JSIteractWithJavaDemo.this, "you success",
                        Toast.LENGTH_LONG).show();
                mWebView.loadUrl("javascript:updateHtml()");
            }
        }, "jsdemo");
        mWebView.loadUrl("file:///android_asset/index.html");
    }
}
