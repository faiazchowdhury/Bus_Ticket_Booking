package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Seats extends AppCompatActivity {
    String all_seats,route,time,coach,ss;
    String[] seats;
    int total_price;
    int price2;
    TextView selected_seats,price;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        Bundle in=getIntent().getExtras();
        String str=in.getString("seat_no");

        price2=in.getInt("per_price");
        price=findViewById(R.id.price);
        selected_seats=findViewById(R.id.seats_selected);
        ss="";
        if(str==null){}
        else{
            seats = str.split(",");
            for (String a : seats) {
                if(a==""){}
                else {
                    btn = findViewById(getResources().getIdentifier(a, "id", getPackageName()));
                    btn.setBackgroundColor(Color.parseColor("#DE0E0E"));
                }
            }
        }

    }

    public void btn_click(View view) {
        ColorDrawable buttonColor = (ColorDrawable) view.getBackground();
        int colorId = buttonColor.getColor();
        String i= String.valueOf(view.getId());
        Button b=findViewById(getResources().getIdentifier(i, "id", getPackageName()));
        if(colorId==Color.parseColor("#09D65E")){
            view.setBackgroundColor(Color.parseColor("#E8D60A"));
            if(ss==""){
                ss=b.getText().toString();
            }
            else{
                ss=ss+","+b.getText().toString();
            }
            ss=uload_selected_seats("add",ss,b.getText().toString());

        }
        else{
            if(colorId==Color.parseColor("#E8D60A")){
                view.setBackgroundColor(Color.parseColor("#09D65E"));
                ss=uload_selected_seats("no",ss,b.getText().toString());
            }
            else{

                Toast.makeText(this,"This seat is Already Booked!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String uload_selected_seats(String add, String ss, String s) {
        if(add=="add"){}
        else{
            String []splitted = ss.split(",");
            String snew="";
            for (String a : splitted) {
                if(a.equals(s)){}
                else{
                    if(snew==""){
                        snew=a;
                    }
                    else{
                        snew=snew+","+a;
                    }
                }
            }
            ss=snew;
        }
        String []splitted = ss.split(",");
        total_price=splitted.length*price2;
        price.setText("Price: " +total_price+" Tk");
        selected_seats.setText(ss);
        return ss;
    }

    public void confirmed(View view) {
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute("check_seats",ss, String.valueOf(total_price));
    }
}