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
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_zl;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.zhongliangBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_zl extends Fragment {
    private ListView lv_zl;
    private String   kaishi;
    private String   jieshu;
    private String   select;
    public  String ZL = "重量结果";
    public String ZL_jt = "非正品";

    private ProgressBar                   jiazai3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zl, container, false);
        lv_zl = (ListView) view.findViewById(R.id.lv_zl);
        jiazai3 = (ProgressBar) view.findViewById(R.id.pb_jiazai);
       // ShowProgressBar();

       // CloseProgressBar();
        initData();

        return view;
    }

    private void CloseProgressBar() {
        jiazai3.setVisibility(ViewPager.GONE);
    }

    private void ShowProgressBar() {
        jiazai3.setVisibility(ViewPager.VISIBLE);
    }

    private  void initData() {
        Bundle arguments = getArguments();
        kaishi = arguments.getString("kaishi");
        jieshu = arguments.getString("jieshu");
        select = arguments.getString("select");
        Log.i("4444", kaishi+jieshu+select+ZL);
        getDataFromServer();

    }

    public void getDataFromServer() {
              ShowProgressBar();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getZhongliangBean(kaishi,jieshu,ZL,select).enqueue(new Callback<zhongliangBean>() {

            private List<zhongliangBean.ListBean> list;

            @Override
            public void onResponse(Call<zhongliangBean> call, Response<zhongliangBean> response) {
                zhongliangBean body = response.body();
                if (body!=null) {
                    list = body.getList();
                    listAdapter_zl zl_adapter = new listAdapter_zl(list,getActivity());
                    lv_zl.setAdapter(zl_adapter);
                    CloseProgressBar();

                    lv_zl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String bbarcode = list.get(position).getBBARCODE();
                            Intent intent = new Intent();
                            intent.setClass(getActivity(), Inquire2Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("chengxing",bbarcode);
                            intent.putExtras(bundle);
                            startActivity(intent);

                        }
                    });

                } else {
                    Toast.makeText(getActivity(),"数据为空",Toast.LENGTH_SHORT).show();
                    CloseProgressBar();
                }

            }

            @Override
            public void onFailure(Call<zhongliangBean> call, Throwable t) {
                CloseProgressBar();
                Toast.makeText(getActivity(),"数据加载失败",Toast.LENGTH_SHORT).show();
            }
        });
    }
}