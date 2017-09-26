package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DatePickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.checkShiGongbiaoBean;
import hznj.com.zhongcexiangjiao.doman.qualityUserBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static hznj.com.zhongcexiangjiao.R.id.ar_benbanci;

public class Araft_AxamineActivity extends AppCompatActivity implements View.OnClickListener {

    private Button   ar_chengxingcansu;
    private EditText ar_riqi;
    private Spinner  ar_banci;
    private Spinner  ar_banzu;
    private Spinner  ar_fenchangbanci;
    private Spinner  ar_jitai;
    private String[] ar_BANCI  = new String[]{"", "早班", "中班", "晚班"};
    private String[] ar_BANZU  = new String[]{"", "甲", "乙", "丙", "丁"};
    private String[] ar_JITAI  = new String[]{"", "E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09",
            "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09",
            "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08"};
    private String[] ar_GUIGE  = new String[]{"", "11R24.5", "12.00R20", "12.00R24", "12R22.5", "12R24.5", "13R22.5", "285/75R24.5", "295/80R22.5", "325/95R24"};
    private String[] ar_CENGJI = new String[]{"", "12++PR", "12PR++", "14PR", "164/161B", "16PR", "16PR*", "16PR﹡", "18+PR", "18PR", "20+PR", "20PR", "22PR"};
    private String[] ar_XILIE  = new String[]{"", "EU", "US", "朝系", "出口", "金系", "欧系", "三一中策"};
    private String   DateTime  = "";
    private Spinner  ar_guige;
    private Spinner  ar_cengji;
    private EditText ar_huawen;
    private String   bc;
    private String   bz;
    private String   jt;
    private Spinner  ar_xilie;
    private String   guige;
    private String   cengji;
    private String   xilie;
    private String   riqi;
    private String   huawen;
    private String   personnelcode;
    private String   jieguo3;
    private String   jieguo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_araft_axamine);

        personnelcode = getIntent().getExtras().getString("personnelcode");
        initView();
        initData();


    }


    private void initView() {
        ar_chengxingcansu = (Button) findViewById(R.id.ar_chengxingcansu);
        ar_riqi = (EditText) findViewById(R.id.ar_riqi);
        ar_banci = (Spinner) findViewById(R.id.ar_banci);
        ar_banzu = (Spinner) findViewById(ar_benbanci);
        ar_jitai = (Spinner) findViewById(R.id.ar_jitai);
        ar_guige = (Spinner) findViewById(R.id.ar_guige);
        ar_cengji = (Spinner) findViewById(R.id.ar_cengji);
        ar_huawen = (EditText) findViewById(R.id.ar_huawen);
        ar_xilie = (Spinner) findViewById(R.id.ar_xilie);
        ar_chengxingcansu.setOnClickListener(this);
        ar_riqi.setOnClickListener(this);
    }

    private void initData() {
        ar_riqi.setFocusable(false);
        getSprinnerData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ar_riqi:
                DatePickDialogUtil datePickDialogUtil = new DatePickDialogUtil(Araft_AxamineActivity.this, DateTime);
                datePickDialogUtil.dateTimePicKDialog(ar_riqi);
                break;

            case R.id.ar_chengxingcansu:
                getDataFromServer();

                break;

        }
    }

    public void getSprinnerData() {
        ArrayAdapter<String> ar_banci_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, ar_BANCI);
        ar_banci_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        ar_banci.setAdapter(ar_banci_Adapter);
        ar_banci.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //bc = ar_BANCI[position].toString();
                bc = String.valueOf(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> ar_benbanci_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, ar_BANZU);
        ar_benbanci_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        ar_banzu.setAdapter(ar_benbanci_Adapter);
        ar_banzu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bz = String.valueOf(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> ar_jitai_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, ar_JITAI);
        ar_jitai_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        ar_jitai.setAdapter(ar_jitai_Adapter);
        ar_jitai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jt = ar_JITAI[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> ar_guige_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, ar_GUIGE);
        ar_guige_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        ar_guige.setAdapter(ar_guige_Adapter);
        ar_guige.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                guige = ar_GUIGE[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> ar_cengji_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, ar_CENGJI);
        ar_cengji_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        ar_cengji.setAdapter(ar_cengji_Adapter);
        ar_cengji.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cengji = ar_CENGJI[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> ar_xilie_Adapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.spinner_display_style, R.id.txtvwSpinner, ar_XILIE);
        ar_xilie_Adapter.setDropDownViewResource(R.layout.spinner_dropdown_style);
        ar_xilie.setAdapter(ar_xilie_Adapter);
        ar_xilie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xilie = ar_XILIE[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void getDataFromServer() {
        riqi = ar_riqi.getText().toString();
        huawen = ar_huawen.getText().toString().trim().toUpperCase();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        /*if (huawen !=null) {

           apiService.getQuerenhuawen(huawen).enqueue(new Callback<querenhuawenBean>() {
               @Override
               public void onResponse(Call<querenhuawenBean> call, Response<querenhuawenBean> response) {
                   if (response.body()!=null) {
                       jieguo = response.body().getResult();
                       if (jieguo.equals("2")) {
                           Toast.makeText(getApplicationContext(), "花纹输入错误", Toast.LENGTH_SHORT).show();
                       }
                   }else {
                       Toast.makeText(getApplicationContext(), "花纹输入错误..请检查", Toast.LENGTH_SHORT).show();
                   }
               }

               @Override
               public void onFailure(Call<querenhuawenBean> call, Throwable t) {
                   Toast.makeText(getApplicationContext(), "网络连接错误", Toast.LENGTH_SHORT).show();
               }
           });
        }else {
            Toast.makeText(getApplicationContext(), "请输入花纹", Toast.LENGTH_SHORT).show();
        }*/

        apiService.getQualityUser(riqi, bc, bz, jt, personnelcode).enqueue(new Callback<qualityUserBean>() {
            @Override
            public void onResponse(Call<qualityUserBean> call, Response<qualityUserBean> response) {
                String jieguo2 = response.body().getResult();

            }

            @Override
            public void onFailure(Call<qualityUserBean> call, Throwable t) {

            }
        });
        if (huawen != null) {
            apiService.getCheckShigongbiao(guige, cengji, huawen, xilie).enqueue(new Callback<checkShiGongbiaoBean>() {
                @Override
                public void onResponse(Call<checkShiGongbiaoBean> call, Response<checkShiGongbiaoBean> response) {
                    jieguo3 = response.body().getResult();
                    if (jieguo3.equals("1")) {
                        String processno = response.body().getList().get(0).getPROCESSNO();
                        Intent intent = new Intent();

                        Bundle bundle = new Bundle();
                        bundle.putString("riqi", riqi);
                        bundle.putString("guige", guige);
                        bundle.putString("cengji", cengji);
                        bundle.putString("huawen", huawen);
                        bundle.putString("xilie", xilie);
                        bundle.putString("bc", bc);
                        bundle.putString("bz", bz);
                        bundle.putString("jt", jt);
                        bundle.putString("processno", processno);
                        intent.putExtras(bundle);
                        intent.setClass(getApplicationContext(), BuildingCSActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "请检查规格-层级-花纹-系列是否错误", Toast.LENGTH_SHORT).show();
                       // TastyToast.makeText(getApplicationContext(), "请检查规格-层级-花纹-系列是否错误 !", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                    }
                }

                @Override
                public void onFailure(Call<checkShiGongbiaoBean> call, Throwable t) {
                   Toast.makeText(getApplicationContext(), "----请检查规格-层级-花纹-系列是否错误", Toast.LENGTH_SHORT).show();
                   // TastyToast.makeText(getApplicationContext(), "请检查规格-层级-花纹-系列是否错误 !", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            });
        }


    }
}
