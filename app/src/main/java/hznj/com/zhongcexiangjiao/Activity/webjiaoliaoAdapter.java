package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.shujukaBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class webjiaoliaoAdapter extends AppCompatActivity {

      private String bbarcode;
    private ProgressBar jiazai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webjiaoliao_adapter);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bbarcode = bundle.getString("jiaoliaochangma");
        jiazai = (ProgressBar) findViewById(R.id.web_jl);
        initData();
    }

    private void CloseProgressBar() {
        jiazai.setVisibility(ViewPager.GONE);
    }

    private void ShowProgressBar() {
        jiazai.setVisibility(ViewPager.VISIBLE);
    }

    private void initData() {
        getDataFromServer();
    }

    public void getDataFromServer() {
        ShowProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getShujukaBean(bbarcode).enqueue(new Callback<shujukaBean>() {
            @Override
            public void onResponse(Call<shujukaBean> call, Response<shujukaBean> response) {
                shujukaBean body = response.body();
                if (body!=null) {
                    List<shujukaBean.ListBean> list = body.getList();
                    WebView webView = new WebView(getApplicationContext());
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setBuiltInZoomControls(true);
                    webView.getSettings().setLoadWithOverviewMode(true);
                    webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    //webView.loadUrl(list.get(0).getHTMLURL());
                    webView.loadUrl("http://171.188.42.56:8081/app/html/gumInfo.html");
                    setContentView(webView);
                    CloseProgressBar();
                }  else {
                    CloseProgressBar();
                    Toast.makeText(getApplicationContext(),"数据加载失败", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<shujukaBean> call, Throwable t) {
                 CloseProgressBar();
                Toast.makeText(getApplicationContext(),"网络请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
