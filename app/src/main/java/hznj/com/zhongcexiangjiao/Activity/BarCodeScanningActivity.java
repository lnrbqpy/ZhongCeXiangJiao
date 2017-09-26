package hznj.com.zhongcexiangjiao.Activity;
/**
 * 条码扫描结果搜索
  */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import hznj.com.zhongcexiangjiao.R;


public class BarCodeScanningActivity extends AppCompatActivity {

    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_scanning);
        initView();
        initDate();

    }

    private void initDate() {
        result = getIntent().getExtras().getString("result");
        TextView viewById = (TextView) findViewById(R.id.TIAOMA);
        viewById.setText(result);
    }

    private void initView() {

    }
    /**
     * 扫描返回数据  等待搜索匹配数据
      */


}