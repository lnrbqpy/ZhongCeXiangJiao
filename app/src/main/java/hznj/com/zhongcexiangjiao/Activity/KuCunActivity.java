package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.jh_zongshu_Adapter;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DateMPickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.jh_zongshuBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KuCunActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText        kc_shijian;
    private Button          kc_chaxun;
    private String          DateTime;
    private String          shijian;
    private ListView kc_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ku_cun);
        //getInterSever();
        initView();

        initData();

    }


    private void initView() {
        kc_shijian = (EditText) findViewById(R.id.kc_shijian);
        kc_chaxun = (Button) findViewById(R.id.kc_chaxun);
        kc_lv = (ListView) findViewById(R.id.kc_lv);
        kc_shijian.setOnClickListener(this);
        kc_chaxun.setOnClickListener(this);
        kc_shijian.setFocusable(false);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kc_shijian:
                DateMPickDialogUtil dateUtil = new DateMPickDialogUtil(KuCunActivity.this, DateTime);
                dateUtil.dateTimePicKDialog(kc_shijian);
                break;

            case R.id.kc_chaxun:
                shijian = kc_shijian.getText().toString();
                getInterSever();
                break;
        }
    }

    public void getInterSever() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getzongshu(shijian,"11R24.5").enqueue(new Callback<jh_zongshuBean>() {
            @Override
            public void onResponse(Call<jh_zongshuBean> call, Response<jh_zongshuBean> response) {
                Toast.makeText(getApplicationContext(),"chenggong",Toast.LENGTH_SHORT).show();
                if (response.body() != null) {
                    List<jh_zongshuBean.ListBean> list = response.body().getList();
                    jh_zongshu_Adapter zongshuAdapter = new jh_zongshu_Adapter(getApplicationContext(), list);
                    kc_lv.setAdapter(zongshuAdapter);
                }
            }

            @Override
            public void onFailure(Call<jh_zongshuBean> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"shibai",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
