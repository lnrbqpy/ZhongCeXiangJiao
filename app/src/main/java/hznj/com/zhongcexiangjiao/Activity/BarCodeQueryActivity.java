package hznj.com.zhongcexiangjiao.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import hznj.com.zhongcexiangjiao.Fragment.Fragment_dj;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_lh;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_mx2;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_qp;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_wg;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_x;
import hznj.com.zhongcexiangjiao.Fragment.Fragment_zl;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DateTimePickDialogUtil;


/**
 * 条码查询界面
 */
public class BarCodeQueryActivity extends FragmentActivity implements View.OnClickListener {
    private Context context;
    private String[] X  = new String[]{"A级", "B级", "C级", "D级", "定位胎", "轻返", "重返", "废品"};
    private String[] ZL = new String[]{"正品", "非正品"};
    private String[] CX = new String[]{"E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09",
            "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09",
            "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08"};
    private String[] LH = new String[]{
            "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09", "F10",
            "F11", "F12", "F13", "F14", "F15", "F16", "F17", "F18", "F19", "F20",
            "F21", "F22", "F23", "F24", "F25", "F26",
            "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08", "G09", "G10",
            "G11", "G12", "G13", "G14", "G15", "G16", "G17", "G18", "G19", "G20",
            "G21", "G22", "G23", "G24", "G25", "G26",
            "H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10",
            "H11", "H12", "H13", "H14", "H15", "H16", "H17", "H18", "H19", "H20",
            "H21", "H22", "H23", "H24", "H25", "H26",
            "I01", "I02", "I03", "I04", "I05", "I06", "I07", "I08", "I09",
            "I11", "I12", "I13", "I14", "I15", "I16", "I17", "I18", "I19",
            "I21", "I22", "I23", "I24", "I25", "I26",
            "J01", "J02", "J03", "J04", "J05", "J06", "J07", "J08", "J09",
            "J11", "J12", "J13", "J14", "J15", "J16", "J17", "J18", "J19",
            "J21", "J22", "J23", "J24", "J25", "J26",
            "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09",
            "D11", "D12", "D13", "D14", "D15", "D16", "D17", "D18", "D19",
            "D21", "D22", "D23", "D24", "D25", "D26",
            "E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09",
            "E11", "E12", "E13", "E14", "E15", "E16", "E17", "E18", "E19",
            "E21", "E22", "E23", "E24", "E25", "E26",
    };
    private String[] WG = new String[]{"C级品", "D级品", "废品", "待检品", "整理", "正品"};
    private EditText startDateTime;
    private EditText endDateTime;

    private String      initStartDateTime; //="2017-3-3 14:44"; // 初始化开始时间
    private String      initEndDateTime;//="2017-3-23 17:44"; // 初始化结束时间
    private RadioButton cx, lh, zl, x, wg, dj, qp;
    private Button          search_or;
    public  String          select;
    private Fragment_mx2    chengxing;
    private Fragment_lh     liuhua;
    private Fragment_zl     zhongliang;
    private Fragment_x      xguang;
    private Fragment_wg     waiguan;
    private Fragment_dj     dongjun;
    private Fragment_qp     qipao;
    private FragmentManager fm;
    private RadioGroup      radioGroup;
    private Spinner         spinner;
    private FragmentManager manager;
    private Fragment        fragment;

    private String kaishi;

