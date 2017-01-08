package com.example.kimanikogi.study;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String txt = null;
    Toolbar toolbar;

    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;

    CoordinatorLayout rootLayoutAndroid;

    GridView gridView;

    Context context;
    ImageView imageView;
    final Context context1 = this;
    ArrayList arrayList;
    public static String[] gridViewStrings = {

            "SoftWare Eng..",

            "OOP..",

            "Web Design",

            "Data Structure",

            "MIS",

            "Preservation",

            "Media",

            "Research ",

            "Extra's",


    };

    public static int[] gridViewImages = {

            R.drawable.se,

            R.drawable.oop,

            R.drawable.web,

            R.drawable.dsa,

            R.drawable.mis,

            R.drawable.preserve,

            R.drawable.media,

            R.drawable.research,

            R.drawable.images,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        gridView = (GridView) findViewById(R.id.grid);

        gridView.setAdapter(new CustomAndroidGridViewAdapter(this, gridViewStrings, gridViewImages));


        initInstances();
        //imageView=(ImageView)findViewById(R.id.grid_image);
        //imageView.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //   public void onClick(View v) {

        //  }
        // });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //Software.setText(String.valueOf(R.string.chapter));


                    Intent two = new Intent(MainActivity.this, Software.class);
                    startActivity(two);

                    // Toast.makeText(MainActivity.this,position +" Clicked ",Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Intent two = new Intent(MainActivity.this, Oop.class);
                    startActivity(two);
                   // dialog();
                } else if (position == 2) {
                    dialogweb();
                } else if (position == 3) {
                    Intent two = new Intent(MainActivity.this,data.class);
                    startActivity(two);
                    //   Toast.makeText(MainActivity.this,position +" Clicked ",Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Intent two = new Intent(MainActivity.this,Mis.class);
                    startActivity(two);

                    // Toast.makeText(MainActivity.this,position +" Clicked ",Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Intent two = new Intent(MainActivity.this, preservation.class);
                    startActivity(two);


                } else if (position == 6) {
                    Intent two = new Intent(MainActivity.this, Radio.class);
                    startActivity(two);
                    // dialog();
                    //  Toast.makeText(MainActivity.this,position +" Clicked ",Toast.LENGTH_SHORT).show();
                } else if (position == 7) {
                    Intent two = new Intent(MainActivity.this, research.class);
                    startActivity(two);
                    //Toast.makeText(MainActivity.this,position +" Clicked ",Toast.LENGTH_SHORT).show();
                } else if (position == 8) {
                    Intent two = new Intent(MainActivity.this, Others.class);
                    startActivity(two);
                    // Toast.makeText(MainActivity.this,position +" Clicked ",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void dialog() {
        final Dialog dialog = new Dialog(context1);
        dialog.setContentView(R.layout.dialog);
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent two = new Intent(MainActivity.this, send.class);
                startActivity(two);
            }
        });
        Button dialogButtonc = (Button) dialog.findViewById(R.id.dialogButtonCancel);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();
    }

    public void dialogweb() {
        final Dialog dialog = new Dialog(context1);
        dialog.setContentView(R.layout.dialogweb);
        dialog.setTitle("CHOOSE WHAT TO READ");
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent two = new Intent(MainActivity.this, webdevper.class);
                startActivity(two);
                //dialog.finish();
                dialog.dismiss();
            }
        });
        Button dialogButtonc = (Button) dialog.findViewById(R.id.dialogButtonCancel);
        // if button is clicked, close the custom dialog
        dialogButtonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent two = new Intent(MainActivity.this, webdevlec.class);
                startActivity(two);
                dialog.dismiss();
                // finish();

            }
        });
        dialog.show();
    }

    private void initInstances() {

        rootLayoutAndroid = (CoordinatorLayout) findViewById(R.id.android_coordinator_layout);

        collapsingToolbarLayoutAndroid = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);

        collapsingToolbarLayoutAndroid.setTitle("   Welcome");

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
        getMenuInflater().inflate(R.menu.main, menu);
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
            Toast.makeText(MainActivity.this, " For settings, -> Swipe your finger from left end to right on the screen-> ", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //if (id == R.id.nav_camera) {
        // Handle the camera action
        //  }
        if (id == R.id.nav_gallery) {
            Toast toast = Toast.makeText(this, "KogiE & Kiki", Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.nav_slideshow) {
            Intent two = new Intent(MainActivity.this, about.class);
            startActivity(two);
        } else if (id == R.id.upload) {
            Intent two = new Intent(MainActivity.this, File.class);
            startActivity(two);

        } else if (id == R.id.view) {
            Intent two = new Intent(MainActivity.this, ViewAss.class);
            startActivity(two);

        }
        else if (id == R.id.timetable) {
            Intent two = new Intent(MainActivity.this, timetable.class);
            startActivity(two);

        }
        else if (id == R.id.welcome) {
            PrefManager prefManager = new PrefManager(getApplicationContext());

            // make first time launch TRUE
            prefManager.setFirstTimeLaunch(true);
            Intent tw = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(tw);

        } else if (id == R.id.nav_share) {
            Intent in = new Intent();
            in.setAction(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_TEXT, " STUDY APP:Full version now available" +
                    "http://www.erickogi.co.ke/apps/study.apk");
            in.setType("text/plain");
            startActivity(in);
            return true;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    int t=0;
    public void date() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date strDate = null;
        try {
            strDate = sdf.parse("11/27/2016");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (System.currentTimeMillis() == strDate.getTime()) {
            t = 1;


        }
    }
}