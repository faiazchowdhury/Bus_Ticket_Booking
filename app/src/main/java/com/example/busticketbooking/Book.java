package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Book extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView dateText;
    RadioGroup rg;
    String date,coach,route,time;
    Spinner sp, sptime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        rg=findViewById(R.id.rg);
        coach="AC";

        sp=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> ad=ArrayAdapter.createFromResource(this,R.array.route,android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(this);

        sptime=findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> ad2=ArrayAdapter.createFromResource(this,R.array.time,android.R.layout.simple_spinner_item);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sptime.setAdapter(ad2);
        sptime.setOnItemSelectedListener(this);

        Calendar calendar=Calendar.getInstance();
        final int day= calendar.get(Calendar.DAY_OF_MONTH);
        final int month=calendar.get(Calendar.MONTH);
        final int year=calendar.get(Calendar.YEAR);
        dateText=findViewById(R.id.date2);
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Book.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        int checker=Integer.valueOf(month)+1;
                        String fdate=day+"/"+checker+"/"+year;
                        date=fdate;
                        dateText.setText(fdate);
                    }
                },year,month,day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()+1000000000);
                datePickerDialog.show();
            }
        });
    }

    public void radiocheck(View view) {
        int radio_id=rg.getCheckedRadioButtonId();
        if(radio_id==findViewById(R.id.ac).getId()){
            coach="AC";
        }
        else{
            coach="NON-AC";
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView==sp){
            route=adapterView.getItemAtPosition(i).toString();
        }
        else {
            time=adapterView.getItemAtPosition(i).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void btn_clicked(View view) {
        if(TextUtils.isEmpty(dateText.getText())){
            dateText.setError("Date is Required!");
        }
        else{
            /*Intent in=new Intent(Book.this,Seats.class);
            in.putExtra("date",date);
            in.putExtra("time",time);
            in.putExtra("route",route);
            in.putExtra("coach",coach);
            this.startActivity(in);*/
            BackgroundWorker backgroundWorker=new BackgroundWorker(this);
            backgroundWorker.execute("seats",date,time,coach,route);
        }
    }
}