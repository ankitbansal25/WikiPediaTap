package com.example.ankitbansal.wikipediatap.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.ankitbansal.wikipediatap.R;

public class WebBrowserFragment extends Fragment {

    public static WebBrowserFragment getInstance(String url) {
        WebBrowserFragment webBrowserFragment = new WebBrowserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        webBrowserFragment.setArguments(bundle);
        return webBrowserFragment;
    }

    private ProgressBar _progressBar;
    private WebView webView;
    private String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.webview_layout, container, false);

        url = this.getArguments().getString("url");
        webView = rootView.findViewById(R.id.webView_subscription);
        _progressBar = rootView.findViewById(R.id.loading_progress);

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new BrowserClient());
        webView.loadUrl(url);

        return rootView;
    }

    private class BrowserClient extends WebViewClient {

        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            _progressBar.setVisibility(View.VISIBLE);
            Log.v("WEBVIEWLOAD", "onPageStarted");
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Log.v("WEBVIEWLOAD", "onReceivedError");
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            Log.v("WEBVIEWLOAD", "onLoadResource");

        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            Log.v("WEBVIEWLOAD", "onPageFinished");
            if (isResumed()) {
                _progressBar.setVisibility(View.GONE);
            }
        }
    }

}
