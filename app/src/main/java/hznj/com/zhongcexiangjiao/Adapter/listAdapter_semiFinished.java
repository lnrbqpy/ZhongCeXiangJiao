package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.semiFinishedBean;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/4/11 17:05
 */

public class listAdapter_semiFinished extends BaseAdapter {
    public List<semiFinishedBean.ListBean> list;
    public Context                         contet;


    public listAdapter_semiFinished(List<semiFinishedBean.ListBean> list, Context context) {
        this.list=list;
       this.contet=context;
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
        LayoutInflater minflater = LayoutInflater.from(contet);
       ViewHolder holder;

        if (convertView==null) {
            convertView = minflater.inflate(R.layout.listview_item_banzhipin, null);
            holder = new ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.bz_riqi);
            holder.jitai= (TextView) convertView.findViewById(R.id.bz_jitai);
            holder.banci = (TextView) convertView.findViewById(R.id.bz_banci);
            holder.banzu = (TextView) convertView.findViewById(R.id.bz_banzu);
            holder.yanzheng = (TextView) convertView.findViewById(R.id.bz_yanzheng);
            holder.banzhipin = (TextView) convertView.findViewById(R.id.bz_banzhipin);
            holder.bzpgg = (TextView) convertView.findViewById(R.id.bz_bzpgg);
            holder.jiaohao = (TextView) convertView.findViewById(R.id.bz_jiaohao);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.riqi.setText(list.get(position).getDATESHIFT());
        holder.jitai.setText(list.get(position).getMACHINEID());
        holder.banci.setText(list.get(position).getDATESHIFT1());
        holder.banzu.setText(list.get(position).getCREW());
        holder.yanzheng.setText(list.get(position).getVERIFYRESULT());
        holder.banzhipin.setText(list.get(position).getPARTID());
        holder.bzpgg.setText(list.get(position).getPARTNUMBER());
        holder.jiaohao.setText(list.get(position).getDATACHR());

        return convertView;
    }
    public static class ViewHolder {
        TextView riqi;
        TextView jitai;
        TextView banci;
        TextView banzu;
        TextView yanzheng;
        TextView banzhipin;
        TextView bzpgg;
        TextView jiaohao;

    }
}
