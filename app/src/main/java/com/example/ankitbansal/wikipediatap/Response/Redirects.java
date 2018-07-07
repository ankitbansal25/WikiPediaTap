package com.example.ankitbansal.wikipediatap.Response;

public class Redirects {
    private String to;

    private String index;

    private String from;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "ClassPojo [to = " + to + ", index = " + index + ", from = " + from + "]";
    }
}
