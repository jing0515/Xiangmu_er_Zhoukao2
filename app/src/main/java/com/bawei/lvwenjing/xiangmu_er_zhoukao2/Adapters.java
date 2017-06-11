package com.bawei.lvwenjing.xiangmu_er_zhoukao2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lenovo-pc on 2017/7/11.
 */

public class Adapters extends BaseAdapter {
    List<Bean.StudentsBean.StudentBean> list;
    Context context;

    private TextView title;
    private ImageView iv;
    private InforHard inforHard1;

    public Adapters(List<Bean.StudentsBean.StudentBean> list, Context context) {
        this.list = list;
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
        if (convertView == null) {
            inforHard1 = new InforHard();
            convertView = View.inflate(context, R.layout.item_horde, null);
            inforHard1.tv = (TextView) convertView.findViewById(R.id.one_title);
            inforHard1.iv = (ImageView) convertView.findViewById(R.id.imager_one);
            convertView.setTag(inforHard1);
        } else {
            inforHard1 = (InforHard) convertView.getTag();
        }
        inforHard1.tv.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImg()).into(inforHard1.iv);
        return convertView;
    }

    class InforHard {
        TextView tv;
        ImageView iv;
    }


}
