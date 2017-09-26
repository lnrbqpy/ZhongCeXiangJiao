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
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_wg;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.waiguanBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_wg extends Fragment {
    private ListView lv_wg;
    private String   kaishi;
    private String   jieshu;
    private String   select;
    public static String WG = "外观机台";
    private ProgressBar jiazai;

    private List<waiguanBean.ListBean> list_wg1;
    private String                     bbarcode;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wg, container, false);
        lv_wg = (ListView) view.findViewById(R.id.lv_wg);
        jiazai = (ProgressBar) view.findViewById(R.id.pb_wg_jiazai);

        inidData();

        return view;
    }

    private void inidData() {
        Bundle arguments = getArguments();
        kaishi = arguments.getString("kaishi");
        jieshu = arguments.getString("jieshu");
        select = arguments.getString("select");
        getDataFromServer();
    }

    public void getDataFromServer() {
        jiazai.setVisibility(ViewPager.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getWaiguanBean(kaishi, jieshu, WG, select).enqueue(new Callback<waiguanBean>() {
            @Override
            public void onResponse(Call<waiguanBean> call, Response<waiguanBean> response) {
                waiguanBean body = response.body();
                if (body != null) {
                    list_wg1 = body.getList();
                    listAdapter_wg listAdapter_wg1 = new listAdapter_wg(list_wg1, getActivity());
                    lv_wg.setAdapter(listAdapter_wg1);
                    jiazai.setVisibility(ViewPager.GONE);

                    lv_wg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            bbarcode = list_wg1.get(position).getBBARCODE();
                            //      Toast.makeText(getActivity(),bbarcode,Toast.LENGTH_LONG).show();

                            Intent intent = new Intent();
                            intent.setClass(getActivity(), Inquire2Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("chengxing", bbarcode);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
                } else {
                    jiazai.setVisibility(ViewPager.GONE);

                }

            }

            @Override
            public void onFailure(Call<waiguanBean> call, Throwable t) {
                jiazai.setVisibility(ViewPager.GONE);
                Toast toast = Toast.makeText(getActivity(), "服务器暂无信息，请手动查询", Toast.LENGTH_SHORT);
            }
        });

    }
}
