package hznj.com.zhongcexiangjiao.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.RxBus;
import hznj.com.zhongcexiangjiao.Uilts.rxBean;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Safet_inspect_Activity2 extends AppCompatActivity implements View.OnClickListener {
    private static String   AQ         = "";
    private static String   ZHENGCHANG = "OK";
    private static String   CUOWU      = "NG";
    private        String[] wenti      = new String[]{"", "堵塞", "破损", "护栏损坏", "失效过期", "遗失", "卷帘门无动作", "异常报警",};
    private TextView   name;
    private Spinner    sq_spinner;
    private EditText   beizhu;
    private TextView   anquanchukou;
    private TextView   shusanzhishideng;
    private TextView   xiaohuoshuan;
    private TextView   juanlianmen;
    private TextView   kongqicaiji;
    private TextView   miehuoqi;
    private String     yuanyin;
    private Button     wanhao;
    private Button     cuowutijiao;
    private String     stcode;
    private String     roleid;
    private String     typeid;
    private String     userid;
    private String     zhuangzhimingcheng;
    private String     text;
    private int        position1;
    private Button     paizhao;
    private Button     shangchuan;
    private String     sdPath;//SD卡的路径
    private String     picPath;//图片存储路径
    private String     name1;
    private ApiService apiService;
    private static int    CHOOSE_IMAGE = 2;
    private        String urls          = "http://171.188.42.56:8081/app/models/Uploadpicture.aspx";
    public static final String TAG = "MainActivity";
    ValueCallback<Uri> mUploadMessage;
    private Button duanxin;
    private Button youxiaoqi;
    private TextView weizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safet_inspect);
        stcode = getIntent().getExtras().getString("result");
        roleid = getIntent().getExtras().getString("roleid");
        userid = getIntent().getExtras().getString("userid");
       // Toast.makeText(getApplicationContext(),stcode+"---"+roleid+"---"+userid,Toast.LENGTH_SHORT).show();
        initView();
        initData();
    }

    private void initView() {
        // gv_sq = (GridView) findViewById(R.id.sq_gv_selecter);
        youxiaoqi = (Button) findViewById(R.id.youxiaoqi);
        name = (TextView) findViewById(R.id.sq_shebei_name);
        sq_spinner = (Spinner) findViewById(R.id.sq_spinner);
        beizhu = (EditText) findViewById(R.id.sq_beizhu);
        anquanchukou = (TextView) findViewById(R.id.anquanchukou);
        shusanzhishideng = (TextView) findViewById(R.id.shusanzhishideng);
        xiaohuoshuan = (TextView) findViewById(R.id.xiaohuoshuan);
        juanlianmen = (TextView) findViewById(R.id.juanlianmen);
        kongqicaiji = (TextView) findViewById(R.id.kongqicaiji);
        miehuoqi = (TextView) findViewById(R.id.miehuoqi);
        wanhao = (Button) findViewById(R.id.sq_btn_wanhao);
        cuowutijiao = (Button) findViewById(R.id.sq_btn_wenti);
        paizhao = (Button) findViewById(R.id.paizhao);
        shangchuan = (Button) findViewById(R.id.chakanphoto);
        duanxin = (Button) findViewById(R.id.sq_btn_duanxin);
        weizhi = (TextView) findViewById(R.id.ip_weizhi);
        weizhi.setText(stcode);
        wanhao.setOnClickListener(this);
        cuowutijiao.setOnClickListener(this);
        anquanchukou.setOnClickListener(this);
        shusanzhishideng.setOnClickListener(this);
        xiaohuoshuan.setOnClickListener(this);
        miehuoqi.setOnClickListener(this);
        juanlianmen.setOnClickListener(this);
        kongqicaiji.setOnClickListener(this);
        paizhao.setOnClickListener(this);
        shangchuan.setOnClickListener(this);
        duanxin.setOnClickListener(this);
        youxiaoqi.setOnClickListener(this);

    }


    private void initData() {
        text = beizhu.getText().toString();
        getSprinnerData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.youxiaoqi:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),SByouxiaoqiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("stcode",stcode);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.anquanchukou:
                name.setText("安全出口");

                if (name.getText().equals("安全出口")) {
                    AQ = "2001";
                }
                //2201
                break;
            case R.id.shusanzhishideng:
                name.setText("疏散指示灯");
                if (name.getText().equals("疏散指示灯")) {
                    AQ = "2002";
                }
                //2002
                break;
            case R.id.xiaohuoshuan:
                name.setText("消火栓");
                if (name.getText().equals("消火栓")) {
                    AQ = "2003";
                }

                //2003
                break;
            case R.id.miehuoqi:
                name.setText("灭火器");
                if (name.getText().equals("灭火器")) {
                    AQ = "2004";
                }

                //2004
                break;
            case R.id.juanlianmen:
                name.setText("防火卷帘门");
                if (name.getText().equals("防火卷帘门")) {
                    AQ = "2005";
                }

                //2005
                break;
            case R.id.kongqicaiji:
                name.setText("空气采样器");
                if (name.getText().equals("空气采样器")) {
                    AQ = "2006";
                }
                //2006
                break;
            case R.id.sq_btn_wanhao:
                RxBus.getDefault().post(new rxBean("1"));
                getSeverFromData();

                break;
            case R.id.sq_btn_wenti:
                RxBus.getDefault().post(new rxBean("2"));
                getSeverFromData1();
                break;
            case R.id.paizhao:
                PermissionGen.needPermission(this, 100,
                        new String[]{
                                android.Manifest.permission.CAMERA,
                                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                        });

                break;
            case R.id.chakanphoto:
                Intent intent2 = new Intent();
                intent2.setClass(getApplicationContext(), checkPhotoActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("stcode", stcode);
                intent2.putExtras(bundle2);
                startActivity(intent2);
                break;
            case R.id.sq_btn_duanxin:
                Intent intent1 = new Intent();
                intent1.setClass(getApplicationContext(),DuanXinActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("stcode",stcode);
                intent1.putExtras(bundle1);
                startActivity(intent1);
        }
    }

    /**
     * 动态获取权限
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void requestLocSuccess() {
        //开启相机
        Intent intent1 = new Intent();
        intent1.setClass(getApplicationContext(), WebViewPhotoActivity.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("stcode", stcode);
        intent1.putExtras(bundle1);
        startActivity(intent1);
    }

    @PermissionFail(requestCode = 100)
    public void doFailSomething() {
        Toast.makeText(this, "权限获取失败", Toast.LENGTH_SHORT).show();
    }

    public void getSprinnerData() {
        ArrayAdapter<String> wenti1 = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, wenti);
        wenti1.setDropDownViewResource(R.layout.spinner_dropdown_style);
        sq_spinner.setAdapter(wenti1);
        sq_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position1 = position;
                zhuangzhimingcheng = String.valueOf(position1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void getSeverFromData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        apiService.getANQUAN(userid, roleid, stcode, "", "", "", ZHENGCHANG).enqueue(getCallback());


    }

    public void getSeverFromData1() {
        if (name.getText().equals("")) {
            new AlertDialog.Builder(this).setTitle("错误操作").setMessage("请选择问题设备")
                    .setPositiveButton("确定", null).show();
            return;
        } else if (position1 == 0) {
            new AlertDialog.Builder(this).setTitle("错误操作").setMessage("请选择设备和出错原因")
                    .setPositiveButton("确定", null).show();
            return;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getWENTI(userid, roleid, stcode, AQ, zhuangzhimingcheng, text, CUOWU).enqueue(getCallback());
    }

    @NonNull
    private Callback getCallback() {
        return new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Toast.makeText(getApplicationContext(), "提交成功", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "提交异常", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
