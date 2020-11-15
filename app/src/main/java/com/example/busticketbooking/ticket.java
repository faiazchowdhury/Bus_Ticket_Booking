package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ticket extends AppCompatActivity {
    TextView tickte_no,email,number,date,time,route,coach,seats,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        tickte_no=findViewById(R.id.ticket_no);
        email=findViewById(R.id.email);
        number=findViewById(R.id.number);
        date=findViewById(R.id.date2);
        time=findViewById(R.id.time);
        route=findViewById(R.id.route);
        coach=findViewById(R.id.coach);
        price=findViewById(R.id.price);
        seats=findViewById(R.id.seats);

        Intent news=getIntent();

        tickte_no.setText("Ticket No.: "+news.getStringExtra("ticket_id"));
        email.setText("Email of Booking Customer: "+news.getStringExtra("pemail"));
        date.setText("Date of Travel: "+news.getStringExtra("pdate"));
        time.setText("Time of Departure: "+news.getStringExtra("ptime"));
        route.setText("Route of Travel: "+news.getStringExtra("proute"));
        coach.setText("Type of Coach: "+news.getStringExtra("pcoach"));
        price.setText("Price of Ticket: "+news.getStringExtra("pprice"));
        seats.setText("Seats Booked: "+news.getStringExtra("pseats"));
        number.setText("Number with which payment was made: "+news.getStringExtra("pnum"));
    }

    public void goback(View view) {
        Intent in=new Intent(this,HomePage.class);
        this.startActivity(in);
    }
}