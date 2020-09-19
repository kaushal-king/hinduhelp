package com.hindu.hinduhelp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class splashscreen extends AppCompatActivity {

    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        splash();
    }
public void splash(){
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            net();
            if (connected == false) {
                LayoutInflater li = getLayoutInflater();
                View layout = li.inflate(R.layout.tost,(ViewGroup) findViewById(R.id.toast));
                Toast t=new Toast(getApplicationContext());
                t.setDuration(Toast.LENGTH_SHORT);
                t.setView(layout);
                t.show();
                splash();



            } else {
                Intent i = new Intent(splashscreen.this, Loginactivity.class);
                startActivity(i);
                finish();
            }
        }
    }, 2000);
}

    public void net() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else {
            connected = false;
        }
    }

}