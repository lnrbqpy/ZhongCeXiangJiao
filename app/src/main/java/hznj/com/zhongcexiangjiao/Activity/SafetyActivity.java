package hznj.com.zhongcexiangjiao.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.loginBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SafetyActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText zhanghao;
    private EditText mima;
    private Button   denglu;
    private String   userid;
    private String   password;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        initView();
        initData();
    }

    private void initData() {

    }


    private void initView() {
        zhanghao = (EditText) findViewById(R.id.zhanghao);
        mima = (EditText) findViewById(R.id.mima);
        denglu = (Button) findViewById(R.id.denglu);
        checkbox = (CheckBox) findViewById(R.id.sq_ck);
        /*zhanghao.setFocusable(false);
        mima.setFocusable(false);*/
        denglu.setOnClickListener(this);


    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.denglu:
                userid = zhanghao.getText().toString().trim().toUpperCase();
                password = mima.getText().toString().trim().toUpperCase();
                if (!TextUtils.isEmpty(userid) && !TextUtils.isEmpty(password)) {
                   /* if (checkbox.isChecked()) {
                        PrefUtils.setBoolean(this, "remember_password", true);
                        PrefUtils.setString(this, "userid", userid);
                        PrefUtils.setString(this, "password", password);

                    } else {
                        PrefUtils.remove(this, "userid");
                        PrefUtils.remove(this, "password");
                    }*/
                    getDataFromServer();
                } else {
                    Toast.makeText(getApplicationContext(), "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
       /*     case sq_ck:
                if (PrefUtils.getBoolean(this, "remember_password", false)) {
                    String zhanghao1 = PrefUtils.getString(this, "userid", "");
                    String mima1 = PrefUtils.getString(this, "password", "");
                    zhanghao.setText(zhanghao1);
                    mima.setText(mima1);
                    checkbox.setChecked(true);
                    break;

                }*/
        }
    }




    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getLoginBean(userid, password).enqueue(new Callback<loginBean>() {
            @Override
            public void onResponse(Call<loginBean> call, Response<loginBean> response) {
                Toast.makeText(getApplication(), "登陆成功", Toast.LENGTH_SHORT).show();
              //  TastyToast.makeText(getApplicationContext(), "登陆成功", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
                if (response.body() != null) {
                    List<loginBean.ListBean> list = response.body().getList();
                    if (!list.isEmpty()) {
                        String roleid = list.get(0).getROLEID();
                        Intent intent = new Intent();
                        //intent.setClass(getApplicationContext(), SafetQuery_Activity.class);
                        intent.setClass(getApplicationContext(), SafexuanzeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("roleid", roleid);
                        bundle.putString("userid", userid);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplication(), "账号密码不正确", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplication(), "数据访问异常", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<loginBean> call, Throwable t) {

            }
        });


    }
}
