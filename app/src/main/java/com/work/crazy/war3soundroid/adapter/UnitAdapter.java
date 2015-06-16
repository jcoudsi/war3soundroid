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

    public UnitAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
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

        Unit unit = (Unit)this.getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.unit_list_item, parent, false);
        }

        TextView unitName = (TextView) convertView.findViewById(R.id.unitName);
        ImageView unitImageView = (ImageView) convertView.findViewById(R.id.unitImageView);

        unitName.setText(unit.getName());
        unitImageView.setImageResource(unit.getImageResourceId());

        return convertView;
    }
}
