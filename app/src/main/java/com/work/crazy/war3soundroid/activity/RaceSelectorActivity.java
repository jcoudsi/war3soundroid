package com.work.crazy.war3soundroid.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.model.RaceEnum;
import com.work.crazy.war3soundroid.model.Sound;
import com.work.crazy.war3soundroid.model.Unit;
import com.work.crazy.war3soundroid.util.Common;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RaceSelectorActivity extends ActionBarActivity {

    private RaceEnum raceEnum;

    private ImageButton humanButton;
    private ImageButton orcButton;
    private ImageButton undeadButton;
    private ImageButton elfButton;

    private ArrayList<Unit> humanUnitList;
    private ArrayList<Unit> orcUnitList;
    private ArrayList<Unit> undeadUnitList;
    private ArrayList<Unit> elfUnitList;

    private View.OnTouchListener onRaceButtonTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            ImageButton imageButton = (ImageButton)v;

            RaceEnum raceEnum = RaceEnum.None;
            ArrayList<Unit> unitList = new ArrayList<Unit>();

            if (imageButton == humanButton)  {
                raceEnum = RaceEnum.Human;
                unitList = humanUnitList;
            } else if (imageButton == orcButton) {
                raceEnum = RaceEnum.Orc;
                unitList = orcUnitList;
            } else if (imageButton == undeadButton) {
                raceEnum = RaceEnum.Undead;
                unitList = undeadUnitList;
            } else if (imageButton == elfButton) {
                raceEnum = RaceEnum.Elf;
                unitList = elfUnitList;
            }

            Intent raceUnitSelectorActivity = new Intent(RaceSelectorActivity.this, RaceUnitSelectorActivity.class);
            raceUnitSelectorActivity.putExtra(Common.launchRaceUnitSelectorActivityRaceKey, raceEnum);
            raceUnitSelectorActivity.putExtra(Common.launchRaceUnitSelectorActivityUnitListKey, unitList);
            startActivity(raceUnitSelectorActivity);

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_selector);

        this.humanButton = (ImageButton)findViewById(R.id.humanButton);
        this.orcButton = (ImageButton)findViewById(R.id.orcButton);
        this.undeadButton = (ImageButton)findViewById(R.id.undeadButton);
        this.elfButton = (ImageButton)findViewById(R.id.elfButton);

        this.humanButton.setOnTouchListener(this.onRaceButtonTouchListener);
        this.orcButton.setOnTouchListener(this.onRaceButtonTouchListener);
        this.undeadButton.setOnTouchListener(this.onRaceButtonTouchListener);
        this.elfButton.setOnTouchListener(this.onRaceButtonTouchListener);

        this.initData();

        /*Button soundTestButton = (Button)findViewById(R.id.soundTestButton);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.son1);

        soundTestButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mediaPlayer.start();

                return true;
            }
        });*/

    }

    private void initData()
    {
        //TEMP pour test, sera dans un fichier JSON
        this.humanUnitList = new ArrayList<Unit>();

        Unit peasant = new Unit("Paysan", R.drawable.human_peasant);
        ArrayList<Sound> peasantSoundList = new ArrayList<Sound>();
        peasantSoundList.add(new Sound("Prêt à travailler", R.raw.son1));
        peasantSoundList.add(new Sound("Oui messire", R.raw.son2));
        peasant.setSoundList(peasantSoundList);

        Unit rifleman = new Unit("Fusiller", R.drawable.human_rifleman);
        ArrayList<Sound> riflemanSoundList = new ArrayList<Sound>();
        rifleman.setSoundList(riflemanSoundList);

        Unit knight = new Unit("Chevalier", R.drawable.human_knight);
        ArrayList<Sound> knightSoundList = new ArrayList<Sound>();
        knight.setSoundList(knightSoundList);

        this.humanUnitList.add(peasant);
        this.humanUnitList.add(rifleman);
        this.humanUnitList.add(knight);

        this.orcUnitList = new ArrayList<Unit>();
        this.undeadUnitList = new ArrayList<Unit>();
        this.elfUnitList = new ArrayList<Unit>();
    }

}
