package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Cancellation extends AppCompatActivity {
    ListView ls;
    ArrayList<String> list;
    ArrayAdapter<String> adlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancellation);

        ls = findViewById(R.id.list2);
        list = new ArrayList<String>();
        adlist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ls.setAdapter(adlist);

        Intent in = getIntent();
        String info = in.getStringExtra("info1");
        if (info == null) {}
        else {
            String[] splitted = info.split("<br>");
            for (String a : splitted) {
                list.add(a);
            }
            adlist.notifyDataSetChanged();
            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String refund = "0";
                    String[] splitted = ls.getItemAtPosition(i).toString().split(" - ");
                    Calendar calendar = Calendar.getInstance();
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int month = calendar.get(Calendar.MONTH) + 1;
                    int year = calendar.get(Calendar.YEAR);
                    String[] ticket_date = splitted[3].split("/");
                    if (Integer.parseInt(ticket_date[2]) >= year) {
                        if (Integer.parseInt(ticket_date[1]) >= month) {
                            if (Integer.parseInt(ticket_date[0]) == day) {
                                refund = "0";
                            } else {
                                if (Integer.parseInt(ticket_date[0]) - day == 1) {
                                    double refundable_price_calculation = 0.5 * (Integer.parseInt(splitted[5]));
                                    refund = String.valueOf(refundable_price_calculation);
                                } else {
                                    if (Integer.parseInt(ticket_date[0]) - day > 1) {
                                        refund = String.valueOf(splitted[5]);
                                    } else {
                                        Toast.makeText(Cancellation.this, "This ticket is of past date! Cannot cancel this ticket!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        } else {
                            Toast.makeText(Cancellation.this, "This ticket is of past date! Cannot cancel this ticket!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Cancellation.this, "This ticket is of past date! Cannot cancel this ticket!", Toast.LENGTH_SHORT).show();
                    }
                    Intent in = new Intent(Cancellation.this, Cancel_ticket_number.class);
                    in.putExtra("ticket_no", splitted[0]);
                    in.putExtra("refund", refund);
                    Cancellation.this.startActivity(in);
                }
            });
        }
    }
}