    private String   jieshu;
    private String   sp_cx;
    private String   sp_lh;
    private String   sp_zl;
    private String   sp_x;
    private String   sp_wg;
    private String   s;
    private String   s1;
    private EditText et_zhiding;
    private Button   btn_zhiding;
    private Bundle   bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_code_query2);
        context = this;

        initView();

        initData();

    }

    private void initView() {
        startDateTime = (EditText) findViewById(R.id.StartTime);
        endDateTime = (EditText) findViewById(R.id.EndTime);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cx = (RadioButton) findViewById(R.id.cx);
        lh = (RadioButton) findViewById(R.id.lh);
        zl = (RadioButton) findViewById(R.id.zl);
        x = (RadioButton) findViewById(R.id.x);
        wg = (RadioButton) findViewById(R.id.wg);
        dj = (RadioButton) findViewById(R.id.dj);
        qp = (RadioButton) findViewById(R.id.qp);
        et_zhiding = (EditText) findViewById(R.id.et_zhiding);
        btn_zhiding = (Button) findViewById(R.id.search_zhiding);
        cx.setOnClickListener(this);
        lh.setOnClickListener(this);
        zl.setOnClickListener(this);
        x.setOnClickListener(this);
        wg.setOnClickListener(this);
        qp.setOnClickListener(this);
        btn_zhiding.setOnClickListener(this);

        search_or = (Button) findViewById(R.id.search_or);
        search_or.setOnClickListener(this);
        spinner = (Spinner) findViewById(R.id.bq_spinner);
        //动态加载Fragment
        manager = getSupportFragmentManager();

        bundle = new Bundle();

    }

    private void initData() {
        startDateTime.setFocusable(false);
        endDateTime.setFocusable(false);

        startDateTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        BarCodeQueryActivity.this, initStartDateTime);
                dateTimePicKDialog.dateTimePicKDialog(startDateTime);
                // s = startDateTime.getText().toString().replaceAll("-", "").replaceAll(" ","").replaceAll(":","");
            }

        });


        endDateTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                DateTimePickDialogUtil dateTimePicKDialog = new DateTimePickDialogUtil(
                        BarCodeQueryActivity.this, initEndDateTime);
                dateTimePicKDialog.dateTimePicKDialog(endDateTime);
                //    s1 = endDateTime.getText().toString().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
            }
        });


        //判断选中的状态给spinner设置不同数据
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.cx:

                        ArrayAdapter<String> CX_Adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, CX);
                        CX_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(CX_Adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                sp_cx = CX[position].toString();


                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        break;
                    case R.id.lh:

                        ArrayAdapter<String> LH_Adapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, LH);
                        LH_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(LH_Adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                sp_lh = LH[position].toString();

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                    case R.id.zl:

                        ArrayAdapter<String> ZL_Adapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, ZL);
                        ZL_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(ZL_Adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                sp_zl = ZL[position].toString();
                                Log.i("zl", sp_zl);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                    case R.id.x:
                        ArrayAdapter<String> X_Adapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, X);
                        X_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(X_Adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                sp_x = X[position];
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                    case R.id.wg:
                        ArrayAdapter<String> WG_Adapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, WG);
                        WG_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(WG_Adapter);
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                sp_wg = WG[position].toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                    case R.id.dj:
                        ArrayAdapter<Object> DJ_Adapter = new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item);
                        DJ_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(DJ_Adapter);
                        break;
                    case R.id.qp:
                        ArrayAdapter<Object> QP_Adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item);
                        QP_Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(QP_Adapter);
                        break;

                }

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.search_or:


                checkBoxStatus();


                break;

            case R.id.search_zhiding:
                String trim = et_zhiding.getText().toString().trim().toUpperCase();
                if (!TextUtils.isEmpty(trim) && trim.length() > 5) {
                    Log.i("zifuchuan", trim);
                    Intent intent1 = new Intent();
                    intent1.setClass(this, Inquire2Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("chengxing", trim);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
                } else {
                    new AlertDialog.Builder(context).setTitle("数据错误").setMessage("输入的成型编号无法识别")
                            .setPositiveButton("确定", null).show();
                }

                break;
        }


    }


    /**
     * 判断选中那个button
     */
    public void checkBoxStatus() {
        kaishi = startDateTime.getText().toString().replaceAll("-", "").replaceAll(" ", "");
        jieshu = endDateTime.getText().toString().replaceAll("-", "").replaceAll(" ", "");
        FragmentTransaction transaction = manager.beginTransaction();
        Log.i("shijian1", kaishi + jieshu);

     /*   kaishi = startDateTime.getText().toString().trim();
        jieshu = endDateTime.getText().toString().trim();*/

        bundle.putString("kaishi", kaishi);
        bundle.putString("jieshu", jieshu);

        if (cx.isChecked()) {

            if (chengxing == null) {
                Fragment_mx2 fragment_mx = new Fragment_mx2();
                bundle.putString("select", sp_cx);

                fragment_mx.setArguments(bundle);
                transaction.replace(R.id.fl_layout, fragment_mx);
                transaction.commit();

            }
        } else if (lh.isChecked()) {
            if (liuhua == null) {
                Fragment_lh fragment_lh = new Fragment_lh();
                bundle.putString("select", sp_lh);
                fragment_lh.setArguments(bundle);
                transaction.replace(R.id.fl_layout, fragment_lh);
                transaction.commit();
            }
        } else if (zl.isChecked()) {
            if (zhongliang == null) {
                Fragment_zl fragment_zl = new Fragment_zl();
                bundle.putString("select", sp_zl);
                fragment_zl.setArguments(bundle);
                transaction.replace(R.id.fl_layout, fragment_zl);
                transaction.commit();
            }

        } else if (x.isChecked()) {
            if (xguang == null) {
                Fragment_x fragment_x = new Fragment_x();
                bundle.putString("select", sp_x);
                fragment_x.setArguments(bundle);
                transaction.replace(R.id.fl_layout, fragment_x);
                transaction.commit();
            }

        } else if (wg.isChecked()) {
            if (waiguan == null) {
                Fragment_wg fragment_wg = new Fragment_wg();
                bundle.putString("select", sp_wg);
                fragment_wg.setArguments(bundle);
                transaction.replace(R.id.fl_layout, fragment_wg);
                transaction.commit();
            }

        } else if (dj.isChecked()) {
            if (dongjun == null) {

                transaction.replace(R.id.fl_layout, new Fragment_dj());
                transaction.commit();
            }

        } else if (qp.isChecked()) {
            if (qipao == null) {
                transaction.replace(R.id.fl_layout, new Fragment_qp());
                transaction.commit();
            }

        }


    }


}

