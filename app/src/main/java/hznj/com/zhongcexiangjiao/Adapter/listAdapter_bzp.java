package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.banzhipinBean2;

;


public class listAdapter_bzp extends BaseAdapter {
    private List<banzhipinBean2.ListBean> list;
    private Context                       context;
    public listAdapter_bzp(List<banzhipinBean2.ListBean> list, Context context) {
        this.context=context;
        this.list=list;
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
        listAdapter_bzp.ViewHolder holder;
        if (convertView == null) {
            convertView = minflater.inflate(R.layout.listview_item_bzp, null);
            holder = new listAdapter_bzp.ViewHolder();
            holder.bzp_zhipin = (TextView) convertView.findViewById(R.id.bzp_zhipin);
            holder.bzp_biaozhun = (TextView) convertView.findViewById(R.id.bzp_biaozhun);
            holder.bzp_shiji = (TextView) convertView.findViewById(R.id.bzp_shiji);
            holder.bzp_jieguo = (TextView) convertView.findViewById(R.id.bzp_jieguo);
            holder.bzp_tiaoma = (TextView) convertView.findViewById(R.id.bzp_tiaoma);

            convertView.setTag(holder);
        } else {
            holder = (listAdapter_bzp.ViewHolder) convertView.getTag();

        }
        holder.bzp_zhipin.setText(list.get(position).getTCPARTNAME());
        holder.bzp_biaozhun.setText(list.get(position).getTCPARTNUMBERS());
        holder.bzp_shiji.setText(list.get(position).getTCPARTNUMBERA());
        holder.bzp_jieguo.setText(list.get(position).getTCVERIFYRESULT());
        holder.bzp_tiaoma.setText(list.get(position).getTCBARCODE());
        return convertView;
    }
    public static class ViewHolder {
        TextView bzp_zhipin;
        TextView bzp_biaozhun;
        TextView bzp_shiji;
        TextView bzp_jieguo;
        TextView bzp_tiaoma;
    }
}
