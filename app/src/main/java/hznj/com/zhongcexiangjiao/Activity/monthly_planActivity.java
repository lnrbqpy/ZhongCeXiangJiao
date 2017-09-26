package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.jh_zongshu_Adapter;
import hznj.com.zhongcexiangjiao.Adapter.jihuachanliang_Adapter;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DateMPickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.jh_chanliangBean;
import hznj.com.zhongcexiangjiao.doman.jh_zongshuBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class monthly_planActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText jhriqi;
    private Button   chaxun;
    private ListView chanliang;
    private ListView zongshu;
    private String   JIANCHA_DateTime ;
    private String jihuariqi ="201706";
    private String   quanbu ="11R24.5";
    private String DateTime;
    private String riqi1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_plan);
        jhriqi = (EditText) findViewById(R.id.yuejihua_riqi);
        chaxun = (Button) findViewById(R.id.jihua_chaxun);
        chanliang = (ListView) findViewById(R.id.jihua_chanliang);
        zongshu = (ListView) findViewById(R.id.jihua_zongshu);
        chaxun.setOnClickListener(this);
        jhriqi.setOnClickListener(this);
        jhriqi.setFocusable(false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.yuejihua_riqi:
                DateMPickDialogUtil dateUtil = new DateMPickDialogUtil(monthly_planActivity.this, DateTime);
                dateUtil.dateTimePicKDialog(jhriqi);
                break;
            case R.id.jihua_chaxun:
                getDataFromServer();
               // getDateFromServer1();
                break;

        }
    }

    public void getDataFromServer() {
        riqi1 = jhriqi.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         ApiService apiService = retrofit.create(ApiService.class);
        apiService.getJihuachanliangBean(riqi1, "").enqueue(new Callback<jh_chanliangBean>() {
            @Override
            public void onResponse(Call<jh_chanliangBean> call, Response<jh_chanliangBean> response) {
                jh_chanliangBean body = response.body();
                if (body != null) {
                    List<jh_chanliangBean.ListBean> list_chanliang = body.getList();
                    Log.i("111", body.getList().toString() + "--------" + body.getList().size() + "------" +
                            list_chanliang.toString()
                    );

                    jihuachanliang_Adapter jihuachanliang_adapter = new jihuachanliang_Adapter(getApplicationContext(), list_chanliang);
                    chanliang.setAdapter(jihuachanliang_adapter);
                }
            }

            @Override
            public void onFailure(Call<jh_chanliangBean> call, Throwable t) {

            }
        });

        apiService.getPlanzongshuBean(riqi1,"").enqueue(new Callback<jh_zongshuBean>() {
            @Override
            public void onResponse(Call<jh_zongshuBean> call, Response<jh_zongshuBean> response) {
                Toast.makeText(getApplicationContext(),"chenggong",Toast.LENGTH_SHORT).show();
                if (response.body()!=null) {
                    Toast.makeText(getApplicationContext(),"shibai",Toast.LENGTH_SHORT).show();
                    List<jh_zongshuBean.ListBean> lists = response.body().getList();
                    jh_zongshu_Adapter zongshuAdapter = new jh_zongshu_Adapter(getApplicationContext(), lists);
                    zongshu.setAdapter(zongshuAdapter);
                }
            }

            @Override
            public void onFailure(Call<jh_zongshuBean> call, Throwable t) {

            }
        });
    }
}
