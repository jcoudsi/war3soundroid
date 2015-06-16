package com.work.crazy.war3soundroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.model.Sound;
import com.work.crazy.war3soundroid.model.Unit;

import java.util.ArrayList;
import java.util.List;

public class SoundAdapter extends ArrayAdapter {

    private ArrayList<Sound> soundList;

    static class ViewHolder {
        public TextView unitName;
        public ImageView unitImageView;
}

    public SoundAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.soundList = (ArrayList<Sound>)objects;
    }

    @Override
    public int getCount() {
        return this.soundList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.soundList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.unit_list_item, parent, false);

            holder = new ViewHolder();

            holder.unitName = (TextView) convertView.findViewById(R.id.unitName);
            holder.unitImageView = (ImageView) convertView.findViewById(R.id.unitImageView);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder)convertView.getTag();
        }

        Unit unit = (Unit)this.getItem(position);

        if (unit != null) {
            holder.unitName.setText(unit.getName());
            holder.unitImageView.setImageResource(unit.getImageResourceId());
        }

        return convertView;
    }
}
