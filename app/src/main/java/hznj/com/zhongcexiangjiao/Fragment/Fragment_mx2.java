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
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.Inquire2Activity;
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_cx;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.chengxingBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_mx2 extends Fragment {


    private ListView lv_cx;


    public  String CX = "成型机台";
    public String kaishi;
    public String jieshu;
    public String select;

    private ProgressBar                  jiazai;
    private List<chengxingBean.ListBean> results;
    public  String                       bbarcode;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mx, container, false);
        lv_cx = (ListView) view.findViewById(R.id.lv_cx);
        jiazai = (ProgressBar) view.findViewById(R.id.pb_jiazai);
        ShowProgressBar();

        CloseProgressBar();
        initData();
        /**
         * 判断是否要隐藏圈圈
         */

        return view;
    }

    private void CloseProgressBar() {
        jiazai.setVisibility(ViewPager.GONE);
    }

    private void ShowProgressBar() {
        jiazai.setVisibility(ViewPager.VISIBLE);
    }

    private void initData() {
        Bundle arguments = getArguments();
        kaishi = arguments.getString("kaishi");
        jieshu = arguments.getString("jieshu");
        select = arguments.getString("select");

        getDataFromServer();

    }

    public void getDataFromServer() {
        ShowProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getChengxingBean(kaishi, jieshu, CX, select).enqueue(new Callback<chengxingBean>() {
            @Override
            public void onResponse(Call<chengxingBean> call, Response<chengxingBean> response) {
                chengxingBean body = response.body();
                if (body != null) {
                    results = body.getList();
                    listAdapter_cx listAdapter = new listAdapter_cx(results, getActivity());
                    lv_cx.setAdapter(listAdapter);
                    CloseProgressBar();
                    /**
                     * 跳转详情搜索结果页
                     * */
                    lv_cx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            bbarcode = results.get(position).getBBARCODE();
                            //      Toast.makeText(getActivity(),bbarcode,Toast.LENGTH_LONG).show();

                            Intent intent = new Intent();
                            intent.setClass(getActivity(), Inquire2Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("chengxing",bbarcode);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }

                    });
                }
            }

            @Override
            public void onFailure(Call<chengxingBean> call, Throwable t) {
                CloseProgressBar();
                Toast toast = Toast.makeText(getActivity(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
            }
        });


    }



}


