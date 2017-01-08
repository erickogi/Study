package com.example.kimanikogi.study;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class timetable extends AppCompatActivity {
WebView web;
    Button tod;
    Button tom;
    Button full;
    String htmlFilename = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);



        tod=(Button)findViewById(R.id.today);
        tom=(Button)findViewById(R.id.tomoro);
        full=(Button)findViewById(R.id.full);
        tod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                htmlFilename = "http://erickogi.co.ke/appa/uploads/today.html";
                try {
                    setOn();
                }
                catch (Exception n){
                    Toast.makeText(timetable.this, "Not yet Available", Toast.LENGTH_SHORT).show();
                }

            }
        });
        tom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                htmlFilename="http://erickogi.co.ke/appa/uploads/tomoro.html";
                try {
                    setOn();
                }
                catch (Exception n){
                    Toast.makeText(timetable.this, "Not yet Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
        full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                htmlFilename="SIS-2016-09-12(exam)-1.html";
                set();
            }
        });
    }
    private  void setOn(){

        web=(WebView)findViewById(R.id.webView);
        web.getSettings().setBuiltInZoomControls(true);
        web.getSettings().setJavaScriptEnabled(true);

        // setContentView(web);
        //web.setWebViewClient(new WebViewController());
        web.loadUrl(htmlFilename);
        setContentView(web);
    }
    public void set(){
        WebView htmlWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);


        AssetManager mgr = getBaseContext().getAssets();
        try {
            InputStream in = mgr.open(htmlFilename, AssetManager.ACCESS_BUFFER);
            final   String htmlContentInStringFormat = StreamToString(in);
            in.close();

            htmlWebView.loadDataWithBaseURL(null,null,null,null,null);
            htmlWebView.loadDataWithBaseURL(null, htmlContentInStringFormat, "text/html", "utf-8", null);
            htmlWebView.setWebViewClient(new WebViewClient() {



            });
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
    public static String StreamToString(InputStream in) throws IOException {
        if(in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }
}
