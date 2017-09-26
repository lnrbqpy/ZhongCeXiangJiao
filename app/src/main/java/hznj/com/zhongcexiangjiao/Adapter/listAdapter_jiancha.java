package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.jianchaBean;




public class listAdapter_jiancha extends BaseAdapter{
    List<jianchaBean.ListBean> list ;
    private   Context activity;
    public listAdapter_jiancha(List<jianchaBean.ListBean>list, Context activity) {
        this.list=list;
        this.activity=activity;
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
        ViewHolder holder;

        if (convertView==null) {
           convertView = minflater.inflate(R.layout.listview_item_jiancha, null);
            holder = new ViewHolder();
            holder.jc_tiaoma = (TextView) convertView.findViewById(R.id.jc_tiaoma);
            holder.jc_shijian= (TextView) convertView.findViewById(R.id.jc_shijian);
            holder.jc_zhijian = (TextView) convertView.findViewById(R.id.jc_zhijian);
            holder.jc_dengji = (TextView) convertView.findViewById(R.id.jc_dengji);
            holder.jc_bingxiang = (TextView) convertView.findViewById(R.id.jc_bingxiang);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.jc_tiaoma.setText(list.get(position).getBBARCODE());
        holder.jc_shijian.setText(list.get(position).getSMDATE());
        holder.jc_zhijian.setText(list.get(position).getBZ());
        holder.jc_dengji.setText(list.get(position).getDJNAME());
        holder.jc_bingxiang.setText(String.valueOf(list.get(position).getBLPNAME()));
        return convertView;
    }
    public static class ViewHolder {
        TextView jc_tiaoma;
        TextView jc_shijian;
        TextView jc_zhijian;
        TextView jc_dengji;
        TextView jc_bingxiang;

    }
}
