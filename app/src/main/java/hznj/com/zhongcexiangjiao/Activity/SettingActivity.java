package hznj.com.zhongcexiangjiao.Activity;
/**
 *设置界面
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import hznj.com.zhongcexiangjiao.R;


public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back;
    private Button save;
    private Button setPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initView();

    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        save = (Button) findViewById(R.id.save);
        setPassword = (Button) findViewById(R.id.setPassword);
        back.setOnClickListener(this);
        save.setOnClickListener(this);
        setPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.save:
                break;
            case R.id.back:
                SettingActivity.this.finish();
            case R.id.setPassword:


        }
    }


}
