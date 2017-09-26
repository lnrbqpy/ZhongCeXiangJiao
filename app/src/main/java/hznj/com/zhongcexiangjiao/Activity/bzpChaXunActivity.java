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
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_tiaoma1;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.bzpChaXunBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class bzpChaXunActivity extends AppCompatActivity {
    private String      bbarcode;
    private ListView    lv_tm_bzp;
    //private String bzp="A00NC1703141412531703191412531NC160079";
    private ProgressBar jiazai1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bzp_cha_xun);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        bbarcode = bundle.getString("chengxing");
        initView();

        initData();

    }


    private void initView() {
        lv_tm_bzp = (ListView) findViewById(R.id.lv_tm_bzp);
        jiazai1 = (ProgressBar) findViewById(R.id.bzp_jiazai);

    }

    private void initData() {
        getDataFromServer();
    }


    public void getDataFromServer() {
        jiazai1.setVisibility(ViewPager.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getBzpChaXunBean(bbarcode).enqueue(new Callback<bzpChaXunBean>() {

            private List<bzpChaXunBean.ListBean> list_bzp;

            @Override
            public void onResponse(Call<bzpChaXunBean> call, Response<bzpChaXunBean> response) {
                bzpChaXunBean body = response.body();
                if (body != null) {
                    list_bzp = body.getList();
                    if (list_bzp.size() == 0) {
                        jiazai1.setVisibility(ViewPager.GONE);
                        Toast toast = Toast.makeText(getApplication(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    listAdapter_tiaoma1 listAdapter = new listAdapter_tiaoma1(list_bzp,getApplicationContext());
                    lv_tm_bzp.setAdapter(listAdapter);
                    jiazai1.setVisibility(ViewPager.GONE);
                    lv_tm_bzp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String bzp = list_bzp.get(i).getBARCODE();
                            Intent intent1 = new Intent();
                            intent1.setClass(getApplicationContext(), InquireActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("chengxing", bzp);
                            intent1.putExtras(bundle);
                            startActivity(intent1);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<bzpChaXunBean> call, Throwable t) {
                Toast toast = Toast.makeText(getApplication(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
                jiazai1.setVisibility(ViewPager.GONE);
            }
        });


    }
}
