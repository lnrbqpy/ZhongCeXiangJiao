package hznj.com.zhongcexiangjiao.Activity;

import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

import hznj.com.zhongcexiangjiao.Adapter.checkPhotoAdapter;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.DatePickDialogUtil;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.checkphotoBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class checkPhotoActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ck_riqi;
    private EditText ck_riqi2;
    private Button   ck_chaxun;
    private GridView ck_gv;
    private String   DateTime;
    private String   riqi;
    private String   riqi2;
    private String   stcode;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private TextView weizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_photo);
        stcode = getIntent().getExtras().getString("stcode");
        initView();
        intiDate();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void intiDate() {

    }

    private void initView() {
        ck_riqi = (EditText) findViewById(R.id.ck_riqi);
        ck_riqi2 = (EditText) findViewById(R.id.ck_riqi2);
        ck_chaxun = (Button) findViewById(R.id.ck_chaxun);
        weizhi = (TextView) findViewById(R.id.ck_weizhi);
        ck_gv = (GridView) findViewById(R.id.ck_gv);
        ck_riqi.setFocusable(false);
        ck_riqi2.setFocusable(false);
        ck_riqi.setOnClickListener(this);
        ck_riqi2.setOnClickListener(this);
        ck_chaxun.setOnClickListener(this);
        weizhi.setText(stcode);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ck_riqi:
                DatePickDialogUtil datePickDialogUtil = new DatePickDialogUtil(checkPhotoActivity.this, DateTime);
                datePickDialogUtil.dateTimePicKDialog(ck_riqi);

                break;
            case R.id.ck_riqi2:
                DatePickDialogUtil datePickDialogUtil2 = new DatePickDialogUtil(checkPhotoActivity.this, DateTime);
                datePickDialogUtil2.dateTimePicKDialog(ck_riqi2);

                break;
            case R.id.ck_chaxun:
                riqi = ck_riqi.getText().toString();
                riqi2 = ck_riqi2.getText().toString();
                getSeverDate();
                break;
        }
    }

    public void getSeverDate() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.CheckPhoto(riqi, riqi2, stcode).enqueue(new Callback<checkphotoBean>() {
            @Override
            public void onResponse(Call<checkphotoBean> call, Response<checkphotoBean> response) {
                if (response.body() != null) {
                    List<checkphotoBean.ListBean> list = response.body().getList();
                    checkPhotoAdapter PhotoAdapter = new checkPhotoAdapter(getApplicationContext(), list);
                    ck_gv.setAdapter(PhotoAdapter);

                } else {
                    new AlertDialog.Builder(getApplicationContext()).setTitle("加载异常").setMessage("当前时间段没有问题图片")
                            .setPositiveButton("确定", null).show();
                }
            }

            @Override
            public void onFailure(Call<checkphotoBean> call, Throwable t) {

            }


        });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("checkPhoto Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
