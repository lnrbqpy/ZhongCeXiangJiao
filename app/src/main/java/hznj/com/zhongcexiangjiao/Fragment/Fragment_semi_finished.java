package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.jiaoliaoActivity;
import hznj.com.zhongcexiangjiao.Adapter.listAdapter_semiFinished;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.semiFinishedBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_semi_finished extends Fragment {

    private ListView                        list_bzp;
    private String                          bbarcode;
    private List<semiFinishedBean.ListBean> list;
    private ApiService                      apiService;
    private String                          s;
    private ProgressBar                     jiazai;




    //  public  static String zz= "D7E1B50642";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_semi_finished,container,false) ;
         //horizontalListView = (ListView) view.findViewById(R.id.list_bzp);
        list_bzp = (ListView) view.findViewById(R.id.list_bzp);
        jiazai = (ProgressBar) view.findViewById(R.id.bzp_shuju);
        Bundle arguments = getArguments();
        bbarcode= arguments.getString("jiancha");
        initData();
        Log.i("11111",bbarcode) ;
        return view;

    }

    private void initData() {
        getDataFromServer();
    }

    public void getDataFromServer() {
           jiazai.setVisibility(ViewPager.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

        apiService.getSemiFinishedBean(bbarcode).enqueue(new Callback<semiFinishedBean>() {
            @Override
            public void onResponse(Call<semiFinishedBean> call, Response<semiFinishedBean> response) {
                semiFinishedBean body = response.body();
                if (body!=null) {
                    list = body.getList();
                    if (list.size()==0) {
                        jiazai.setVisibility(ViewPager.GONE);
                        Toast toast = Toast.makeText(getActivity(), "服务器暂无信息", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                    listAdapter_semiFinished listAdapter_sm = new listAdapter_semiFinished(list,getActivity());
                    list_bzp.setAdapter(listAdapter_sm);
                    jiazai.setVisibility(ViewPager.GONE);
                       list_bzp.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                           @Override
                           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                               s = list.get(i).getBARCODE();
                               Intent intent = new Intent();
                               intent.setClass(getActivity(), jiaoliaoActivity.class);
                               Bundle bundle = new Bundle();
                               bundle.putString("jiaoliao",s);
                               intent.putExtras(bundle);
                               startActivity(intent);
                           }
                       });
                }
            }

            @Override
            public void onFailure(Call<semiFinishedBean> call, Throwable t) {

            }
        });
    }


}
