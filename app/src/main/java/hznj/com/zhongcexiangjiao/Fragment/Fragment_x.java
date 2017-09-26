package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.InquireActivity;
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_x;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.XguangBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_x extends Fragment {
    private  ListView          lv_x;

    private String kaishi;
    private  String jieshu;
    private  String select;
    public static String X= "X光判断";
    private List<XguangBean.ListBean> list_x;
    private ProgressBar               jiazai;
     private String                   bbarcode ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_x, container, false);
        lv_x = (ListView) view.findViewById(R.id.lv_x);
        jiazai = (ProgressBar) view.findViewById(R.id.pb_x_jiazai);
        initDate();
        return view;
    }

    public void initDate() {
        /***
         * 初始化网络请求
         */
        Bundle arguments = getArguments();
        kaishi = arguments.getString("kaishi");
        jieshu = arguments.getString("jieshu");
        select = arguments.getString("select");

        getDataFromServer();





    }

    /**
     * 网络请求
     */
    private void getDataFromServer() {
        jiazai.setVisibility(ViewPager.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getXguangBean(kaishi,jieshu,X,select).enqueue(new Callback<XguangBean>() {
            @Override
            public void onResponse(Call<XguangBean> call, Response<XguangBean> response) {
                XguangBean body = response.body();
                if (body!=null) {
                    list_x = body.getList();
                        listAdapter_x listAdapter= new listAdapter_x(list_x, getActivity());
                        lv_x.setAdapter(listAdapter);
                        jiazai.setVisibility(ViewPager.GONE);
                        lv_x.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                bbarcode = list_x.get(position).getBBARCODE();
                                //      Toast.makeText(getActivity(),bbarcode,Toast.LENGTH_LONG).show();

                                Intent intent = new Intent();
                                intent.setClass(getActivity(), InquireActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putString("chengxing",bbarcode);
                                intent.putExtras(bundle);
                                startActivity(intent);

                            }
                        });


                }else {
                    jiazai.setVisibility(ViewPager.GONE);
                }
            }

            @Override
            public void onFailure(Call<XguangBean> call, Throwable t) {
                jiazai.setVisibility(ViewPager.GONE);
            }
        });





    }


}

