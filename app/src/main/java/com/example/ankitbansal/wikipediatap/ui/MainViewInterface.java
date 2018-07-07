package com.example.ankitbansal.wikipediatap.ui;

import com.example.ankitbansal.wikipediatap.Response.QueryResponse;

public interface MainViewInterface {

    void onSuccess(QueryResponse body);

    void onFailure();
}
