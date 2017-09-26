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

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.chengxingpeizhiAdapter;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DatePickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.chengxingpeizhiBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class chengxingpeizhiActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText cxpz_riqi;
    private Spinner  cxpz_banzu;
    private Button   cxpz_chaxun;
    private ListView cxpz_shuju;
    private String DateTime;
    private String riqis;
    private String[] cxpz_BANZU = new String[]{"早班", "中班", "晚班"};
    private String banzu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chengxingpeizhi);
        initView();
        initData();

    }

    private void initData() {
        getSprinnerData();
    }

    private void initView() {
        cxpz_riqi = (EditText) findViewById(R.id.cxpz_riqi);
        cxpz_banzu = (Spinner) findViewById(R.id.cxpz_banzu);
        cxpz_chaxun = (Button) findViewById(R.id.cxpz_chaxun);
        cxpz_shuju = (ListView) findViewById(R.id.cxpz_shuju);
        cxpz_riqi.setFocusable(false);
        cxpz_riqi.setOnClickListener(this);
        cxpz_chaxun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.cxpz_riqi:
              DatePickDialogUtil datePickDialogUtil = new DatePickDialogUtil(chengxingpeizhiActivity.this, DateTime);
              datePickDialogUtil.dateTimePicKDialog(cxpz_riqi);
              break;
          case R.id.cxpz_chaxun:
              riqis = cxpz_riqi.getText().toString();
              getSeverDate();
              break;
      }
    }

    public void getSprinnerData() {
        ArrayAdapter<String> stringAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style,R.id.txtvwSpinner,cxpz_BANZU);
        stringAdapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        cxpz_banzu.setAdapter(stringAdapter);
        cxpz_banzu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                banzu = cxpz_BANZU[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getSeverDate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getChengXingPeiZhi(riqis,banzu).enqueue(new Callback<chengxingpeizhiBean>() {
            @Override
            public void onResponse(Call<chengxingpeizhiBean> call, Response<chengxingpeizhiBean> response) {
                if (response.body()!=null) {
                    List<chengxingpeizhiBean.ListBean> list = response.body().getList();
                    chengxingpeizhiAdapter peizhiAdapter = new chengxingpeizhiAdapter(getApplicationContext(),list);
                    cxpz_shuju.setAdapter(peizhiAdapter);
                }
            }

            @Override
            public void onFailure(Call<chengxingpeizhiBean> call, Throwable t) {

            }
        });

    }
}
