package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.chengxingjihuaAdapter;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DatePickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.chengxingjihuaBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ChengXingJiHuaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText riqi;
    private Spinner  banzu;
    private Button   chaxun;
    private String   DateTime;
    private String[] cxjh_BANZU = new String[]{"早班", "中班", "晚班"};
    private String riqis;
    private String banZu;
    private ListView shuju;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheng_xing_ji_hua);
        initView();
        initData();
    }


    private void initView() {
        riqi = (EditText) findViewById(R.id.cxjh_riqi);
        banzu = (Spinner) findViewById(R.id.cxjh_banzu);
        chaxun = (Button) findViewById(R.id.cxjh_chaxun);
        shuju = (ListView) findViewById(R.id.cxjh_shuju);
        riqi.setOnClickListener(this);
        chaxun.setOnClickListener(this);
        //banzu.setOnClickListener(this);
    }

    private void initData() {
        riqi.setFocusable(false);
        getSprinnerData();


    }

    public void getSprinnerData() {
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style,R.id.txtvwSpinner,cxjh_BANZU);
        stringAdapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        banzu.setAdapter(stringAdapter);
        banzu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                banZu = cxjh_BANZU[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cxjh_riqi:
                DatePickDialogUtil datePickDialogUtil = new DatePickDialogUtil(ChengXingJiHuaActivity.this, DateTime);
                datePickDialogUtil.dateTimePicKDialog(riqi);

                break;
            case R.id.cxjh_chaxun:
              riqis = riqi.getText().toString();
                getSeverDate();
                break;

        }
    }

    public void getSeverDate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
       apiService.getChengXingJiHua(riqis,banZu).enqueue(new Callback<chengxingjihuaBean>() {
           @Override
           public void onResponse(Call<chengxingjihuaBean> call, Response<chengxingjihuaBean> response) {
               Toast.makeText(getApplicationContext(),"请求成功",Toast.LENGTH_SHORT).show();
               if (response.body()!=null) {
                   List<chengxingjihuaBean.ListBean> list = response.body().getList();
                   chengxingjihuaAdapter jihuaAdapter = new chengxingjihuaAdapter(getApplicationContext(), list);
                   shuju.setAdapter(jihuaAdapter);
               }
           }

           @Override
           public void onFailure(Call<chengxingjihuaBean> call, Throwable t) {
               Toast.makeText(getApplicationContext(),"请求失败",Toast.LENGTH_SHORT).show();
           }
       });
    }
}
