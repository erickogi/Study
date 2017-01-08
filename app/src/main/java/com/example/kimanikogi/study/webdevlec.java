package com.example.kimanikogi.study;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class webdevlec extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int pos=1;
    String htmlFilename = "Week1www.htm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webdevlec);


        set();
        WebView htmlWebView = (WebView)findViewById(R.id.webView);
htmlWebView.getSettings().setBuiltInZoomControls(true);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab();
            }
        });
        final FloatingActionButton fabb = (FloatingActionButton) findViewById(R.id.fabb);
        fabb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabb();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void fab(){
        int a=pos+1;
        next(a);



    }
    public void fabb(){
        int a=pos-1;
        next(a);



    }
    public void next(int a){
        switch (a){
            case 1:
                pos=1;
                htmlFilename = "Week1www.htm";
                set();
                break;
            case 2:
                pos=2;
                htmlFilename = "WEEK2concepts.htm";
                set();
                break;
            case 3:
                pos=3;
                htmlFilename = "WEEK3overview.htm";
                set();
                break;
            case 4:
                pos=4;
                htmlFilename = "WEEK4htmltext.htm";
                set();
                break;
            case 5:
                pos=5;
                htmlFilename = "WEEK4lists.htm";
                set();
                break;
            case 6:
                pos=6;
                htmlFilename = "WEEK5images.htm";
                set();
                break;
            case 7:
                pos=7;
                htmlFilename = "WEEK6linkschap6.htm";
                set();
                break;
            case 8:
                pos=8;
                htmlFilename = "WEEK7tables.htm";
                set();
                break;
            case 9:
                pos=9;
                htmlFilename = "WEEK8background,media.htm";
                set();
                break;

            case 10:
                pos=10;
                htmlFilename = "WEEK9frames.htm";
                set();
                break;
            case 11:
                pos=11;
                htmlFilename = "WEEK10forms.htm";
                set();
                break;
            case 12:
                pos=12;
                htmlFilename = "CSS/CSS.html";
                set();
                break;
            case 13:
                pos=13;
                htmlFilename = "js/JavaScript.html";
                set();
                break;



            default:
                Toast.makeText(webdevlec.this," End Reached ",Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.webdevlec, menu);
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
    public void set(){
        WebView htmlWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);


        AssetManager mgr = getBaseContext().getAssets();
        try {
            InputStream in = mgr.open(htmlFilename, AssetManager.ACCESS_BUFFER);
            String htmlContentInStringFormat = StreamToString(in);
            in.close();
            htmlWebView.loadDataWithBaseURL(null,null,null,null,null);
            htmlWebView.loadDataWithBaseURL(null, htmlContentInStringFormat, "text/html", "utf-8", null);

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.www) {
            pos=1;
            htmlFilename = "Week1www.htm";
            set();
            // Handle the camera action
        } else if (id == R.id.concepts) {
            pos=2;
            htmlFilename = "WEEK2concepts.htm";
            set();

        } else if (id == R.id.overview) {
            pos=3;
            htmlFilename = "WEEK3overview.htm";
            set();
        } else if (id == R.id.htmltext) {
            pos=4;
            htmlFilename = "WEEK4htmltext.htm";
            set();
        } else if (id == R.id.listt) {
            pos=5;
            htmlFilename = "WEEK4lists.htm";
            set();
        } else if (id == R.id.images) {
            pos=6;
            htmlFilename = "WEEK5images.htm";
            set();
        }
        else if (id == R.id.link) {
            pos=7;
            htmlFilename = "WEEK6linkschap6.htm";
            set();
        }
        else if (id == R.id.tables) {
            pos=8;
            htmlFilename = "WEEK7tables.htm";
            set();
        } else if (id == R.id.background) {
            pos=9;
            htmlFilename = "WEEK8background,media.htm";
            set();
        } else if (id == R.id.frames) {
            pos=10;
            htmlFilename = "WEEK9frames.htm";
            set();
        }
        else if (id == R.id.forms) {
            pos=11;
            htmlFilename = "WEEK10forms.htm";
            //htmlFilename = "research/1.htm";
            set();
        } else if (id == R.id.nav_share) {
            pos=12;
            htmlFilename = "CSS/CSS.html";
            set();
        }
        else if (id == R.id.nav_send) {
            pos=13;
            htmlFilename = "js/JavaScript.html";
            set();
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
