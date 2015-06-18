package com.work.crazy.war3soundroid.model;

import java.util.ArrayList;
import java.util.Map;

public class Response {

    private ArrayList<Unit> humans;
    private ArrayList<Unit> orcUnits;
    private ArrayList<Unit> undeadUnits;
    private ArrayList<Unit> elfUnits;

    public ArrayList<Unit> getHumans() {
        return humans;
    }

    public void setHumans(ArrayList<Unit> humans) {
        this.humans = humans;
    }

    public ArrayList<Unit> getOrcUnits() {
        return orcUnits;
    }

    public void setOrcUnits(ArrayList<Unit> orcUnits) {
        this.orcUnits = orcUnits;
    }

    public ArrayList<Unit> getUndeadUnits() {
        return undeadUnits;
    }

    public void setUndeadUnits(ArrayList<Unit> undeadUnits) {
        this.undeadUnits = undeadUnits;
    }

    public ArrayList<Unit> getElfUnits() {
        return elfUnits;
    }

    public void setElfUnits(ArrayList<Unit> elfUnits) {
        this.elfUnits = elfUnits;
    }
}
