package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_bzp2;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.jiaoliaoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class jiaoliaoActivity extends AppCompatActivity {

    private  String s;
    private ListView list_jiaoliao;
  //  private static String ss ="A00TQ1704170108351704220108351TQ170003";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaoliao);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        s = bundle.getString("jiaoliao");
        Log.i("sss",s);
     /*   if (bbarcode == null) {
            bbarcode = "0";
        }*/
        initView();
        initData();
    }

    private void initView() {
        list_jiaoliao = (ListView) findViewById(R.id.list_jiaoliao);

    }

    private void initData() {
        getDataFromServer();
    }

    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getJiaoliaoBean(s).enqueue(new Callback<jiaoliaoBean>() {

            private List<jiaoliaoBean.ListBean> listjl;

            @Override
            public void onResponse(Call<jiaoliaoBean> call, Response<jiaoliaoBean> response) {
                jiaoliaoBean body = response.body();
                if (body!=null) {
                    listjl = body.getList();
                    if (listjl.size()==0) {
                        Toast toast = Toast.makeText(getApplication(), "服务器暂无信息", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    listAdapter_bzp2 listAdapter_jiaoliao = new listAdapter_bzp2(listjl,getApplication());
                        list_jiaoliao.setAdapter(listAdapter_jiaoliao);
                        list_jiaoliao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String barcode = listjl.get(i).getBARCODE();
                            Intent intent2 = new Intent();
                            intent2.setClass(getApplicationContext(), webjiaoliaoAdapter.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("jiaoliaochangma", barcode);
                            intent2.putExtras(bundle);
                            startActivity(intent2);
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call<jiaoliaoBean> call, Throwable t) {

            }
        });

    }
}
