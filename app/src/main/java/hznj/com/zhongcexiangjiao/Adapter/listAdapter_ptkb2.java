package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.ptkbBean2;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/6/21 10:52
 */

public class listAdapter_ptkb2 extends BaseAdapter {
    private Context                  context;
    private List<ptkbBean2.ListBean> list;

    public listAdapter_ptkb2(Context context, List<ptkbBean2.ListBean> list2) {
        this.list = list2;
        this.context = context;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = minflater.inflate(R.layout.item_peitaikanban2, null);
            holder = new ViewHolder();
            holder.ptkb2_cxjt = (TextView) convertView.findViewById(R.id.ptkb2_cxjt);
            holder.ptkb2_cxgg = (TextView) convertView.findViewById(R.id.ptkb2_cxgg);
            holder.ptkb2_sgb = (TextView) convertView.findViewById(R.id.ptkb2_sgb);
            holder.ptkb2_dbkc = (TextView) convertView.findViewById(R.id.ptkb2_dbkc);
            holder.ptkb2_cxrc = (TextView) convertView.findViewById(R.id.ptkb2_cxrc);
            holder.ptkb2_zgkc = (TextView) convertView.findViewById(R.id.ptkb2_zgkc);
            holder.ptkb2_zdkc = (TextView) convertView.findViewById(R.id.ptkb2_zdkc);
            holder.ptkb2_tcsy = (TextView) convertView.findViewById(R.id.ptkb2_tcsy);
            holder.ptkb2_yjsysj = (TextView) convertView.findViewById(R.id.ptkb2_yjsysj);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.ptkb2_cxjt.setText(list.get(position).getMACHINEID());
        holder.ptkb2_cxgg.setText(list.get(position).getBUILDINGNAME());
        holder.ptkb2_sgb.setText(list.get(position).getPROCESSNO());
        holder.ptkb2_dbkc.setText(String.valueOf(list.get(position).getINVENTORYSHIFT()));
        holder.ptkb2_cxrc.setText(String.valueOf(list.get(position).getBUILDINGACTUAL()));
        holder.ptkb2_zgkc.setText(String.valueOf(list.get(position).getMAXINVENTORY()));
        holder.ptkb2_zdkc.setText(String.valueOf(list.get(position).getMININVENTORY()));
        holder.ptkb2_tcsy.setText(String.valueOf(list.get(position).getESTIMATEDNUM()));
        holder.ptkb2_yjsysj.setText(list.get(position).getESTIMATEDDATE());
     if (list.get(position).getNOWINVSHORTTYPE() .equals( "1")) {
            holder.ptkb2_cxjt.setBackgroundResource(R.color.red);
            holder.ptkb2_cxgg.setBackgroundResource(R.color.red);
            holder.ptkb2_sgb.setBackgroundResource(R.color.red);
            holder.ptkb2_dbkc.setBackgroundResource(R.color.red);
            holder.ptkb2_cxrc.setBackgroundResource(R.color.red);
            holder.ptkb2_zgkc.setBackgroundResource(R.color.red);
            holder.ptkb2_zdkc.setBackgroundResource(R.color.red);
            holder.ptkb2_tcsy.setBackgroundResource(R.color.red);
            holder.ptkb2_yjsysj.setBackgroundResource(R.color.red);
        } else if (list.get(position).getNOWINVSHORTTYPE().equals("2")) {
            holder.ptkb2_cxjt.setBackgroundResource(R.color.yellow);
            holder.ptkb2_cxgg.setBackgroundResource(R.color.yellow);
            holder.ptkb2_sgb.setBackgroundResource(R.color.yellow);
            holder.ptkb2_dbkc.setBackgroundResource(R.color.yellow);
            holder.ptkb2_cxrc.setBackgroundResource(R.color.yellow);
            holder.ptkb2_zgkc.setBackgroundResource(R.color.yellow);
            holder.ptkb2_zdkc.setBackgroundResource(R.color.yellow);
            holder.ptkb2_tcsy.setBackgroundResource(R.color.yellow);
            holder.ptkb2_yjsysj.setBackgroundResource(R.color.yellow);
        } else if (list.get(position).getNOWINVSHORTTYPE().equals("3") ) {
            holder.ptkb2_cxjt.setBackgroundResource(R.color.green);
            holder.ptkb2_cxgg.setBackgroundResource(R.color.green);
            holder.ptkb2_sgb.setBackgroundResource(R.color.green);
            holder.ptkb2_dbkc.setBackgroundResource(R.color.green);
            holder.ptkb2_cxrc.setBackgroundResource(R.color.green);
            holder.ptkb2_zgkc.setBackgroundResource(R.color.green);
            holder.ptkb2_zdkc.setBackgroundResource(R.color.green);
            holder.ptkb2_tcsy.setBackgroundResource(R.color.green);
            holder.ptkb2_yjsysj.setBackgroundResource(R.color.green);

        }
        return convertView;
    }

    public static class ViewHolder {
        TextView ptkb2_cxjt;
        TextView ptkb2_cxgg;
        TextView ptkb2_sgb;
        TextView ptkb2_dbkc;
        TextView ptkb2_cxrc;
        TextView ptkb2_zgkc;
        TextView ptkb2_zdkc;
        TextView ptkb2_tcsy;
        TextView ptkb2_yjsysj;

    }
}
