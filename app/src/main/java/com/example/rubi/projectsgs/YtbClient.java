package com.example.rubi.projectsgs;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Rubi on 13/04/2015.
 */
public class YtbClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().endsWith("www.youtube.com")) {
            return false;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
