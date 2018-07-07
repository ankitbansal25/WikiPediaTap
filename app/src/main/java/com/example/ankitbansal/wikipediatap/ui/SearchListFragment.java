package com.example.ankitbansal.wikipediatap.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ankitbansal.wikipediatap.R;
import com.example.ankitbansal.wikipediatap.Response.QueryResponse;
import com.google.gson.Gson;

import java.util.Arrays;

import static com.example.ankitbansal.wikipediatap.apis.ApiClient.BASE_URL;

public class SearchListFragment extends Fragment {

    private QueryResponse queryResponse;
    private ListView listView;
    private ListAdapter listAdapter;

    public static Fragment getInstance(String queryResponse) {
        SearchListFragment searchListFragment = new SearchListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("response", queryResponse);
        searchListFragment.setArguments(bundle);
        return searchListFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queryResponse = getResponse();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view, container, false);
        listView = view.findViewById(R.id.listView);
        listAdapter = new ListAdapter(getActivity(), Arrays.asList(queryResponse.getQuery().getPages()));
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getFragmentManager().beginTransaction().
                        replace(R.id.activity_main, WebBrowserFragment.getInstance(BASE_URL + "/wiki/" + queryResponse.getQuery().getPages()[position].getTitle()))
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    public QueryResponse getResponse() {
        Bundle bundle = this.getArguments();
        if (null != bundle) {
            return new Gson().fromJson(bundle.getString("response"), QueryResponse.class);
        }
        return null;
    }
}
