package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ProgressBar;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.lhTuPianBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class VulcanizeActivity extends AppCompatActivity {
       private String bbarcode;
    private ProgressBar jiazai;
    private boolean isLoading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vulcanize);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bbarcode = bundle.getString("chengxing");
        jiazai = (ProgressBar) findViewById(R.id.web_lh);
        ShowProgressBar();
        CloseProgressBar();
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
        apiService.getLhTuPianBean(bbarcode).enqueue(new Callback<lhTuPianBean>() {
            @Override
            public void onResponse(Call<lhTuPianBean> call, Response<lhTuPianBean> response) {
                lhTuPianBean body = response.body();
                if (body!=null) {
                    List<lhTuPianBean.ListBean> list = body.getList();
                    WebView webView = new WebView(getApplicationContext());
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.getSettings().setBuiltInZoomControls(true);
                    webView.getSettings().setLoadWithOverviewMode(true);
                    webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    webView.loadUrl(list.get(0).getASPXURL());
                    setContentView(webView);
                    CloseProgressBar();
                }
            }

            @Override
            public void onFailure(Call<lhTuPianBean> call, Throwable t) {

            }
        });
    }


}
