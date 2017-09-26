package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.zxing.activity.CaptureActivity;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class CodeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);

        Button scaningCode = (Button) findViewById(R.id.ScanningCode);
        Button inquireCode = (Button) findViewById(R.id.InquireCode);
        Button craft = (Button) findViewById(R.id.craft);
        craft.setOnClickListener(this);
        inquireCode.setOnClickListener(this);
        scaningCode.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.ScanningCode:
                    PermissionGen.needPermission(this, 100,
                            new String[]{
                                    android.Manifest.permission.CAMERA,
                                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,

                            });
                    break;
                case R.id.InquireCode:
                    startActivity(new Intent(this, BarCodeQueryActivity.class));
                    break;
                case R.id.craft:

                    startActivity(new Intent(this, FitCSActivity.class));
                    break;

            }
    }
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
    }
}
