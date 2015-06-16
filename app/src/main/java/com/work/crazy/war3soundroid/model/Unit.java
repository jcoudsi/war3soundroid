package com.work.crazy.war3soundroid.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Unit implements Parcelable {

    public static final Parcelable.Creator<Unit> CREATOR = new Parcelable.Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel source) {
            return new Unit(source);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };

    private String name;
    private int imageResourceId;
    private ArrayList<Sound> soundList;

    public Unit(Parcel in) {
        this.name = in.readString();
        this.imageResourceId = in.readInt();
        this.soundList = in.readArrayList(Sound.class.getClassLoader());
    }

    public Unit(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public ArrayList<Sound> getSoundList() {
        return soundList;
    }

    public void setSoundList(ArrayList<Sound> soundList) {
        this.soundList = soundList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.imageResourceId);
        dest.writeList(this.soundList);
    }
}
