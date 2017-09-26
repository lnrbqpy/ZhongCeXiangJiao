package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import hznj.com.zhongcexiangjiao.R;


public class jihuaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jihua);
        Button scjh_zh = (Button) findViewById(R.id.scjh_zh);
        Button scjh_cxjh = (Button) findViewById(R.id.scjh_cxjh);
        Button scjh_cxpz = (Button) findViewById(R.id.scjh_cxpz);
        Button  scjh_ptkb= (Button) findViewById(R.id.scjh_ptkb);
        scjh_cxjh.setOnClickListener(this);
        scjh_zh.setOnClickListener(this);
        scjh_cxpz.setOnClickListener(this);
        scjh_ptkb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
           switch (view.getId()){
               case R.id.scjh_zh:
                   startActivity(new Intent(this, monthly_planActivity.class));
                   break;
               case R.id.scjh_cxjh:
                   startActivity(new Intent(this,ChengXingJiHuaActivity.class));
                   break;
               case R.id.scjh_cxpz:
                    startActivity(new Intent(this, chengxingpeizhiActivity.class));
                   break;
               case R.id.scjh_ptkb:
                   startActivity(new Intent(this,peitaikanbanActivity.class));
                   break;

           }
    }
}
