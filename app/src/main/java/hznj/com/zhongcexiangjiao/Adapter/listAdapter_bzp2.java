package hznj.com.zhongcexiangjiao.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.doman.jiaoliaoBean;


public class listAdapter_bzp2 extends BaseAdapter {
    private List<jiaoliaoBean.ListBean> list;
    private Context                     context;

    public listAdapter_bzp2(List<jiaoliaoBean.ListBean> list, Context context) {
           this.list=list;
        this.context=context;

    }

    @Override
    public int getCount() {
        return list.size();

    }

    @Override
    public Object getItem(int position) {
        Log.i("zzz",list.get(position).toString());
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater minflater = LayoutInflater.from(context);
        listAdapter_bzp2.ViewHolder holder;

        if (convertView==null) {
            convertView = minflater.inflate(R.layout.listview_item_jiaoliao, null);
            holder = new listAdapter_bzp2.ViewHolder();
            holder.jl_jiaozhong = (TextView) convertView.findViewById(R.id.jl_jiaozhong);
            holder.jl_biaozhun= (TextView) convertView.findViewById(R.id.jl_biaozhun);
            holder.jl_shiji = (TextView) convertView.findViewById(R.id.jl_shiji);
            holder.jl_jieguo = (TextView) convertView.findViewById(R.id.jl_jieguo);
            holder.jl_changma = (TextView) convertView.findViewById(R.id.jl_changma);
            convertView.setTag(holder);
        } else {
            holder = (listAdapter_bzp2.ViewHolder) convertView.getTag();
        }
        holder.jl_jiaozhong.setText(list.get(position).getPLACENAME());
        holder.jl_biaozhun.setText(list.get(position).getDATACHR());
        holder.jl_shiji.setText(list.get(position).getGUMNO());
        holder.jl_jieguo.setText(list.get(position).getBCORDCHECKRESULT());
        holder.jl_changma.setText(list.get(position).getBARCODE());

        return convertView;
    }
    public static class ViewHolder {
        TextView jl_jiaozhong;
        TextView jl_biaozhun;
        TextView jl_shiji;
        TextView jl_jieguo;
        TextView jl_changma;

    }
}
