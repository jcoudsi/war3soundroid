package com.work.crazy.war3soundroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Sound implements Parcelable {

    public static final Parcelable.Creator<Sound> CREATOR = new Parcelable.Creator<Sound>() {
        @Override
        public Sound createFromParcel(Parcel source) {
            return new Sound(source);
        }

        @Override
        public Sound[] newArray(int size) {
            return new Sound[size];
        }
    };

    private String name;
    private int soundResourceId;
    private String resourceName;

    public Sound(Parcel in) {
        this.name = in.readString();
        this.soundResourceId = in.readInt();
        this.resourceName = in.readString();
    }

    public Sound(String name, int soundResourceId) {
        this.name = name;
        this.soundResourceId = soundResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoundResourceId() {
        return soundResourceId;
    }

    public void setSoundResourceId(int soundResourceId) {
        this.soundResourceId = soundResourceId;
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
        dest.writeInt(this.soundResourceId);
        dest.writeString(this.resourceName);
    }
}
