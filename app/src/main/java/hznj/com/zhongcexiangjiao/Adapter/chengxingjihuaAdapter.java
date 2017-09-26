package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.chengxingjihuaBean;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/7/7 10:29
 */

public class chengxingjihuaAdapter extends BaseAdapter {
    private Context                           context;
    private List<chengxingjihuaBean.ListBean> list;

    public chengxingjihuaAdapter(Context context, List<chengxingjihuaBean.ListBean> list) {
        this.list = list;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_chengxingjihua, null);
            holder = new ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.cxjh_sj);
            holder.banci = (TextView) convertView.findViewById(R.id.cxjh_bc);
            holder.cxj = (TextView) convertView.findViewById(R.id.cxjh_cxj);
            holder.sgb = (TextView) convertView.findViewById(R.id.cxjh_sgb);
            holder.chanpin = (TextView) convertView.findViewById(R.id.cxjh_cp);
            holder.jhsj = (TextView) convertView.findViewById(R.id.cxjh_jhsj);
            holder.pcs = (TextView) convertView.findViewById(R.id.cxjh_pcs);
            holder.gzl = (TextView) convertView.findViewById(R.id.cxjh_gzl);
            holder.jhl = (TextView) convertView.findViewById(R.id.cxjh_jhl);
            holder.wcl = (TextView) convertView.findViewById(R.id.cxjh_wcl);
            holder.zt = (TextView) convertView.findViewById(R.id.cxjh_zt);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.riqi.setText(list.get(position).getYYYYMMDD());
        holder.banci.setText(list.get(position).getSHIFT());
        holder.cxj.setText(list.get(position).getMACHINEID());
        holder.sgb.setText(list.get(position).getGTCODE());
        holder.chanpin.setText(list.get(position).getERPCODE());
        holder.jhsj.setText(list.get(position).getSCHEDULEDATETIME());
        holder.pcs.setText(String.valueOf(list.get(position).getAMOUNTCARTSHIFT()));
        holder.gzl.setText(String.valueOf(list.get(position).getBUILDINGLOT()));
        holder.jhl.setText(String.valueOf(list.get(position).getBUILDINGORDERSHIFT()));
        holder.wcl.setText(String.valueOf(list.get(position).getBUILDINGACTUAL()));
        holder.zt.setText(list.get(position).getSTATUSFLAG());
        return convertView;
    }

    public static class ViewHolder {
        TextView riqi;
        TextView banci;
        TextView cxj;
        TextView sgb;
        TextView chanpin;
        TextView jhsj;
        TextView pcs;
        TextView gzl;
        TextView jhl;
        TextView wcl;
        TextView zt;

    }
}
