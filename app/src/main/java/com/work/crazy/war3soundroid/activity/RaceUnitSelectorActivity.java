package com.work.crazy.war3soundroid.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<Unit> unitList;

    private AdapterView.OnItemClickListener unitListOnItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent raceUnitSoundsListActivity = new Intent(RaceUnitSelectorActivity.this, RaceUnitSoundsListActivity.class);
            raceUnitSoundsListActivity.putExtra(Common.launchRaceUnitSelectorActivitySoundListKey, unitList.get(position).getSoundList());
            startActivity(raceUnitSoundsListActivity);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_unit_selector);

        Intent intent = getIntent();
        RaceEnum raceEnum = (RaceEnum)intent.getSerializableExtra(Common.launchRaceUnitSelectorActivityRaceKey);
        this.unitList = intent.getParcelableArrayListExtra(Common.launchRaceUnitSelectorActivityUnitListKey);

        setTitle(this.getActivityTitle(raceEnum));

        ListView raceUnitListView = (ListView) findViewById(R.id.raceUnitListView);
        ListAdapter unitListAdapter = new UnitAdapter(this, R.layout.unit_list_item, this.unitList);
        raceUnitListView.setAdapter(unitListAdapter);
        raceUnitListView.setOnItemClickListener(this.unitListOnItemClickListener);
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
