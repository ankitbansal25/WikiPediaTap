package com.example.ankitbansal.wikipediatap.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ankitbansal.wikipediatap.R;
import com.example.ankitbansal.wikipediatap.Response.QueryResponse;
import com.google.gson.Gson;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class MainFragment extends Fragment implements MainViewInterface, View.OnClickListener {

    private EditText searchText;
    private Button searchButton;

    private ApiPresenter apiPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);

        searchText = view.findViewById(R.id.searchEditText);
        searchButton = view.findViewById(R.id.searchButton);

        searchButton.setOnClickListener(this);

        apiPresenter = new ApiPresenter(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        closeKeyboard();
        apiPresenter.doSearch(searchText.getText().toString());
    }

    private void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
        View currentFocus = getActivity().getCurrentFocus();
        if (null != imm && null != currentFocus) {
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    @Override
    public void onSuccess(QueryResponse response) {
        if (response == null || response.getQuery() == null) {
            showErrorMessage("No Search Results Found!");
            return;
        }
        getFragmentManager().beginTransaction()
                .replace(R.id.activity_main, SearchListFragment.getInstance(new Gson().toJson(response)))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFailure() {
        showErrorMessage("Search Fails!");
    }

    private void showErrorMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

}
