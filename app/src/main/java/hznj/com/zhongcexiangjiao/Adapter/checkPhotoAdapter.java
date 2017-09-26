package hznj.com.zhongcexiangjiao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import hznj.com.zhongcexiangjiao.R;
import hznj.com.zhongcexiangjiao.Uilts.glide.GlideUtils;
import hznj.com.zhongcexiangjiao.doman.checkphotoBean;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : 传智播客
 * Author     : 隔壁小张
 * Date       : 2017/7/27 20:33
 */

public class checkPhotoAdapter extends BaseAdapter {
    private  Context context;
    private List<checkphotoBean.ListBean> list;
    public checkPhotoAdapter(Context context, List<checkphotoBean.ListBean> list) {
        this.list=list;
        this.context=context;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder;
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.list_item_checkphoto, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.pt_img);
            convertView.setTag(holder);
        }  else {
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.pt_img.setImageURI(list.get(position).getPICURL()); getImages().get(0)
        GlideUtils.display(context,holder.imageView,list.get(position).getPICURL());

        return convertView;
    }
    public static class ViewHolder {
        ImageView imageView;

    }
}
