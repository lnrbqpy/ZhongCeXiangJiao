package hznj.com.zhongcexiangjiao.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.jlChaXunBean;


public class listAdapter_tiaoma2 extends BaseAdapter{

    private Context                     context1;
    private List<jlChaXunBean.ListBean> list;
    public listAdapter_tiaoma2(List<jlChaXunBean.ListBean> list, Context context) {
        this.list = list;
        this.context1 = context;
        if (list.size()==0) {

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
        LayoutInflater minflater = LayoutInflater.from(context1);
        listAdapter_tiaoma2.ViewHolder holder;

        if (convertView == null) {
            convertView = minflater.inflate(R.layout.list_item_jltm, null);
            holder = new listAdapter_tiaoma2.ViewHolder();
            holder.bzptm_riqi = (TextView) convertView.findViewById(R.id.jltm_riqi);
            holder.bzptm_banci = (TextView) convertView.findViewById(R.id.jltm_banci);
            holder.bzptm_banzu = (TextView) convertView.findViewById(R.id.jltm_banzu);
            holder.bzptm_jitai = (TextView) convertView.findViewById(R.id.jltm_jitai);
            holder.bzptm_scsj = (TextView) convertView.findViewById(R.id.jltm_scsj);
            holder.bzptm_shigong = (TextView) convertView.findViewById(R.id.jltm_shigong);
            holder.bzptm_yanzheng = (TextView) convertView.findViewById(R.id.jltm_yanzheng);
            holder.bzptm_chengxing = (TextView) convertView.findViewById(R.id.jltm_chengxing);
            holder.bzptm_tiaoma = (TextView) convertView.findViewById(R.id.jltm_tiaoma);
            convertView.setTag(holder);
        } else {
            holder = (listAdapter_tiaoma2.ViewHolder) convertView.getTag();
        }
        holder.bzptm_riqi.setText(list.get(position).getYYYYMMDD());
        holder.bzptm_banci.setText(list.get(position).getSHIFT());
        holder.bzptm_banzu.setText(list.get(position).getCREW());
        holder.bzptm_jitai.setText(list.get(position).getMACHINEID());
        holder.bzptm_scsj.setText(list.get(position).getDATETIMEPRODUCED());
        holder.bzptm_shigong.setText(list.get(position).getPROCESSNO());
        holder.bzptm_yanzheng.setText(list.get(position).getVERIFYRESULT());
        holder.bzptm_chengxing.setText(list.get(position).getOPERATOR1());
        holder.bzptm_tiaoma.setText(list.get(position).getBARCODE());

        return convertView;
    }

    public static class ViewHolder {
        TextView bzptm_riqi;
        TextView bzptm_banci;
        TextView bzptm_banzu;
        TextView bzptm_jitai;
        TextView bzptm_scsj;
        TextView bzptm_shigong;
        TextView bzptm_yanzheng;
        TextView bzptm_chengxing;
        TextView bzptm_tiaoma;

    }
}
