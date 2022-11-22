package com.example.btth2_thandroid;

import java.io.Serializable;

public class Ca implements Serializable {
    String sciencename, commonname, characteristic, color, surl;

    public Ca() {
    }

    public Ca(String sciencename, String commonname, String characteristic, String color, String surl) {
        this.sciencename = sciencename;
        this.commonname = commonname;
        this.characteristic = characteristic;
        this.color = color;
        this.surl = surl;
    }

    public String getSciencename() {
        return sciencename;
    }

    public void setSciencename(String sciencename) {
        this.sciencename = sciencename;
    }

    public String getCommonname() {
        return commonname;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}

