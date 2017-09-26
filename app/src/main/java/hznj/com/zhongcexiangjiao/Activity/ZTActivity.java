package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.global.GlobalConstants;


public class ZTActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zt);
        WebView webView = new WebView(getApplicationContext());
        webView.loadUrl(GlobalConstants.ZhuangTai);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        setContentView(webView);
    }


}
