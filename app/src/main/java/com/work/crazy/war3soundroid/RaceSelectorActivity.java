package com.work.crazy.war3soundroid;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class RaceSelectorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_selector);

        Button soundTestButton = (Button)findViewById(R.id.soundTestButton);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.son1);

        soundTestButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mediaPlayer.start();

                return true;
            }
        });

    }

}
