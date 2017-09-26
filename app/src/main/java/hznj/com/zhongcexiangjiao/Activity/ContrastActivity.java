package hznj.com.zhongcexiangjiao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_bzp;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.banzhipinBean1;
import hznj.com.zhongcexiangjiao.doman.banzhipinBean2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ContrastActivity extends AppCompatActivity {
    private String          bbarcode;
    private TextView        ct_tiaoma;
    private TextView        ct_riqi;
    private TextView        ct_banci;
    private TextView        ct_banzu;
    private TextView        ct_jitai;
    private TextView        ct_scsj;
    private TextView        ct_shigong;
    private TextView        ct_yanzheng;
    private TextView        ct_cx1;
    private TextView        ct_cx2;
    private TextView        ct_guige;
    private ListView        ct_lv;
    //  private static String zzt = "D7E9B50217";
    private listAdapter_bzp banzhipin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrast);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        bbarcode = bundle.getString("chengxing");
        initData();
    }

    private void initData() {
        ct_tiaoma = (TextView) findViewById(R.id.ct_tiaoma);
        ct_riqi = (TextView) findViewById(R.id.ct_riqi);
        ct_banci = (TextView) findViewById(R.id.ct_banci);
        ct_banzu = (TextView) findViewById(R.id.ct_banzu);
        ct_jitai = (TextView) findViewById(R.id.ct_jitai);
        ct_scsj = (TextView) findViewById(R.id.ct_scsj);
        ct_shigong = (TextView) findViewById(R.id.ct_shigong);
        ct_yanzheng = (TextView) findViewById(R.id.ct_yanzheng);
        ct_cx1 = (TextView) findViewById(R.id.ct_cx1);
        ct_cx2 = (TextView) findViewById(R.id.ct_cx2);
        ct_guige = (TextView) findViewById(R.id.ct_guige);
        ct_lv = (ListView) findViewById(R.id.ct_lv);

        getDataFromServer();

    }

    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getBanzhipinBean1(bbarcode).enqueue(new Callback<banzhipinBean1>() {
            @Override
            public void onResponse(Call<banzhipinBean1> call, Response<banzhipinBean1> response) {
                banzhipinBean1 body = response.body();
                if (body != null) {
                    List<banzhipinBean1.ListBean> list1 = body.getList();
                    if (list1.size() == 0) {
                        return;
                    } else {
                        ct_tiaoma.setText(list1.get(0).getBARCODE());
                        ct_riqi.setText(list1.get(0).getYYYYMMDD());
                        ct_banci.setText(list1.get(0).getSHIFT());
                        ct_banzu.setText(list1.get(0).getCREW());
                        ct_jitai.setText(list1.get(0).getMACHINEID());
                        ct_scsj.setText(list1.get(0).getDATETIMEPRODUCED());
                        ct_shigong.setText(list1.get(0).getPROCESSNO());
                        ct_yanzheng.setText(list1.get(0).getVERIFYRESULT());
                        ct_cx1.setText(list1.get(0).getOPERATOR1());
                        ct_cx2.setText(list1.get(0).getOPERATOR2());
                        ct_guige.setText(list1.get(0).getPRODUCTIONCODE());
                    }


                }
            }

            @Override
            public void onFailure(Call<banzhipinBean1> call, Throwable t) {

            }
        });
        apiService.getBanzhipinBean2(bbarcode).enqueue(new Callback<banzhipinBean2>() {
            @Override
            public void onResponse(Call<banzhipinBean2> call, Response<banzhipinBean2> response) {
                banzhipinBean2 body2 = response.body();
                if (body2 != null) {
                    List<banzhipinBean2.ListBean> list2 = body2.getList();
                    banzhipin = new listAdapter_bzp(list2, getApplicationContext());
                    ct_lv.setAdapter(banzhipin);
                    banzhipin.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<banzhipinBean2> call, Throwable t) {

            }
        });

    }


}
