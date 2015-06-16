package com.work.crazy.war3soundroid.presentation;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.model.RaceEnum;
import com.work.crazy.war3soundroid.util.Common;

public class RaceSelectorActivity extends ActionBarActivity {

    private RaceEnum raceEnum;
    private ImageButton humanButton;
    private ImageButton orcButton;
    private ImageButton undeadButton;
    private ImageButton elfButton;

    private View.OnTouchListener onRaceButtonTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            ImageButton imageButton = (ImageButton)v;

            RaceEnum raceEnum = RaceEnum.None;

            if (imageButton == humanButton)  {
                raceEnum = RaceEnum.Human;
            } else if (imageButton == orcButton) {
                raceEnum = RaceEnum.Orc;
            } else if (imageButton == undeadButton) {
                raceEnum = RaceEnum.Undead;
            } else if (imageButton == elfButton) {
                raceEnum = RaceEnum.Elf;
            }

            Intent raceUnitSelectorActivity = new Intent(RaceSelectorActivity.this, RaceUnitSelectorActivity.class);
            raceUnitSelectorActivity.putExtra(Common.launchRaceUnitSelectorActivityRaceKey, raceEnum);
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

}
