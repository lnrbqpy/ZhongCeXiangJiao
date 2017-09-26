package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.XLightActivity;
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_jiancha;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.jianchaBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_examine extends Fragment implements View.OnClickListener {


    private EditText et_edit;
    private Button btn_x;
    private ListView lv_jiancha;

    private String                     bbarcode;
    private List<jianchaBean.ListBean> list_jc;
    private Button                     zhuangtai;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
             View view =  inflater.inflate(R.layout.fragment_examine,container,false) ;
        btn_x = (Button) view.findViewById(R.id.btn_X);
        lv_jiancha = (ListView) view.findViewById(R.id.lv_jiancha);
       Bundle arguments = getArguments();
        bbarcode= arguments.getString("jiancha");

        initData();

        return view;
    }



    private void initData() {

        getDataFromServer();
        btn_x.setOnClickListener(this);


        }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_X:
                    if (list_jc.get(0).getBLPNAME()==null) {
                        Toast.makeText(getContext(),"正常产品无X光照片",Toast.LENGTH_SHORT).show();
                                        return;
                    }
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), XLightActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("chengxing",bbarcode);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                /*case R.id.btn_zhuangtai:
                    startActivity(new Intent(getActivity(), ZTActivity.class));*/

            }
    }

    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getJianchaBean(bbarcode).enqueue(new Callback<jianchaBean>() {

            @Override
            public void onResponse(Call<jianchaBean> call, Response<jianchaBean> response) {
                jianchaBean body = response.body();
                if (body!=null) {
                    list_jc = body.getList();
                    listAdapter_jiancha listAdapter = new listAdapter_jiancha(list_jc,getActivity());
                    lv_jiancha.setAdapter(listAdapter);
                }
            }

            @Override
            public void onFailure(Call<jianchaBean> call, Throwable t) {

            }
        });
    }

}