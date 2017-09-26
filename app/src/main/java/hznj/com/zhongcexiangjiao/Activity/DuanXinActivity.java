package hznj.com.zhongcexiangjiao.Activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DuanXinActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] YUANYIN = new String[]{"", "堵塞", "破损", "护栏损坏", "失效过期", "遗失", "卷帘门无动作", "异常报警",};
    private String[] SHEBEI  = new String[]{"", "安全出口", "疏散指示灯", "消火栓", "灭火器", "防火卷帘门", "空气采样器"};
    private String[] WEIZHI  = new String[]{"", "成型车间", "硫化车间", "准备车间", "成检车间"};
    private String   stcode;
    private TextView weizhi;
    private EditText jiancharen;
    private Spinner  wentishebei;
    private EditText shouji;
    private Spinner  wentiyuanyin;
    private Button   fasong;
    private String   s1;
    private String   s2;
    private int      position1;
    private Spinner  shebeiweizhi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duan_xin);
        stcode = getIntent().getExtras().getString("stcode");
        //  Toast.makeText(getApplicationContext(),stcode,Toast.LENGTH_SHORT).show();
        weizhi = (TextView) findViewById(R.id.dx_weizhi);
        jiancharen = (EditText) findViewById(R.id.dx_jiancharen);
        wentishebei = (Spinner) findViewById(R.id.dx_wentishebei);
        shouji = (EditText) findViewById(R.id.dx_shouji);
        wentiyuanyin = (Spinner) findViewById(R.id.dx_yuanyin);
        shebeiweizhi = (Spinner) findViewById(R.id.dx_shebeiweizhi);
        fasong = (Button) findViewById(R.id.dx_fasong);
        fasong.setOnClickListener(this);
        initDate();
    }

    private void initDate() {
        weizhi.setText(stcode);
        getSprinnerData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dx_fasong:
                getDataFromServer();
                break;
        }
    }

    public void getDataFromServer() {
        String jiancharen1 = jiancharen.getText().toString();
        String shouji1 = shouji.getText().toString();
        String weizhi1 = weizhi.getText().toString();
        if (jiancharen1.isEmpty() || shouji1.isEmpty() || position1 == 0) {
            new AlertDialog.Builder(this).setTitle("加载异常").setMessage("请选择问题设备和原因,且问题原因不能为完好")
                    .setPositiveButton("确定", null).show();
            return;

        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstants.OUTER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = retrofit.create(ApiService.class);
            apiService.getDuanXin(jiancharen1, shouji1, weizhi1, s1, s2).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Toast.makeText(getApplicationContext(), "发送成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "发送失败", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }

    public void getSprinnerData() {
        ArrayAdapter<String> shebei = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, SHEBEI);
        shebei.setDropDownViewResource(R.layout.spinner_dropdown_style);
        wentishebei.setAdapter(shebei);
        wentishebei.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s1 = SHEBEI[position].toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> yuanyin = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, YUANYIN);
        yuanyin.setDropDownViewResource(R.layout.spinner_dropdown_style);
        wentiyuanyin.setAdapter(yuanyin);
        wentiyuanyin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position1 = position;
                s2 = YUANYIN[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> weizhi = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, WEIZHI);
        weizhi.setDropDownViewResource(R.layout.spinner_dropdown_style);
        shebeiweizhi.setAdapter(weizhi);
        shebeiweizhi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    shouji.setText("15058140256");
                } else if (position == 2) {
                    shouji.setText("13732237908");
                } else if (position == 3) {
                    shouji.setText("18757192106");
                } else if (position == 4) {
                    shouji.setText("13989883866");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
