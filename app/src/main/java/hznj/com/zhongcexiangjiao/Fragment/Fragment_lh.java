package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.Inquire2Activity;
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_lh;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.liuhuaBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_lh extends Fragment {
    private ListView          lv_lh;
    private String            kaishi;
    private String            jieshu;
    private String            select;
    public  String                       bbarcode;
    public static String LH = "硫化机台";
    private ProgressBar                  jiazai;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lh, container, false);
        lv_lh = (ListView) view.findViewById(R.id.lv_lh);
        jiazai = (ProgressBar) view.findViewById(R.id.pb_jiazai);
        ShowProgressBar();

        CloseProgressBar();
        initData();
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
        Log.i("222",kaishi+jieshu+select);
    }

    public void getDataFromServer() {
        ShowProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getLiuhuaBean(kaishi, jieshu, LH, select).enqueue(new Callback<liuhuaBean>() {

            private List<liuhuaBean.ListBean> list;

            @Override
            public void onResponse(Call<liuhuaBean> call, Response<liuhuaBean> response) {
                liuhuaBean body = response.body();
                if (body != null) {
                    list = body.getList();
                    listAdapter_lh listAdapter = new listAdapter_lh(list, getActivity());
                    lv_lh.setAdapter(listAdapter);
                    CloseProgressBar();

                    /**
                     * 跳转详情搜索结果页
                     * */
                    lv_lh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            bbarcode = list.get(position).getBBARCODE();
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
            public void onFailure(Call<liuhuaBean> call, Throwable t) {
                CloseProgressBar();
                Toast toast = Toast.makeText(getActivity(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
            }
        });


    }
}
