package com.work.crazy.war3soundroid.model;

import android.os.Parcel;
import android.os.Parcelable;

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
    private String resourceName;
    private ArrayList<Sound> sounds;

    public Unit(Parcel in) {
        this.name = in.readString();
        this.resourceName = in.readString();
        this.sounds = in.readArrayList(Sound.class.getClassLoader());
    }

    public Unit(String name, String resourceName) {
        this.name = name;
        this.resourceName = resourceName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(ArrayList<Sound> sounds) {
        this.sounds = sounds;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.resourceName);
        dest.writeList(this.sounds);
    }
}
