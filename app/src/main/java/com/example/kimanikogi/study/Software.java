package com.example.kimanikogi.study;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.MotionEvent;
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
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class Software extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
int pos=1;
    String htmlFilename = "one1.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_software);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        set();
        WebView htmlWebView = (WebView)findViewById(R.id.webView);

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
            case 1:
                pos=1;
                htmlFilename = "one1.html";
                set();
                break;
            case 2:
                pos=2;
                htmlFilename = "two1.html";
                set();
                break;
            case 3:
                pos=3;
                htmlFilename = "three1.html";
                set();
                break;
            case 4:
                pos=4;
                htmlFilename = "four1.html";
                set();
                break;
            case 5:
                pos=5;
                htmlFilename = "five1.html";
                set();
                break;
            case 6:
                pos=6;
                htmlFilename = "one2.html";
                set();
                break;
            case 7:
                pos=7;
                htmlFilename = "two2.html";
                set();
                break;
            case 8:
                pos=8;
                htmlFilename = "three2.html";
                set();
                break;
            case 9:
                pos=9;
                htmlFilename = "four2.html";
                set();
                break;
            case 10:
                pos=10;
                htmlFilename = "six2.html";
                set();
                break;
            case 11:
                pos=11;
                htmlFilename = "one3.html";
                set();
                break;
            case 12:
                pos=12;
                htmlFilename = "two3.html";
                set();
                break;
            case 13:
                pos=13;
                htmlFilename = "three3.html";
                set();
                break;
            case 14:
                pos=14;
                htmlFilename = "four3.html";
                set();
                break;
            case 15:
                pos=15;
                htmlFilename = "one4.html";
                set();
                break;
            case 16:
                pos=16;
                htmlFilename = "two4.html";
                set();
                break;
            case 17:
                pos=17;
                htmlFilename = "three4.html";
                set();
                break;
            case 18:
                pos=18;
                htmlFilename = "four4.html";
                set();
                break;
            case 19:
                pos=19;
                htmlFilename = "five4.html";
                set();
                break;
            case 20:
                pos=20;
                htmlFilename = "six4.html";
                set();
                break;
            case 21:
                pos=21;
                htmlFilename = "one5.html";
                set();
                break;
            case 22:
                pos=22;
                htmlFilename = "two5.html";
                set();
                break;
            case 23:
                pos=23;
                htmlFilename = "three5.html";
                set();
                break;
            case 24:
                pos=24;
                htmlFilename = "four5.html";
                set();
                break;
            case 25:
                pos=25;
                htmlFilename = "one6.html";
                set();
                break;
            case 26:
                pos=26;
                htmlFilename = "two6.html";
                set();
                break;
            case 27:
                pos=27;
                htmlFilename = "three6.html";
                set();
                break;
            case 28:
                pos=28;
                htmlFilename = "four6.html";
                set();
                break;
            case 29:
                pos=29;
                htmlFilename = "five6.html";
                set();
                break;
            case 30:
                pos=30;
                htmlFilename = "one7.html";
                set();
                break;
            case 31:
                pos=31;
                htmlFilename = "two7.html";
                set();
                break;
            case 32:
                pos=32;
                htmlFilename = "three7.html";
                set();
                break;
            case 33:
                pos=33;
                htmlFilename = "four7.html";
                set();
                break;
            case 34:
                pos=34;
                htmlFilename = "five7.html";
                set();
                break;
            case 35:
                pos=35;
                htmlFilename = "six7.html";
                set();
                break;
            default:
                Toast.makeText(Software.this," End Reached ",Toast.LENGTH_SHORT).show();
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
      //  getMenuInflater().inflate(R.menu.software, menu);
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

        if (id == R.id.one1) {
            pos=1;
            htmlFilename = "one1.html";
            set();
        }
        else if (id == R.id.two1) {
            pos=2;
             htmlFilename = "two1.html";
            set();

        }
        else if (id == R.id.three1) {
            pos=3;
            htmlFilename = "three1.html";
            set();

        }
        else if (id == R.id.four1) {
            pos=4;
            htmlFilename = "four1.html";
            set();
        }
        else if (id == R.id.five1) {
            pos=5;
            htmlFilename = "five1.html";
            set();
        }
        if (id == R.id.one2) {
            pos=6;
            htmlFilename = "one2.html";
            set();
        }
        else if (id == R.id.two2) {
            pos=7;
            htmlFilename = "two2.html";
            set();

        }
        else if (id == R.id.three2) {
            pos=8;
            htmlFilename = "three2.html";
            set();

        }
        else if (id == R.id.four2) {
            pos=9;
            htmlFilename = "four2.html";
            set();
        }
        else if (id == R.id.five2) {
            pos=10;
            htmlFilename = "six2.html";
            set();
        }
        if (id == R.id.one3) {
            pos=11;
            htmlFilename = "one3.html";
            set();
        }
        else if (id == R.id.two3) {
            pos=12;
            htmlFilename = "two3.html";
            set();

        }
        else if (id == R.id.three3) {
            pos=13;
            htmlFilename = "three3.html";
            set();

        }
        else if (id == R.id.four3) {
            pos=14;
            htmlFilename = "four3.html";
            set();
        }

        if (id == R.id.one4) {
            pos=15;
            htmlFilename = "one4.html";
            set();
        }
        else if (id == R.id.two4) {
            pos=16;
            htmlFilename = "two4.html";
            set();

        }
        else if (id == R.id.three4) {
            pos=17;
            htmlFilename = "three4.html";
            set();

        }
        else if (id == R.id.four3) {
            pos=18;
            htmlFilename = "four3.html";
            set();
        }
        else if (id == R.id.five4) {
            pos=19;
            htmlFilename = "five4.html";
            set();
        }
        else if (id == R.id.six4) {
            pos=20;
            htmlFilename = "six4.html";
            set();
        }
        if (id == R.id.one5) {
            pos=21;
            htmlFilename = "one5.html";
            set();
        }
        else if (id == R.id.two5) {
            pos=22;
            htmlFilename = "two5.html";
            set();

        }
        else if (id == R.id.three5) {
            pos=23;
            htmlFilename = "three5.html";
            set();

        }
        else if (id == R.id.four5) {
            pos=24;
            htmlFilename = "four5.html";
            set();
        }

        if (id == R.id.one6) {
            pos=25;
            htmlFilename = "one6.html";
            set();
        }
        else if (id == R.id.two6) {
            pos=26;
            htmlFilename = "two6.html";
            set();

        }
        else if (id == R.id.three6) {
            pos=27;
            htmlFilename = "three6.html";
            set();

        }
        else if (id == R.id.four6) {
            pos=28;
            htmlFilename = "four6.html";
            set();
        }
        else if (id == R.id.five6) {
            pos=29;
            htmlFilename = "five6.html";
            set();
        }
        if (id == R.id.one7) {
            pos=30;
            htmlFilename = "one7.html";
            set();
        }
        else if (id == R.id.two7) {
            pos=31;
            htmlFilename = "two7.html";
            set();

        }
        else if (id == R.id.three7) {
            pos=32;
            htmlFilename = "three7.html";
            set();

        }
        else if (id == R.id.four7) {
            pos=33;
            htmlFilename = "four7.html";
            set();
        }
        else if (id == R.id.five7) {
            pos=34;
            htmlFilename = "five7.html";
            set();
        }
        else if (id == R.id.six7) {
            pos=35;
            htmlFilename = "six7.html";
            set();
        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
