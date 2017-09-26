package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.VulcanizeActivity;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.vulcanizeBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_vulcanize extends Fragment implements View.OnClickListener {


    private Button btn_vulcanize;
    private String bbarcode;
    private TextView vu_tiaoma;
    private TextView vu_riqi;
    private TextView vu_banci;
    private TextView vu_banzu;
    private TextView vu_jitai;
    private TextView vu_lhyg;
    private TextView vu_sjbz;
    private TextView vu_lhsj;
    private TextView vu_jiaonang;
    private TextView vu_mjbh;
    private TextView vu_mjgg;
    private TextView vu_zt;
    private TextView vu_bzzl;
    private TextView vu_shigong;
    private TextView vu_caiji;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_vulcanize,container,false) ;
        btn_vulcanize = (Button) view.findViewById(R.id.btn_vulcanize);
        vu_tiaoma = (TextView) view.findViewById(R.id.vu_tiaoma);
        vu_riqi = (TextView) view.findViewById(R.id.vu_riqi);
        vu_banci = (TextView) view.findViewById(R.id.vu_banci);
        vu_banzu = (TextView) view.findViewById(R.id.vu_banzu);
        vu_jitai = (TextView) view.findViewById(R.id.vu_jitai);
        vu_lhyg = (TextView) view.findViewById(R.id.vu_lhyg);
        vu_sjbz = (TextView) view.findViewById(R.id.vu_sjbz);
        vu_lhsj = (TextView) view.findViewById(R.id.vu_lhsj);
        vu_jiaonang = (TextView) view.findViewById(R.id.vu_jiaonang);
        vu_mjbh = (TextView) view.findViewById(R.id.vu_mjbh);
        vu_mjgg = (TextView) view.findViewById(R.id.vu_mjgg);
        vu_zt = (TextView) view.findViewById(R.id.vu_zt);
        vu_bzzl = (TextView) view.findViewById(R.id.vu_bzzl);
        vu_shigong = (TextView) view.findViewById(R.id.vu_shigong);
        vu_caiji = (TextView) view.findViewById(R.id.vu_caiji);

        Bundle arguments = getArguments();
        bbarcode= arguments.getString("jiancha");
        initData();
        Log.i("1111",bbarcode);

        return view;
    }

    private void initData() {
        getDataFromServer();
        btn_vulcanize.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
               switch (v.getId()){
                   case R.id.btn_vulcanize:
                       Intent intent = new Intent();
                       intent.setClass(getActivity(), VulcanizeActivity.class);
                       Bundle bundle = new Bundle();
                       bundle.putString("chengxing",bbarcode);
                       intent.putExtras(bundle);
                       startActivity(intent);
               }
    }

    public void getDataFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.OUTER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
       apiService.getVulcanizeBean(bbarcode).enqueue(new Callback<vulcanizeBean>() {
           @Override
           public void onResponse(Call<vulcanizeBean> call, Response<vulcanizeBean> response) {
               vulcanizeBean body = response.body();
               if (body!=null) {
                   List<vulcanizeBean.ListBean> list_vu = body.getList();
                   if (list_vu.size()==0) {
                                  return;
                   } else {
                       vu_tiaoma.setText(list_vu.get(0).getBBARCODE());
                       vu_riqi.setText(list_vu.get(0).getYYYYMMDD());
                       vu_banci.setText(list_vu.get(0).getSHIFT());
                       vu_banzu.setText(list_vu.get(0).getCREW());
                       vu_jitai.setText(list_vu.get(0).getMACHINEID());
                       vu_lhyg.setText(list_vu.get(0).getCUREOPERATOR1());
                       vu_sjbz.setText(list_vu.get(0).getCURECODE());
                       vu_lhsj.setText(String.valueOf(list_vu.get(0).getCURETIME()) );
                       vu_jiaonang.setText(list_vu.get(0).getBLADDERCODE());
                       vu_mjbh.setText(list_vu.get(0).getMOLDNO());
                       vu_mjgg.setText(list_vu.get(0).getPRODUCTNUMBER());
                       vu_zt.setText(String.valueOf(list_vu.get(0).getFLAG()));
                       vu_bzzl.setText(String.valueOf(list_vu.get(0).getWEIGHTSTD()));
                       vu_shigong.setText(list_vu.get(0).getPROCESSNO());
                       vu_caiji.setText(list_vu.get(0).getYYYYMMDD203());
                   }

               }
           }

           @Override
           public void onFailure(Call<vulcanizeBean> call, Throwable t) {

           }
       });
    }
}
