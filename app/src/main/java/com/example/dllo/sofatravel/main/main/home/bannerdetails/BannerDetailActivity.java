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

    private ImageView backIv, shareIv;
    private TextView titleTv;
    private WebView webView;

    @Override
    public int getLayout() {
        return R.layout.activity_banner_detail;
    }

    @Override
    public void initView() {
        backIv = (ImageView) findViewById(R.id.banner_detail_back);
        shareIv = (ImageView) findViewById(R.id.banner_detail_share);
        titleTv = (TextView) findViewById(R.id.banner_detail_title);
        webView = (WebView) findViewById(R.id.banner_detail_webView);

        backIv.setOnClickListener(this);
        shareIv.setOnClickListener(this);
    }

    @Override
    public void initData() {
        String title = getIntent().getStringExtra("title");
        titleTv.setText(title);
        webView.loadUrl(getIntent().getStringExtra("webUrl"));
        //处理VebView 的页面控制和请求通知
        webViewClient();
    }

    private void webViewClient() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //f返回值为true 的时候控制网页 在 VebView 中去打开,如果为false 调用系统浏览器
                webView.loadUrl(getIntent().getStringExtra("webUrl"));
                return true;
            }
        });

        //启动支持 javaScript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //webView 加载页面优先使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebChromeClient(new WebChromeClient() {
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
