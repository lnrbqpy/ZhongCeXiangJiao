package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.chengxingBean;


public class listAdapter_cx extends BaseAdapter {
    private List<chengxingBean.ListBean> list;
    private Context                      context;

    public listAdapter_cx(List<chengxingBean.ListBean> results, Context context) {
        this.list = results;

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
            convertView = minflater.inflate(R.layout.listview_item_cx, null);
            holder = new ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.cx_riqi);
            holder.shijian = (TextView) convertView.findViewById(R.id.cx_shijian);
            holder.chanpin = (TextView) convertView.findViewById(R.id.cx_chanpin);
            holder.banzu = (TextView) convertView.findViewById(R.id.cx_banzu);
            holder.chengxing = (TextView) convertView.findViewById(R.id.cx_chengxing);
            holder.jitai = (TextView) convertView.findViewById(R.id.cx_jitai);
            holder.shigong = (TextView) convertView.findViewById(R.id.cx_shigong);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.riqi.setText(list.get(position).getDATEPRODUCED());
        holder.shijian.setText(list.get(position).getDATEPRODUCED());
        holder.chanpin.setText(list.get(position).getERPCODE());
        holder.chengxing.setText(list.get(position).getBBARCODE());
        holder.jitai.setText(list.get(position).getMACHINEID());
        holder.shigong.setText(list.get(position).getPROCESSNO());
        holder.banzu.setText(list.get(position).getCREW());

        return convertView;
    }

    public static class ViewHolder {
        TextView riqi;
        TextView shijian;
        TextView chanpin;
        TextView chengxing;
        TextView jitai;
        TextView shigong;
        TextView banzu;
    }


}


