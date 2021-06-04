package com.example.pictureapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web = (WebView)findViewById(R.id.webView);
        WebSettings settings = web.getSettings();
        settings.setBuiltInZoomControls(true);
        web.setWebViewClient(new Callback());
        web.loadUrl("http://kieutrongkhanh.net");
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }

    public void onHTMLClick(View view) {
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        String html = "<h1>Web View Demo</h1>"
                +"<body>"
                +"<p>WebView embeds the Browser in Native App</p>"
                +"</body>";
        web.loadData(html, mimeType, encoding);
    }

    public void onBrowseClick(View view) {
        EditText txt = (EditText)findViewById(R.id.txtInput);
        web.loadUrl(txt.getText().toString());
    }

}
