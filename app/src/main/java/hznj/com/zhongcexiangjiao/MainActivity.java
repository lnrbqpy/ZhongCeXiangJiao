package hznj.com.zhongcexiangjiao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.Activity.CodeActivity;
import hznj.com.zhongcexiangjiao.Activity.Safety2Activity;
import hznj.com.zhongcexiangjiao.Activity.ZTActivity;
import hznj.com.zhongcexiangjiao.Activity.jihuaActivity;
import kr.co.namee.permissiongen.PermissionGen;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView bar_codeScanning;
    private ImageView bar_code_query;
    private ImageView detection;
    private ImageView set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
    }


    /**
     * 初始化控件
     */
    private void initView() {
        bar_codeScanning = (ImageView) findViewById(R.id.bar_code_Scanning);
        bar_code_query = (ImageView) findViewById(R.id.bar_code_query);
        detection = (ImageView) findViewById(R.id.detection);
        set = (ImageView) findViewById(R.id.set);
        bar_codeScanning.setOnClickListener(this);
        bar_code_query.setOnClickListener(this);
        detection.setOnClickListener(this);
        set.setOnClickListener(this);


    }

    private void initData() {
         PermissionGen.needPermission(this, 100,
                        new String[]{
                                android.Manifest.permission.CAMERA,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                android.Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS
                        });
    }
    /**
     * 主界面的跳转
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar_code_Scanning:
                //startActivity(new Intent(this, ZBarActivity.class));
                startActivity(new Intent(this,CodeActivity.class));
               /* PermissionGen.needPermission(this, 100,
                        new String[]{
                                android.Manifest.permission.CAMERA,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                        });*/

                break;
            case R.id.bar_code_query:
                //  startActivity(new Intent(this, BarCodeQueryActivity.class));
                startActivity(new Intent(this, jihuaActivity.class));
                break;
            case R.id.detection:
                startActivity(new Intent(this, ZTActivity.class));
                break;
            case R.id.set:
                startActivity(new Intent(this, Safety2Activity.class));
                break;
        }

    }
/*
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void requestLocSuccess() {
        Intent intent = new Intent();
        intent.setClass(this, CaptureActivity.class);
        startActivityForResult(intent, 0);
    }
    @PermissionFail(requestCode = 100)
    public void doFailSomething(){
        Toast.makeText(this, "Contact permission is not granted", Toast.LENGTH_SHORT).show();
    }*/


    // 定义一个变量，来标识是否退出
    private static boolean isExit = false;

    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }
}
