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

public class SafexuanzeActivity extends AppCompatActivity implements View.OnClickListener{

    private Button safe_quanbu;
    private Button safe_tiaoma;
    private String              roleid;
    private Bundle              bundle_safe_xuanze;
    private String              userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safexuanze);
        roleid =getIntent().getExtras().getString("roleid");
        userid =getIntent().getExtras().getString("userid");
        safe_quanbu = (Button) findViewById(R.id.safe_quanbu);
        safe_tiaoma = (Button) findViewById(R.id.safe_tiaoma);
        safe_quanbu.setOnClickListener(this);
        safe_tiaoma.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.safe_quanbu:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), SafetQuery_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("roleid1", roleid);
                bundle.putString("userid1",userid);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.safe_tiaoma:
                PermissionGen.needPermission(this, 100,
                        new String[]{
                                android.Manifest.permission.CAMERA,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,

                        });
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
        intent.setClass(getApplicationContext(), CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("roleid2", roleid);
        bundle.putString("userid2",userid);
        intent.putExtras(bundle);
        // Toast.makeText(getApplicationContext(),roleid+"---"+userid,Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    @PermissionFail(requestCode = 100)
    public void doFailSomething(){
        Toast.makeText(this, "Contact permission is not granted", Toast.LENGTH_SHORT).show();
    }
}
