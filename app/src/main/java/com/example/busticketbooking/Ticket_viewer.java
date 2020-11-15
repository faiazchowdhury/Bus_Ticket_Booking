package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ticket_viewer extends AppCompatActivity {
    ListView ls;
    ArrayList<String> list;
    ArrayAdapter<String> adlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_viewer);
        ls = findViewById(R.id.list);
        list = new ArrayList<String>();
        adlist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ls.setAdapter(adlist);

        Intent in = getIntent();
        String info = in.getStringExtra("info");
        if (info == null) {
        }
        else {
            String[] splitted = info.split("<br>");
            for (String a : splitted) {
                list.add(a);
            }
            adlist.notifyDataSetChanged();
            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String []temp=ls.getItemAtPosition(i).toString().split(" - ");
                    BackgroundWorker backgroundWorker=new BackgroundWorker(Ticket_viewer.this);
                    backgroundWorker.execute("viewing",temp[0]);

                }
            });
        }
    }
}