package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_ptkb1;
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_ptkb2;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DatePickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.ptkbBean;
import hznj.com.zhongcexiangjiao.doman.ptkbBean2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class peitaikanbanActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView ptkb_shuju1;
    private ListView ptkb_shuju2;

    private String   quanbu ="11R24.5";
    private Button ptkb_chaxun;
    private EditText ptkb_time;
    private String time;
    private String   DateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peitaikanban);
        initView();
        initDate();
    }
    private void initView() {
        ptkb_chaxun = (Button) findViewById(R.id.ptkb_chaxun);
        ptkb_shuju1 = (ListView) findViewById(R.id.ptkb_shuju1);
        ptkb_shuju2 = (ListView) findViewById(R.id.ptkb_shuju2);
        ptkb_time = (EditText) findViewById(R.id.ptkb_time);
        ptkb_chaxun.setOnClickListener(this);
        ptkb_time.setOnClickListener(this);
        ptkb_time.setFocusable(false);
    }
    private void initDate() {
       // getDataFromServer();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ptkb_time:
                DatePickDialogUtil dateMPickDialogUtil = new DatePickDialogUtil(peitaikanbanActivity.this, DateTime);
                dateMPickDialogUtil.dateTimePicKDialog(ptkb_time);
                break;
            case R.id.ptkb_chaxun:
                time = ptkb_time.getText().toString();
                getDataFromServer();
                break;
        }
    }

    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getPTKBBean(time,"").enqueue(new Callback<ptkbBean>() {
            @Override
            public void onResponse(Call<ptkbBean> call, Response<ptkbBean> response) {
                ptkbBean body = response.body();
                if (body!=null) {
                    List<ptkbBean.ListBean1> list1 = body.getList();
                    listAdapter_ptkb1 Adapter_ptkb1 = new listAdapter_ptkb1(getApplicationContext(),list1);
                    ptkb_shuju1.setAdapter(Adapter_ptkb1);

                }
            }

            @Override
            public void onFailure(Call<ptkbBean> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"数据请求有问题",Toast.LENGTH_SHORT).show();
            }
        });

        apiService.getPTKBBean2(time,"").enqueue(new Callback<ptkbBean2>() {
            @Override
            public void onResponse(Call<ptkbBean2> call, Response<ptkbBean2> response) {
                ptkbBean2 body = response.body();
                if (body!=null) {
                    List<ptkbBean2.ListBean> list2 = body.getList();
                    listAdapter_ptkb2 adapter_ptkb2 = new listAdapter_ptkb2(getApplicationContext(),list2);
                    ptkb_shuju2.setAdapter(adapter_ptkb2);

                }
            }

            @Override
            public void onFailure(Call<ptkbBean2> call, Throwable t) {

            }
        });
    }
}
