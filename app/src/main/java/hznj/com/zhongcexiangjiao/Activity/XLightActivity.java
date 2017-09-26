package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.glide.GlideUtils;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.zhaopianBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class XLightActivity extends AppCompatActivity {

    private ImageView iv_xguang;
     private String   bbarcode ;
    private String ZZ="D7E9B50217";
    private ProgressBar jiazai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlight);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bbarcode = bundle.getString("chengxing");
        initData();
    }

    private void initData() {
        iv_xguang = (ImageView) findViewById(R.id.iv_xguang);
        jiazai = (ProgressBar) findViewById(R.id.pb_jiazai);
        ShowProgressBar();
        CloseProgressBar();
        getDataFromServer();
    }

    private void CloseProgressBar() {
        jiazai.setVisibility(ViewPager.GONE);
    }

    private void ShowProgressBar() {
        jiazai.setVisibility(ViewPager.VISIBLE);
    }

    public void getDataFromServer() {
        ShowProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getzhapianBean(bbarcode).enqueue(new Callback<zhaopianBean>() {
            @Override
            public void onResponse(Call<zhaopianBean> call, Response<zhaopianBean> response) {
                zhaopianBean body = response.body();
                if (body!=null) {
                    List<zhaopianBean.ListBean> list = body.getList();
                        GlideUtils.display(getApplicationContext(),iv_xguang,list.get(0).getPICURL());
                        CloseProgressBar();

                    }



            }


            @Override
            public void onFailure(Call<zhaopianBean> call, Throwable t) {

            }
        });

        }



    }


