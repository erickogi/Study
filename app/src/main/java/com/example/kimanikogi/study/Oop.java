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
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class Oop extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    int pos=1;
    String htmlFilename = "oop/intro.htm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oop);
        set();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
           // case 1:
           //     pos=1;
           //     htmlFilename = "http://beginnersbook.com/2013/04/oops-concepts/";
           //     set();
            //    break;
            case 1:
                pos=1;
                htmlFilename = "oop/intro.htm";
                set();
                break;
            case 2:
                pos=2;
                htmlFilename = "oop/Access.htm";
                set();
                break;
            case 3:
                pos=3;
                htmlFilename = "oop/encapsulation.htm";
                set();
                break;
            case 4:
                pos=4;
                htmlFilename = "oop/Inheritance.htm";
                set();
                break;
            case 5:
                pos=5;
                htmlFilename = "oop/Polymorphism.htm";
                set();
                break;
            case 6:
                pos=6;
                htmlFilename = "oop/InterfacesAbstract.htm";
                set();
                break;
            case 7:
                pos=7;
                htmlFilename = "oop/Constructor.htm";
                set();
                break;
            case 8:
                pos=8;
                htmlFilename = "oop/Message.htm";
                set();
                break;

            default:
                Toast.makeText(Oop.this," End Reached ",Toast.LENGTH_SHORT).show();
        }

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
       // getMenuInflater().inflate(R.menu.oop, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.intro) {
            pos=1;
            htmlFilename = "oop/intro.htm";
            set();
//        } else if (id == R.id.intro) {
//            pos=2;
//            htmlFilename = "oop/intro.htm";
//            set();
        } else if (id == R.id.access) {
            pos=2;
            htmlFilename = "oop/Access.htm";
            set();
        } else if (id == R.id.encapsulation) {
            pos=3;
            htmlFilename = "oop/encapsulation.htm";
            set();
        } else if (id == R.id.inheritance) {
            pos=4;
            htmlFilename = "oop/Inheritance.htm";
            set();
        } else if (id == R.id.polymo) {
            pos=5;
            htmlFilename = "oop/Polymorphism.htm";
            set();
        }
        else if (id == R.id.interfaces) {
            pos=6;
            htmlFilename = "oop/InterfacesAbstract.htm";
            set();
        }
        else if (id == R.id.constructor) {
            pos=7;
            htmlFilename = "oop/Constructor.htm";
            set();
        }
        else if (id == R.id.message) {
            pos=8;
            htmlFilename = "oop/Message.htm";
            set();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
