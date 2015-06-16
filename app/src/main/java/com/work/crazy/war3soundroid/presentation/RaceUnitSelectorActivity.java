package com.work.crazy.war3soundroid.presentation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.model.RaceEnum;
import com.work.crazy.war3soundroid.util.Common;


public class RaceUnitSelectorActivity extends ActionBarActivity {

    private RaceEnum raceEnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_unit_selector);

        Intent i = getIntent();
        RaceEnum raceEnum = (RaceEnum)i.getSerializableExtra(Common.launchRaceUnitSelectorActivityRaceKey);

        setTitle(this.getActivityTitle(raceEnum));
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
