package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.loginYuanGongBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FitCSActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText fit_yuangong;
    private String bianhao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_cs);
        fit_yuangong = (EditText) findViewById(R.id.fit_yuangong);
        Button fit_btn = (Button) findViewById(R.id.fit_btn);
        fit_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fit_btn:
                bianhao = fit_yuangong.getText().toString().trim().toUpperCase();
                if (bianhao.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "员工编号不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    getDataFromServer();

                }


                break;
        }
    }

    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ApiService apiService = retrofit.create(ApiService.class);
        apiService.getloginYuangong(bianhao).enqueue(new Callback<loginYuanGongBean>() {
            @Override
            public void onResponse(Call<loginYuanGongBean> call, Response<loginYuanGongBean> response) {
                if (response.body()!=null) {
                    String result = response.body().getResult();
                    if (result.equals("1")) {
                        String personnelcode = response.body().getList().get(0).getPERSONNELCODE();
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("personnelcode", personnelcode);
                        intent.putExtras(bundle);
                        intent.setClass(getApplicationContext(), Araft_AxamineActivity.class);
                        startActivity(intent);

                      Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                       // TastyToast.makeText(getApplicationContext(), "登陆成功", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);
                    }else {
                        Toast.makeText(getApplicationContext(), "登陆失败", Toast.LENGTH_SHORT).show();
                       // TastyToast.makeText(getApplicationContext(), "登陆失败", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

                    }

                }
            }

            @Override
            public void onFailure(Call<loginYuanGongBean> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "登陆失败...网络异常", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
