package com.example.ankitbansal.wikipediatap.Response;

public class Continue {
    private String gpsoffset;

    private String continues;

    public String getGpsoffset() {
        return gpsoffset;
    }

    public void setGpsoffset(String gpsoffset) {
        this.gpsoffset = gpsoffset;
    }

    public String getContinue() {
        return continues;
    }

    public void setContinue(String continues) {
        this.continues = continues;
    }

    @Override
    public String toString() {
        return "ClassPojo [gpsoffset = " + gpsoffset + ", continue = " + continues + "]";
    }
}
