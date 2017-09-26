package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import hznj.com.zhongcexiangjiao.R;

public class photoActivity extends AppCompatActivity {

    private WebView web_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        web_photo = (WebView) findViewById(R.id.web_photo);

    }
}
