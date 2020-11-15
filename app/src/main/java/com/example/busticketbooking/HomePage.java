package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void hp_book(View view) {
        Intent in=new Intent(this,Book.class);
        this.startActivity(in);
    }

    public void hp_cancel(View view) {
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute("cancellation");
    }

    public void hp_view(View view) {
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute("view_ticket");

    }
}