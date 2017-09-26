package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.Safet_inspect_Activity;
import hznj.com.zhongcexiangjiao.Adapter.ListAdapter_sq_jc;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.RxBus;
import hznj.com.zhongcexiangjiao.Uilts.rxBean;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.sqjcBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sq_jc_Fragment extends Fragment {
    private String sq_jc = "40";
    private GridView gridView;
    private String   roleid;
    private String   userid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sq_jc, container, false);
        gridView = (GridView) view.findViewById(R.id.gv_safet_jc);
        Bundle arguments = getArguments();
        roleid = arguments.getString("roleid");
        userid = arguments.getString("userid");

        initData();
        return view;
    }

    private void initData() {
        RxBus.getDefault().toObservable(rxBean.class)
                //在io线程进行订阅，可以执行一些耗时操作
                .subscribeOn(Schedulers.io())
                //在主线程进行观察，可做UI更新操作
                .observeOn(AndroidSchedulers.mainThread())
                //观察的对象
                .subscribe(new Action1<rxBean>() {
                    @Override
                    public void call(rxBean user) {
                        getDataFromServer();
                        Log.i("test", user.getUsername() + "!");
                    }
                });
        getDataFromServer();

    }


    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getSqJcBean(roleid, sq_jc).enqueue(new Callback<sqjcBean>() {

            private List<sqjcBean.ListBean> list;

            @Override
            public void onResponse(Call<sqjcBean> call, Response<sqjcBean> response) {
                if (response.body() != null) {
                    list = response.body().getList();
                    ListAdapter_sq_jc listAdapter_sq_jc = new ListAdapter_sq_jc(getContext(), list);
                    gridView.setAdapter(listAdapter_sq_jc);
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            String stcode = list.get(i).getSTCODE();
                            String typeid = list.get(i).getTYPEID();
                            Intent intent = new Intent();
                            intent.setClass(getActivity(), Safet_inspect_Activity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("stcode", stcode);
                            bundle.putString("roleid", roleid);
                            bundle.putString("typeid", typeid);
                            bundle.putString("userid",userid);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<sqjcBean> call, Throwable t) {

            }
        });

    }
}
