package com.darshan.lift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class riderregister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riderregister);

        Spinner vehicle = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(riderregister.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vehicle));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicle.setAdapter(myAdapter);
    }


    public void service(View view) {
        Intent intent = new Intent(this,Chooseservice.class);
        startActivity(intent);
    }
}
