package com.work.crazy.war3soundroid.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.work.crazy.war3soundroid.R;
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

        Intent i = getIntent();
        RaceEnum raceEnum = (RaceEnum)i.getSerializableExtra(Common.launchRaceUnitSelectorActivityRaceKey);
        setTitle(this.getActivityTitle(raceEnum));

        this.raceUnitListView = (ListView)findViewById(R.id.raceUnitListView);

        ArrayList<Unit> unitsList = new ArrayList<Unit>();
        unitsList.add(new Unit("Paysan", ""));
        unitsList.add(new Unit("Fusiller", ""));
        unitsList.add(new Unit("Chevalier", ""));

        ListAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, unitsList);
        this.raceUnitListView.setAdapter(listAdapter);
    }

    private String getActivityTitle(RaceEnum raceEnum) {

        switch (raceEnum) {
            case Human:
                return "Humains";
            case Orc:
                return "Orcs";
            case Undead:
                return "Morts-vivants";
            case Elf:
                return "Elfes";
            default:
                return "";
        }
    }

}
