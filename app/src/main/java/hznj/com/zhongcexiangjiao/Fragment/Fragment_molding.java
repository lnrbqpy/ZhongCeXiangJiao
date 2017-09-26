package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.Activity.ContrastActivity;
import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.api.ApiConstants;
import hznj.com.zhongcexiangjiao.api.ApiService;
import hznj.com.zhongcexiangjiao.doman.moldingBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_molding extends Fragment implements View.OnClickListener{


    private Button btn_contrast;
    private String bbarcode;
    private TextView md_riqi;
    private TextView md_banci;
    private TextView md_banzu;
    private TextView md_jitai;
    private TextView md_scsj;
    private TextView md_shigong;
    private TextView md_yz;
    private TextView md_chengxing;
    private TextView md_chengxing2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_molding,container,false) ;
        btn_contrast = (Button) view.findViewById(R.id.btn_contrast);
        Bundle arguments = getArguments();
        bbarcode= arguments.getString("jiancha");
        md_riqi = (TextView) view.findViewById(R.id.md_riqi);
        md_banci = (TextView) view.findViewById(R.id.md_banci);
        md_banzu = (TextView) view.findViewById(R.id.md_banzu);
        md_jitai = (TextView) view.findViewById(R.id.md_jitai);
        md_scsj = (TextView) view.findViewById(R.id.md_scsj);
        md_shigong = (TextView) view.findViewById(R.id.md_shigong);
        md_yz = (TextView) view.findViewById(R.id.md_yz);
        md_chengxing = (TextView) view.findViewById(R.id.md_chengxing);
        md_chengxing2 = (TextView) view.findViewById(R.id.md_chengxing2);

        initData();
        return view;
    }

    private void initData() {

        btn_contrast.setOnClickListener(this);
        getDataFromServer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_contrast:
                Intent intent = new Intent();
                intent.setClass(getActivity(), ContrastActivity.class);
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
        apiService.getMoldingBean(bbarcode).enqueue(new Callback<moldingBean>() {
            @Override
            public void onResponse(Call<moldingBean> call, Response<moldingBean> response) {
                moldingBean body = response.body();
                if (body!=null) {
                    List<moldingBean.ListBean> list = body.getList();
                    if (list.size()==0) {
                        return;
                    }else {
                        md_riqi.setText(list.get(0).getYYYYMMDD());
                        md_banci.setText(list.get(0).getSHIFT());
                        md_banzu.setText(list.get(0).getCREW());
                        md_jitai.setText(list.get(0).getMACHINEID());
                        md_scsj.setText(list.get(0).getDATETIMEPRODUCED());
                        md_shigong.setText(list.get(0).getPROCESSNO());
                        md_yz.setText(list.get(0).getVERIFYRESULT());
                        md_chengxing.setText(list.get(0).getOPERATOR1());
                        md_chengxing2.setText(list.get(0).getPRODUCTNUMBER());
                    }

                }
            }

            @Override
            public void onFailure(Call<moldingBean> call, Throwable t) {

            }
        });
    }
}
