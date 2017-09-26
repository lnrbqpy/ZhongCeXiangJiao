package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.liuhuaBean;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/3/18 23:19
 */

public class listAdapter_lh extends BaseAdapter {
    private List<liuhuaBean.ListBean> list;
    private Context                   context;

    public listAdapter_lh(List<liuhuaBean.ListBean> list, Context context) {
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

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.listview_item_lh, null);
            holder = new ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.lh_riqi);
            holder.shijian = (TextView) convertView.findViewById(R.id.lh_shijian);
            holder.banzu = (TextView) convertView.findViewById(R.id.lh_banzu);
            holder.chengxing = (TextView) convertView.findViewById(R.id.lh_chengxing);
            holder.guige = (TextView) convertView.findViewById(R.id.lh_guige);
            holder.jitai = (TextView) convertView.findViewById(R.id.lh_jitai);
            holder.liuhua = (TextView) convertView.findViewById(R.id.lh_liuhua);
            holder.shigong = (TextView) convertView.findViewById(R.id.lh_shigong);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.riqi.setText(list.get(position).getDATEPRODUCED());
        holder.shijian.setText(list.get(position).getTIMEPRODUCED());
        holder.banzu.setText(list.get(position).getCREW());
        holder.chengxing.setText(list.get(position).getBBARCODE());
        holder.guige.setText(list.get(position).getGTCODE());
        holder.jitai.setText(list.get(position).getMACHINEID());
        holder.liuhua.setText(list.get(position).getCBARCODE());
        holder.shigong.setText(list.get(position).getPROCESSNO());


        return convertView;
    }
    public static class ViewHolder {
        TextView riqi;
        TextView shijian;
        TextView banzu;
        TextView chengxing;
        TextView guige;
        TextView jitai;
        TextView liuhua;
        TextView shigong;

    }
}


