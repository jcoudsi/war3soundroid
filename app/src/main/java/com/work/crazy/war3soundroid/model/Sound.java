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
    private String resourceName;

    public Sound(String name, String resourceName) {
        this.name = name;
        this.resourceName = resourceName;
    }

    public Sound(Parcel in) {
        this.name = in.readString();
        this.resourceName = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    }
}
