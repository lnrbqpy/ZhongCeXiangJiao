package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;

public class datajumpActivity extends AppCompatActivity implements View.OnClickListener {
    private String   riqi;
    private String   guige;
    private String   cengji;
    private String   huawen;
    private String   xilie;
    private String   bc;
    private String   bz;
    private String   jt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datajump);
        riqi = getIntent().getExtras().getString("riqi");
        guige = getIntent().getExtras().getString("guige");
        cengji = getIntent().getExtras().getString("cengji");
        // cengji = cengji_1.replace("+", "%2B");
        huawen = getIntent().getExtras().getString("huawen");
        xilie = getIntent().getExtras().getString("xilie");
        bc = getIntent().getExtras().getString("bc");
        bz = getIntent().getExtras().getString("bz");
        jt = getIntent().getExtras().getString("jt");
        Toast.makeText(getApplicationContext(), riqi + "--" + guige + "--" + this.cengji + "--" + huawen + "--" + xilie + "--" + bc + "--" + bz + "--" + jt, Toast.LENGTH_SHORT).show();

        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        Button chaxunshigong = (Button) findViewById(R.id.dj_chaxunshigong);
        Button lurushigong = (Button) findViewById(R.id.dj_lurushigong);
        Button lurushuju = (Button) findViewById(R.id.dj_lurushuju);
        chaxunshigong.setOnClickListener(this);
        lurushigong.setOnClickListener(this);
        lurushuju.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.dj_chaxunshigong:

                break;
            case R.id.dj_lurushigong:

                bundle.putString("riqi", riqi);
                bundle.putString("guige", guige);
                bundle.putString("cengji", cengji);
                bundle.putString("huawen", huawen);
                bundle.putString("xilie", xilie);
                bundle.putString("bc", bc);
                bundle.putString("bz", bz);
                bundle.putString("jt", jt);
                intent.putExtras(bundle);
                intent.setClass(getApplicationContext(), standardataActivity.class);
                startActivity(intent);
                break;
            case R.id.dj_lurushuju:
                bundle.putString("riqi", riqi);
                bundle.putString("guige", guige);
                bundle.putString("cengji", cengji);
                bundle.putString("huawen", huawen);
                bundle.putString("xilie", xilie);
                bundle.putString("bc", bc);
                bundle.putString("bz", bz);
                bundle.putString("jt", jt);
                intent.putExtras(bundle);
                intent.setClass(getApplicationContext(), BuildingCSActivity.class);
                startActivity(intent);
                break;
        }

    }
}
