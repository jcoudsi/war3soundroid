package com.work.crazy.war3soundroid.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.adapter.UnitAdapter;
import com.work.crazy.war3soundroid.model.RaceEnum;
import com.work.crazy.war3soundroid.model.Unit;
import com.work.crazy.war3soundroid.util.Common;

import java.util.ArrayList;


public class RaceUnitSelectorActivity extends ActionBarActivity {

    private RaceEnum raceEnum;
    private ListView raceUnitListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_unit_selector);

        Intent intent = getIntent();
        RaceEnum raceEnum = (RaceEnum)intent.getSerializableExtra(Common.launchRaceUnitSelectorActivityRaceKey);
        ArrayList<Unit> unitsList = intent.getParcelableArrayListExtra(Common.launchRaceUnitSelectorActivityUnitListKey);

        setTitle(this.getActivityTitle(raceEnum));

        this.raceUnitListView = (ListView) findViewById(R.id.raceUnitListView);
        ListAdapter listAdapter = new UnitAdapter(this, android.R.layout.simple_list_item_1, unitsList);
        this.raceUnitListView.setAdapter(listAdapter);
    }

    private String getActivityTitle(RaceEnum raceEnum) {

        switch (raceEnum) {
            case Human:
                return getResources().getString(R.string.humans);
            case Orc:
                return getResources().getString(R.string.orcs);
            case Undead:
                return getResources().getString(R.string.undead);
            case Elf:
                return getResources().getString(R.string.elfs);
            default:
                return "";
        }
    }

}
