package com.work.crazy.war3soundroid.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.work.crazy.war3soundroid.model.Unit;

import java.util.ArrayList;
import java.util.List;

public class UnitListAdapter extends ArrayAdapter {

    private ArrayList<Unit> unitList;

    public UnitListAdapter(Context context, int resource, List objects) {
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

        return null;
    }
}
