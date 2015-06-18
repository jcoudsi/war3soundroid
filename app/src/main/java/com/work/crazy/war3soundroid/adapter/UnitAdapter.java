package com.work.crazy.war3soundroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.model.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitAdapter extends ArrayAdapter {

    private ArrayList<Unit> unitList;
    private Context context;

    static class ViewHolder {
        public TextView unitName;
        public ImageView unitImageView;
}

    public UnitAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.unitList = (ArrayList<Unit>)objects;
    }

    @Override
    public int getCount() {
        return this.unitList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.unitList.get(position);
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
            int imageResourceId = context.getResources().getIdentifier(unit.getResourceName(), "drawable", context.getPackageName());
            holder.unitImageView.setImageResource(imageResourceId);
        }

        return convertView;
    }
}
