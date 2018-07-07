package com.example.ankitbansal.wikipediatap.Response;

public class QueryResponse {
    private Query query;

    private Continue continues;

    private String batchcomplete;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public Continue getContinue() {
        return continues;
    }

    public void setContinue(Continue continues) {
        this.continues = continues;
    }

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    @Override
    public String toString() {
        return "ClassPojo [query = " + query + ", continue = " + continues
                + ", batchcomplete = " + batchcomplete + "]";
    }
}
