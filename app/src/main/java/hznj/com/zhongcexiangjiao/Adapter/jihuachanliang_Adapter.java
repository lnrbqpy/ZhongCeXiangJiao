package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.jh_chanliangBean;


public class jihuachanliang_Adapter extends BaseAdapter {
    private Context                         context;
    private List<jh_chanliangBean.ListBean> list1;

    public jihuachanliang_Adapter(Context context, List<jh_chanliangBean.ListBean> list) {

        this.context = context;
        this.list1 = list;

    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
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
            convertView = minflater.inflate(R.layout.listview_item_jhchanliang, null);
            holder = new ViewHolder();
            holder.jhcp_gg = (TextView) convertView.findViewById(R.id.jhcp_gg);
            holder.jhcp_yrkjh = (TextView) convertView.findViewById(R.id.jhcp_yrkjh);
            holder.jhcp_lhsj = (TextView) convertView.findViewById(R.id.jhcp_lhsj);
            holder.jhcp_dtcl = (TextView) convertView.findViewById(R.id.jhcp_dtcl);
            holder.jhcp_jhjt = (TextView) convertView.findViewById(R.id.jhcp_jhjt);
            holder.jhcp_yscjh = (TextView) convertView.findViewById(R.id.jhcp_yscjh);
            holder.jhcp_xz = (TextView) convertView.findViewById(R.id.jhcp_xz);
            holder.jhcp_cy = (TextView) convertView.findViewById(R.id.jhcp_cy);
            holder.jhcp_rjsc = (TextView) convertView.findViewById(R.id.jhcp_rjsc);
            holder.jhcp_wcliang = (TextView) convertView.findViewById(R.id.jhcp_wcliang);
            holder.jhcp_wclv = (TextView) convertView.findViewById(R.id.jhcp_wclv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.jhcp_gg.setText(list1.get(position).getSIZEID());
        holder.jhcp_yrkjh.setText(String.valueOf(list1.get(position).getREQUIREMENT()));
        holder.jhcp_lhsj.setText(String.valueOf(list1.get(position).getSCHEDULEORDER()));
        holder.jhcp_dtcl.setText(String.valueOf(list1.get(position).getCUREACTUAL()));
        holder.jhcp_jhjt.setText(String.valueOf(list1.get(position).getCURERATIO()));
        holder.jhcp_yscjh.setText(String.valueOf(list1.get(position).getCURETIME()));
        holder.jhcp_xz.setText(String.valueOf(list1.get(position).getCURECAPACITY()));
        holder.jhcp_cy.setText(String.valueOf(list1.get(position).getSMACHINENUM()));
        holder.jhcp_rjsc.setText(String.valueOf(list1.get(position).getAMACHINENUM()));
        holder.jhcp_wcliang.setText(String.valueOf(list1.get(position).getDIFFMACHIE()));
        holder.jhcp_wclv.setText(String.valueOf(list1.get(position).getCURECAPACITYALL()));
        return convertView;
    }

    public static class ViewHolder {
        TextView jhcp_gg;
        TextView jhcp_yrkjh;
        TextView jhcp_lhsj;
        TextView jhcp_dtcl;
        TextView jhcp_jhjt;
        TextView jhcp_yscjh;
        TextView jhcp_xz;
        TextView jhcp_cy;
        TextView jhcp_rjsc;
        TextView jhcp_wcliang;
        TextView jhcp_wclv;
    }
}
