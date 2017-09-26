package hznj.com.zhongcexiangjiao.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import hznj.com.zhongcexiangjiao.Adapter.listAdapter_dj;
import hznj.com.zhongcexiangjiao.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_dj extends Fragment {


    public Fragment_dj() {
        context = getContext();
    }

    private final Context           context;
    private       ListView          lv_dj;
    private       ArrayList<String> dj_list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dj, container, false);
        lv_dj = (ListView) view.findViewById(R.id.lv_dj);


        listAdapter_dj listAdapter_dj = new listAdapter_dj();


        return view;
    }

}
