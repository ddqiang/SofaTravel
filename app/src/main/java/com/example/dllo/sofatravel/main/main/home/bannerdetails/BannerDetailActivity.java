package com.example.dllo.sofatravel.main.main.home.bannerdetails;

import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;

/**
 * Created by dllo on 16/7/20.
 */
public class BannerDetailActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mBackIv, mShareIv;
    private TextView mTitleTv;
    private WebView mWebView;

    @Override
    public int getLayout() {
        return R.layout.activity_banner_detail;
    }

    @Override
    public void initView() {
        mBackIv = (ImageView) findViewById(R.id.banner_detail_back);
        mShareIv = (ImageView) findViewById(R.id.banner_detail_share);
        mTitleTv = (TextView) findViewById(R.id.banner_detail_title);
        mWebView = (WebView) findViewById(R.id.banner_detail_webView);

        mBackIv.setOnClickListener(this);
        mShareIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        String title = getIntent().getStringExtra("title");
        mTitleTv.setText(title);
        mWebView.loadUrl(getIntent().getStringExtra("webUrl"));
        //处理VebView 的页面控制和请求通知
        webViewClient();
    }

    private void webViewClient() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //f返回值为true 的时候控制网页 在 VebView 中去打开,如果为false 调用系统浏览器
                mWebView.loadUrl(getIntent().getStringExtra("webUrl"));
                return true;
            }
        });

        //启动支持 javaScript
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        //webView 加载页面优先使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banner_detail_back:
                finish();
                break;
            case R.id.banner_detail_share:
                break;
        }

    }
}
