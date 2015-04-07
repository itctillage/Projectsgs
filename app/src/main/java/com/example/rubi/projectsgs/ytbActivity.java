package com.example.rubi.projectsgs;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class ytbActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytb);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            WebView.class.getMethod("onResume").invoke(mWebView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            WebView.class.getMethod("onPause").invoke(mWebView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initWebView() {
        mWebView = (WebView) findViewById(R.id.webView);

        // WebViewの設定
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT > 7) {
            settings.setPluginState(WebSettings.PluginState.ON);
        } else {
            settings.setMediaPlaybackRequiresUserGesture(true);
        }

        String html = "";
        html += "<html><body>";
        html += "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/watch?v=IRlXtY3DO2Y\" frameborder=\"0\" allowfullscreen></iframe>";
        html += "</body></html>";

        mWebView.loadData(html, "text/html", null);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ytb, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
