package hznj.com.zhongcexiangjiao.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import hznj.com.zhongcexiangjiao.R;

public class monthly_planActivity1 extends AppCompatActivity implements View.OnClickListener{
    private EditText jhriqi;
    private Button   chaxun;
    private ListView chanliang;
    private ListView zongshu;
    private String   JIANCHA_DateTime ;
    private String jihuariqi ="201706";
    private String   quanbu ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_plan);
        jhriqi = (EditText) findViewById(R.id.yuejihua_riqi);
        chaxun = (Button) findViewById(R.id.jihua_chaxun);
        chanliang = (ListView) findViewById(R.id.jihua_chanliang);
        zongshu = (ListView) findViewById(R.id.jihua_zongshu);
        chaxun.setOnClickListener(this);
        jhriqi.setFocusable(false);
        
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jihua_chaxun:
                getDataFromServer();
               // getDateFromServer1();
                break;

        }
    }

    public void getDataFromServer() {



    }

}
