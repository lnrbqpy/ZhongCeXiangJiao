package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.sqzbBean;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Date       : 2017/5/9 18:56
 */

public class ListAdapter_sq_zb extends BaseAdapter {
    private Context context;
    List<sqzbBean.ListBean> list;
    private static String YOURENWU   = "1"; //huangse
    private static String ZHENGCHANG = "2"; //lvse
    private static String YICHANG    = "3"; //hongse


    public ListAdapter_sq_zb(Context context, List<sqzbBean.ListBean> list) {
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
        ListAdapter_sq_zb.ViewHolder holder;

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.listview_sq_cx, null);
            holder = new ListAdapter_sq_zb.ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.sq_mx_name);
            holder.time = (TextView) convertView.findViewById(R.id.sq_mx_time);
            holder.renwu = (TextView) convertView.findViewById(R.id.sq_mx_renwu);
            convertView.setTag(holder);
        } else {
            holder = (ListAdapter_sq_zb.ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getSTCODE());
        holder.time.setText(list.get(position).getDECODE1());
        if (list.get(position).getDECODE2().equals(ZHENGCHANG)) {
            holder.renwu.setBackgroundResource(R.color.green);
            holder.renwu.setText("正常");
        } else if (list.get(position).getDECODE2().equals(YOURENWU)) {
            holder.renwu.setBackgroundResource(R.color.yellow);
            holder.renwu.setText("有任务");
        } else if (list.get(position).getDECODE2().equals(YICHANG)) {
            holder.renwu.setBackgroundResource(R.color.red);
            holder.renwu.setText("异常");
        } else {

            holder.renwu.setBackgroundResource(R.color.grey);
            holder.renwu.setText("无任务");
        }

        return convertView;
    }

    public class ViewHolder {
        TextView name;
        TextView time;
        TextView renwu;
    }
}
