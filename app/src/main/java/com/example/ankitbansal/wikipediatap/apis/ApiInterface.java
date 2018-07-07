package com.example.ankitbansal.wikipediatap.apis;

import com.example.ankitbansal.wikipediatap.Response.QueryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("w/api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description&gpssearch=Sachin+T&gpslimit=10")
    Call<QueryResponse> doGetJsonResponse(@Query("gpssearch") String searchText);
}
