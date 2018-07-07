package com.example.ankitbansal.wikipediatap.Response;

public class Query {
    private Pages[] pages;

    private Redirects[] redirects;

    public Pages[] getPages() {
        return pages;
    }

    public void setPages(Pages[] pages) {
        this.pages = pages;
    }

    public Redirects[] getRedirects() {
        return redirects;
    }

    public void setRedirects(Redirects[] redirects) {
        this.redirects = redirects;
    }

    @Override
    public String toString() {
        return "ClassPojo [pages = " + pages + ", redirects = " + redirects + "]";
    }
}
