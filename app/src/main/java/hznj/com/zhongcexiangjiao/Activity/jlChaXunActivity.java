package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_tiaoma2;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.jlChaXunBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class jlChaXunActivity extends AppCompatActivity {
         private  String bbarcode;
    private ListView lv_tm_jl;
    private String jl="170312062L05204003~5020000014242~01006~EA037~2017-03-12~2~40~42~1~592";
    private ProgressBar jiazai2;
    private TextView ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jl_cha_xun);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        bbarcode = bundle.getString("chengxing");
        initView();

        initData();
    }


    private void initView() {
        lv_tm_jl = (ListView) findViewById(R.id.lv_tm_jl);
        jiazai2 = (ProgressBar) findViewById(R.id.jl_zzjz);
        ts = (TextView) findViewById(R.id.jl_ts);
    }

    private void initData() {
        getDataFromServer();
    }

    public void getDataFromServer() {
        jiazai2.setVisibility(ViewPager.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getJlChaXunBean(bbarcode).enqueue(new Callback<jlChaXunBean>() {
            private List<jlChaXunBean.ListBean> list;
            @Override
            public void onResponse(Call<jlChaXunBean> call, Response<jlChaXunBean> response) {
                jlChaXunBean body = response.body();
                if (body!=null) {
                    list = body.getList();
                    listAdapter_tiaoma2 listAdapter_t= new listAdapter_tiaoma2(list,getApplicationContext());
                    lv_tm_jl.setAdapter(listAdapter_t);
                    jiazai2.setVisibility(ViewPager.GONE);

                    lv_tm_jl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String code_jl = list.get(i).getBARCODE();
                            Intent intent4 = new Intent();
                            intent4.setClass(getApplicationContext(), InquireActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("chengxing", code_jl);
                            intent4.putExtras(bundle);
                            startActivity(intent4);
                        }
                    });
                }  else {
                    jiazai2.setVisibility(ViewPager.GONE);
                    Toast toast = Toast.makeText(getApplication(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }

            }

            @Override
            public void onFailure(Call<jlChaXunBean> call, Throwable t) {
              //  Toast.makeText(getApplicationContext(),"网络请求失败",Toast.LENGTH_LONG).show();
                jiazai2.setVisibility(ViewPager.GONE);
                Toast toast = Toast.makeText(getApplication(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
            }
        });

    }
}
