package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.XguangBean;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/3/18 23:54
 */

public class listAdapter_x extends BaseAdapter {
    private List<XguangBean.ListBean> list;
    private Context                   activity;
    public listAdapter_x( List<XguangBean.ListBean> list, Context context) {
        this.list=list;
        this.activity=context;
        if (list.size()==0) {
            new AlertDialog.Builder(activity).setTitle("加载完成").setMessage("服务器没有数据")
                    .setPositiveButton("确定",null).show();
        }
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
        LayoutInflater minflater = LayoutInflater.from(activity);
        listAdapter_x.ViewHolder holder;

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.listview_item_x, null);
            holder = new listAdapter_x.ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.x_riqi);
            holder.shijian = (TextView) convertView.findViewById(R.id.x_shijian);
            holder.jitai  = (TextView) convertView.findViewById(R.id.x_jitai);
            holder.banzu = (TextView) convertView.findViewById(R.id.x_banzu);
            holder.chengxing = (TextView) convertView.findViewById(R.id.x_chengxing);
            holder.liuhua= (TextView) convertView.findViewById(R.id.x_liuhua);
            holder.panji = (TextView) convertView.findViewById(R.id.x_panji);
            holder.chanpin = (TextView) convertView.findViewById(R.id.x_chanpin);
            holder.shigong = (TextView) convertView.findViewById(R.id.x_shigong);
            convertView.setTag(holder);
        } else {
            holder = (listAdapter_x.ViewHolder) convertView.getTag();
        }

        holder.riqi.setText(list.get(position).getDATEPRODUCED());
        holder.shijian.setText(list.get(position).getTIMEPRODUCED());
        holder.jitai.setText(list.get(position).getMACHINENAME());
        holder.banzu.setText(list.get(position).getCREW());
        holder.chengxing.setText(list.get(position).getBBARCODE());
        holder.liuhua.setText(list.get(position).getCBARCODE());
        holder.panji.setText(list.get(position).getRESULT());
        holder.chanpin.setText(list.get(position).getERPNAME());
        holder.shigong.setText(String.valueOf(list.get(position).getPROCESSNO()));
       //
        // holder.banzu.setText((Integer) list.get(position).getPROCESSNO());

        return convertView;
    }
    public static class ViewHolder {
        TextView riqi;
        TextView shijian;
        TextView chanpin;
        TextView chengxing;
        TextView shigong;
        TextView jitai;
        TextView liuhua;
        TextView panji;
        TextView banzu;
}



}


