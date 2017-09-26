package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.chengxingpeizhiBean;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/7/13 9:31
 */

public class chengxingpeizhiAdapter extends BaseAdapter {
    private Context                            context;
    private List<chengxingpeizhiBean.ListBean> list;


    public chengxingpeizhiAdapter(Context context, List<chengxingpeizhiBean.ListBean> list) {
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
        LayoutInflater minflater = LayoutInflater.from(context);
        ViewHolder holder;
        if (convertView==null) {
            convertView = minflater.inflate(R.layout.list_item_chengxingpeizhi, null);
            holder = new ViewHolder();
            holder.cp= (TextView) convertView.findViewById(R.id.cxpz_cp);
            holder.sgb= (TextView) convertView.findViewById(R.id.cxpz_sgb);
            holder.lhj= (TextView) convertView.findViewById(R.id.cxpz_lhj);
            holder.lhjs= (TextView) convertView.findViewById(R.id.cxpz_lhjs);
            holder.lhsj= (TextView) convertView.findViewById(R.id.cxpz_lhsj);
            holder.djrc= (TextView) convertView.findViewById(R.id.cxpz_djrc);
            holder.rzb= (TextView) convertView.findViewById(R.id.cxpz_rzb);
            holder.ptbxq= (TextView) convertView.findViewById(R.id.cxpz_ptbxq);
            holder.stkc= (TextView) convertView.findViewById(R.id.cxpz_stkc);
            holder.cxjs= (TextView) convertView.findViewById(R.id.cxpz_cxjs);
            holder.cxj= (TextView) convertView.findViewById(R.id.cxpz_cxj);
            holder.cxsj= (TextView) convertView.findViewById(R.id.cxpz_cxsj);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.cp.setText(list.get(position).getBUILDINGNAME());
        holder.sgb.setText(list.get(position).getPROCESSNO());
        holder.lhj.setText(String.valueOf(list.get(position).getCMACHINEALL()));
        holder.lhjs.setText(String.valueOf(list.get(position).getCMACHINENUM()));
        holder.lhsj.setText(String.valueOf(list.get(position).getCURETIME()));
        holder.djrc.setText(String.valueOf(list.get(position).getCURECAPACITY()));
        holder.rzb.setText(String.valueOf(list.get(position).getSCHEDULEORDER()));
        holder.ptbxq.setText(String.valueOf(list.get(position).getREQUIREMENT()));
        holder.stkc.setText(String.valueOf(list.get(position).getINVENTORYSHIFT()));
        holder.cxjs.setText(String.valueOf(list.get(position).getBMACHINENUM()));
        holder.cxj.setText(String.valueOf(list.get(position).getBMACHINEIDALL()));
        holder.cxsj.setText(String.valueOf(list.get(position).getESTIMATEDNUM()));
        return convertView;
    }

    public static class ViewHolder {
        TextView cp;
        TextView sgb;
        TextView lhj;
        TextView lhjs;
        TextView lhsj;
        TextView djrc;
        TextView rzb;
        TextView ptbxq;
        TextView stkc;
        TextView cxjs;
        TextView cxj;
        TextView cxsj;
    }
}
