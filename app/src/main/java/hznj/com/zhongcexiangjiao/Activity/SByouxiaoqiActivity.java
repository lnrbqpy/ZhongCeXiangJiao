package hznj.com.zhongcexiangjiao.Activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DatePickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SByouxiaoqiActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView  weizhi;
    private EditText shijian;
    private String DateTime;
    private Button fasong;
    private String stcode;
    private TextView shebei;
    private String SB="2004";
    private String shijian1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbyouxiaoqi);
        stcode = getIntent().getExtras().getString("stcode");
        shebei = (TextView) findViewById(R.id.yxq_shebei);
        weizhi = (TextView) findViewById(R.id.yxq_weizhi);
        shijian = (EditText) findViewById(R.id.yxq_shijian);
        fasong = (Button) findViewById(R.id.yxq_fasong);
        initDate();
    }

    private void initDate() {
        weizhi.setOnClickListener(this);
        shijian.setOnClickListener(this);
        fasong.setOnClickListener(this);
        shijian.setFocusable(false);
         weizhi.setText(stcode);
         shebei.setText("灭火器");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yxq_shijian:
                DatePickDialogUtil datePickDialogUtil = new DatePickDialogUtil(SByouxiaoqiActivity.this, DateTime);
                datePickDialogUtil.dateTimePicKDialog(shijian);

                break;
            case R.id.yxq_fasong:

                shijian1 = shijian.getText().toString();
                if (shijian1.equals("")) {
                    new AlertDialog.Builder(this).setTitle("错误操作").setMessage("请选择时间")
                            .setPositiveButton("确定", null).show();
                    return;
                }
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
        apiService.getYouXiaoQi(stcode,shijian1,SB).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(),"发送成功",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"发送失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
