package com.example.newspaperdistribution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void btnClickShowDeliveryJobMap(View v)
    {
        Intent x = new Intent(this, DeliveryMap.class);
        startActivity(x);
    }
    public void btnDeliveryHistory(View v)
    {
       Intent o = new Intent(this,DeliveryHistory.class);
        startActivity(o);
    }

}