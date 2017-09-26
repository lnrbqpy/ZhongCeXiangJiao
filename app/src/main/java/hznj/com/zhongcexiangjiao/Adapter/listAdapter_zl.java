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
import hznj.com.zhongcexiangjiao.doman.zhongliangBean;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/3/18 23:54
 */

public class listAdapter_zl extends BaseAdapter {
    private List<zhongliangBean.ListBean> list;
    private Context                       context;

    public listAdapter_zl(List<zhongliangBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
        if (list.size() == 0) {
            new AlertDialog.Builder(context).setTitle("加载完成").setMessage("服务器没有数据")
                    .setPositiveButton("确定", null).show();
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
        LayoutInflater minflater = LayoutInflater.from(context);
        ViewHolder holder;

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.listview_item_zl, null);
            holder = new ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.zl_riqi);
            holder.shijian = (TextView) convertView.findViewById(R.id.zl_shijian);
            holder.jitai = (TextView) convertView.findViewById(R.id.zl_jitai);
            holder.chanpin = (TextView) convertView.findViewById(R.id.zl_chanpin);
            holder.chengxing = (TextView) convertView.findViewById(R.id.zl_chengxing);
           holder.shijizhongliang = (TextView) convertView.findViewById(R.id.zl_shijizhongliang);
           holder.biaozhunzhongliang = (TextView) convertView.findViewById(R.id.zl_biaozhunzhongliang);
            holder.panji = (TextView) convertView.findViewById(R.id.zl_panji);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.riqi.setText(list.get(position).getDATEPRODUCED());
        holder.shijian.setText(list.get(position).getTIMEPRODUCED());
        holder.jitai.setText(list.get(position).getMACHINENAME());
        holder.shijizhongliang.setText(String.valueOf(list.get(position).getWEIGHT()) );
        holder.biaozhunzhongliang.setText(String.valueOf(list.get(position).getWEIGHTSTD()));
        holder.chengxing.setText(list.get(position).getBBARCODE());
        holder.panji.setText(list.get(position).getRESULT());
        holder.chanpin.setText(String.valueOf(list.get(position).getERPNAME()));

        return convertView;
    }

    public static class ViewHolder {
        TextView riqi;
        TextView shijian;
        TextView chanpin;
        TextView chengxing;
        TextView shijizhongliang;
        TextView biaozhunzhongliang;
        TextView panji;
        TextView jitai;
    }


}


