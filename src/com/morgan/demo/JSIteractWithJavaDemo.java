package com.morgan.demo;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class JSIteractWithJavaDemo extends BaseActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.js_interact_with_java_demo);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new Object() {
            @SuppressWarnings("unused")
            public void onClick() {
                Toast.makeText(JSIteractWithJavaDemo.this, "you success",
                        Toast.LENGTH_LONG).show();
                mWebView.loadUrl("javascript:updateHtml()");
            }
        }, "jsdemo");
        mWebView.loadUrl("file:///android_asset/index.html");
    }
}