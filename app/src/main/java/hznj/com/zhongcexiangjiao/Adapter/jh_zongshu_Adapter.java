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
import hznj.com.zhongcexiangjiao.doman.jh_zongshuBean;


/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/6/19 14:49
 */

public class jh_zongshu_Adapter extends BaseAdapter {
    private Context                    context;
    private List<jh_zongshuBean.ListBean> list;

    public jh_zongshu_Adapter(Context context, List<jh_zongshuBean.ListBean> list) {
        this.list=list;
        this.context=context;
    }


    @Override
    public int getCount() {
        Toast.makeText(context,list.size(),Toast.LENGTH_SHORT).show();
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
            convertView = minflater.inflate(R.layout.listview_item_jhzongshu, null);
            holder = new ViewHolder();
            holder.jhzs_gg = (TextView) convertView.findViewById(R.id.jhzs_gg);
            holder.jhzs_xsxq = (TextView) convertView.findViewById(R.id.jhzs_xsxq);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
       // holder.jhzs_gg.setText(String.valueOf(list.get(position).getESTIMATEDDATE()));
       // holder.jhzs_xsxq.setText(String.valueOf(list.get(position).getCOMPARETOPLAN()));
        holder.jhcp_jhscs.setText(list.get(position).getFNAME());
        return convertView;
    }
    public static class ViewHolder {
        TextView jhzs_gg;
        TextView jhzs_xsxq;
        TextView jhcp_jhscs;
        TextView jhcp_lhjs;
        TextView jhcp_lhscs;
        TextView jhcp_yscjh;
        TextView jhcp_xz;
        TextView jhcp_cy;
        TextView jhcp_rjsc;
        TextView jhcp_wcliang;
        TextView jhcp_wclv;
    }
}
