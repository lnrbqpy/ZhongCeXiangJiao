package hznj.com.zhongcexiangjiao.Activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class Safety2Activity extends AppCompatActivity implements View.OnClickListener {


    private EditText zhanghao;
    private EditText mima;
    private Button   denglu;
    private String   userid;
    private String   password;
    private CheckBox checkbox;
    SharedPreferences sp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        sp = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        initView();
    }

    private void initView() {
        zhanghao = (EditText) findViewById(R.id.zhanghao);
        mima = (EditText) findViewById(R.id.mima);
        denglu = (Button) findViewById(R.id.denglu);
        checkbox = (CheckBox) findViewById(R.id.sq_ck);
        if (sp.getBoolean("checkboxBoolean", false))
        {
            zhanghao.setText(sp.getString("uname", null));
            mima.setText(sp.getString("upswd", null));
            checkbox.setChecked(true);
            }
        denglu.setOnClickListener(this);


    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.denglu:
                userid = zhanghao.getText().toString().trim().toUpperCase();
                password = mima.getText().toString().trim().toUpperCase();
                if (!TextUtils.isEmpty(userid) && !TextUtils.isEmpty(password)) {
                    boolean CheckBoxLogin = checkbox.isChecked();
                    if (CheckBoxLogin)
                    {
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("uname", userid);
                        editor.putString("upswd", password);
                        editor.putBoolean("checkboxBoolean", true);
                        editor.commit();
                        }

                    else {
                       SharedPreferences.Editor editor = sp.edit();
                       editor.putString("uname", null);
                       editor.putString("upswd", null);
                       editor.putBoolean("checkboxBoolean", false);
                       editor.commit();
                       }
                    getDataFromServer();
                } else {
                    Toast.makeText(getApplicationContext(), "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
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
