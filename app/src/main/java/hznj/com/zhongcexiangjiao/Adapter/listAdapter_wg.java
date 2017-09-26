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
import hznj.com.zhongcexiangjiao.doman.waiguanBean;


public class listAdapter_wg extends BaseAdapter {
    List<waiguanBean.ListBean> list;
    private Context activity;

    public listAdapter_wg(List<waiguanBean.ListBean> list, Context context) {
        this.list = list;
        this.activity = context;
        if (list.size() == 0) {
            new AlertDialog.Builder(activity).setTitle("加载完成").setMessage("服务器没有数据")
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
        LayoutInflater minflater = LayoutInflater.from(activity);
        listAdapter_wg.ViewHolder holder;

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.listview_item_wg, null);
            holder = new listAdapter_wg.ViewHolder();
            holder.riqi = (TextView) convertView.findViewById(R.id.wg_riqi);
            holder.shijian = (TextView) convertView.findViewById(R.id.wg_shijian);
            holder.jitai = (TextView) convertView.findViewById(R.id.wg_jitai);
            holder.panji = (TextView) convertView.findViewById(R.id.wg_panji);
            holder.GXNAME = (TextView) convertView.findViewById(R.id.wg_GXNAME);
            holder.bingci = (TextView) convertView.findViewById(R.id.wg_bingci);
            holder.chengxing = (TextView) convertView.findViewById(R.id.wg_chengxing);
            holder.liuhua = (TextView) convertView.findViewById(R.id.wg_liuhua);

            convertView.setTag(holder);
        } else {
            holder = (listAdapter_wg.ViewHolder) convertView.getTag();
        }
        holder.riqi.setText(list.get(position).getDATEPRODUCED());
        holder.shijian.setText(list.get(position).getTIMEPRODUCED());
        holder.jitai.setText(list.get(position).getSBNAME());
        holder.panji.setText(list.get(position).getDJNAME());
        holder.GXNAME.setText(list.get(position).getGXNAME());
        holder.bingci.setText(list.get(position).getBLPNAME());
        holder.chengxing.setText(list.get(position).getBBARCODE());
        holder.liuhua.setText(list.get(position).getCBARCODE());


        return convertView;
    }

    public static class ViewHolder {
        TextView riqi;
        TextView shijian;
        TextView panji;
        TextView chengxing;
        TextView GXNAME;
        TextView jitai;
        TextView liuhua;
        TextView bingci;
    }


}


