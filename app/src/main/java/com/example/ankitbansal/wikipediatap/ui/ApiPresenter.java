package com.example.ankitbansal.wikipediatap.ui;

import android.util.Log;

import com.example.ankitbansal.wikipediatap.Response.QueryResponse;
import com.example.ankitbansal.wikipediatap.apis.ApiClient;
import com.example.ankitbansal.wikipediatap.apis.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiPresenter {

    private final String TAG = "ApiPresenter";
    private final ApiInterface apiInterface;
    private MainViewInterface view;

    public ApiPresenter(MainViewInterface mainViewInterface) {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        this.view = mainViewInterface;
    }

    public void doSearch(String searchText) {
        Call<QueryResponse> call = apiInterface.doGetJsonResponse(searchText);
        call.enqueue(new Callback<QueryResponse>() {
            @Override
            public void onResponse(Call<QueryResponse> call, Response<QueryResponse> response) {
                Log.i(TAG, "Success!");
                view.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<QueryResponse> call, Throwable t) {
                Log.i(TAG, "Failed!");
                view.onFailure();
            }
        });
    }
}
