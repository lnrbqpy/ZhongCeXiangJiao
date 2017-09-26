package hznj.com.zhongcexiangjiao.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_qp;
import hznj.com.zhongcexiangjiao.R;


/**
 * 气泡数据页面.
 */
public class Fragment_qp extends Fragment {
    private    ListView          lv_qp;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_qp, container, false);
        lv_qp = (ListView) view.findViewById(R.id.lv_qp);

        initView();
        initData();

        listAdapter_qp listAdapter_qp1 = new listAdapter_qp();

        lv_qp.setAdapter(listAdapter_qp1);



        return view;
    }

    private void initView() {

    }

    private void initData() {


    }

}
