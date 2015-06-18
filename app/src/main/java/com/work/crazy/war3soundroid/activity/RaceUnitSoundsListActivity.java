package com.work.crazy.war3soundroid.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.work.crazy.war3soundroid.R;
import com.work.crazy.war3soundroid.model.Sound;
import com.work.crazy.war3soundroid.util.Common;

import java.util.ArrayList;


public class RaceUnitSoundsListActivity extends ActionBarActivity {

    private ArrayList<Sound> soundList;
    private Context context;

    private AdapterView.OnItemClickListener soundListOnItemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            int soundResourceId = getResources().getIdentifier(soundList.get(position).getResourceName(), "raw", getPackageName());
            //final MediaPlayer mediaPlayer = MediaPlayer.create(context, soundList.get(position).getSoundResourceId());
            final MediaPlayer mediaPlayer = MediaPlayer.create(context, soundResourceId);
            mediaPlayer.start();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_unit_sounds_list);

        Intent intent = getIntent();
        String unitName = intent.getStringExtra(Common.launchRaceUnitSelectorActivityUnitNameKey);
        this.setTitle(unitName);

        this.soundList = intent.getParcelableArrayListExtra(Common.launchRaceUnitSelectorActivitySoundListKey);

        ListView soundListView = (ListView)findViewById(R.id.soundListView);
        ListAdapter soundListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.getSoundNameList());
        this.context = this;
        soundListView.setAdapter(soundListAdapter);
        soundListView.setOnItemClickListener(this.soundListOnItemClickListener);
    }

    private ArrayList<String> getSoundNameList() {

        ArrayList<String> soundNameList = new ArrayList<String>();

        for (Sound sound : this.soundList) {
            soundNameList.add(sound.getName());
        }

        return soundNameList;
    }
}
