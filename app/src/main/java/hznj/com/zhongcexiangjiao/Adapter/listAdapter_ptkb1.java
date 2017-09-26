package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.ptkbBean;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/6/21 10:52
 */

public class listAdapter_ptkb1 extends BaseAdapter {
    private Context context;
    private List<ptkbBean.ListBean1> list;
    private ViewHolder holder;

    public listAdapter_ptkb1(Context context, List<ptkbBean.ListBean1> list1) {
        this.list=list1;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater minflater = LayoutInflater.from(context);

        if (convertView==null) {
            convertView = minflater.inflate(R.layout.item_peitaikanban, null);
            holder = new ViewHolder();
            holder.ptkb_ny= (TextView) convertView.findViewById(R.id.ptkb_ny);
            holder.ptkb_gg= (TextView) convertView.findViewById(R.id.ptkb_gg);
            holder.ptkb_cxnl= (TextView) convertView.findViewById(R.id.ptkb_cxnl);
            holder.ptkb_rw= (TextView) convertView.findViewById(R.id.ptkb_rw);
            holder.ptkb_cxliang= (TextView) convertView.findViewById(R.id.ptkb_cxliang);
            holder.ptkb_cxlv= (TextView) convertView.findViewById(R.id.ptkb_cxlv);
            holder.ptkb_pz1= (TextView) convertView.findViewById(R.id.ptkb_pz1);
            holder.ptkb_pz2= (TextView) convertView.findViewById(R.id.ptkb_pz2);
            holder.ptkb_pz3= (TextView) convertView.findViewById(R.id.ptkb_pz3);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ptkb_ny.setText(list.get(position).getYYYYMMDD());
        holder.ptkb_gg.setText(list.get(position).getSIZEID());
        holder.ptkb_cxnl.setText(String.valueOf(list.get(position).getBUILDINGCAPACITY()));
        holder.ptkb_rw.setText(String.valueOf(list.get(position).getSCHEDULEORDER()));
        holder.ptkb_cxliang.setText(String.valueOf(list.get(position).getBUILDINGACTUAL()));
        holder.ptkb_cxlv.setText(String.valueOf(list.get(position).getBUILDINGRATIO()));
        holder.ptkb_pz1.setText(String.valueOf(list.get(position).getCM1()));
        holder.ptkb_pz2.setText(String.valueOf(list.get(position).getCM2()));
        holder.ptkb_pz3.setText(String.valueOf(list.get(position).getCM3()));

        return convertView;
    }
     public class ViewHolder{
         TextView ptkb_ny;
         TextView ptkb_gg;
         TextView ptkb_cxnl;
         TextView ptkb_rw;
         TextView ptkb_cxliang;
         TextView ptkb_cxlv;
         TextView ptkb_pz1;
         TextView ptkb_pz2;
         TextView ptkb_pz3;

     }
}
