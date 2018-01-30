package com.example.biadovskii_ei.webview1_old;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
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
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Туристический потенциал");
        setSupportActionBar(toolbar);

        // init webView
        WebView myWebView = (WebView) findViewById(R.id.web2);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        //improve webview perfomance
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        //load page in webView
        if (savedInstanceState == null)
        {
            myWebView.loadUrl("file:///android_asset/potential/index.html");
        }
        // creating Back method for floating button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView myWebView = (WebView) findViewById(R.id.web2);
                if (myWebView.canGoBack()){
                    myWebView.goBack();
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView myWebView = (WebView) findViewById(R.id.web2);
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        WebView myWebView = (WebView) findViewById(R.id.web2);
        if (id == R.id.imap) {
            myWebView.loadUrl("file:///android_asset/potential/index.html");
        } else if (id == R.id.a1) {
            myWebView.loadUrl("file:///android_asset/potential/aleksandrovskij-rajon/index.html");
        } else if (id == R.id.v1) {
            myWebView.loadUrl("file:///android_asset/potential/vladimir/index.html");
        } else if (id == R.id.v2) {
            myWebView.loadUrl("file:///android_asset/potential/vyaznikovskij-rajon/index.html");
        } else if (id == R.id.g1) {
            myWebView.loadUrl("file:///android_asset/potential/goroxoveczkij-rajon/index.html");
        } else if (id == R.id.g2) {
            myWebView.loadUrl("file:///android_asset/potential/gus-xrustalnyij-rajon/index.html");
        } else if (id == R.id.k1) {
            myWebView.loadUrl("file:///android_asset/potential/kolchuginskij-rajon/index.html");
        } else if (id == R.id.k2) {
            myWebView.loadUrl("file:///android_asset/potential/kameshkovskij-rajon/index.html");
        } else if (id == R.id.k3) {
            myWebView.loadUrl("file:///android_asset/potential/kirzhachskij-rajon/index.html");
        } else if (id == R.id.k4) {
            myWebView.loadUrl("file:///android_asset/potential/kovrovskij-rajon/index.html");
        } else if (id == R.id.m1) {
            myWebView.loadUrl("file:///android_asset/potential/melenkovskij-rajon/index.html");
        } else if (id == R.id.m2) {
            myWebView.loadUrl("file:///android_asset/potential/muromskij-rajon/index.html");
        } else if (id == R.id.p1) {
            myWebView.loadUrl("file:///android_asset/potential/petushinskij-rajon/index.html");
        } else if (id == R.id.s1) {
            myWebView.loadUrl("file:///android_asset/potential/selivanovskij-rajon/index.html");
        } else if (id == R.id.s2) {
            myWebView.loadUrl("file:///android_asset/potential/sobinskij-rajon/index.html");
        } else if (id == R.id.s3) {
            myWebView.loadUrl("file:///android_asset/potential/sudogodskij-rajon/index.html");
        } else if (id == R.id.s4) {
            myWebView.loadUrl("file:///android_asset/potential/suzdalskij-rajon/index.html");
        } else if (id == R.id.u1) {
            myWebView.loadUrl("file:///android_asset/potential/yurev-polskij-rajon/index.html");
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void onSaveInstanceState(Bundle outState )
    {
        WebView myWebView = (WebView) findViewById(R.id.web2);
        super.onSaveInstanceState(outState);
        myWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        WebView myWebView = (WebView) findViewById(R.id.web2);
        super.onRestoreInstanceState(savedInstanceState);
        myWebView.restoreState(savedInstanceState);
    }

}
