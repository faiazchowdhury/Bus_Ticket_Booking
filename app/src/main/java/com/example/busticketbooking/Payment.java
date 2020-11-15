package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Payment extends AppCompatActivity {
    EditText number;
    TextView amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        amount=findViewById(R.id.ampaid);
        number=findViewById(R.id.number);
        String price = "";
        Intent in=getIntent();
        price=in.getStringExtra("price");
        amount.setText(price+" Tk");
    }

    public void proceed(View view) {
        number=findViewById(R.id.number);
        if(TextUtils.isEmpty(number.getText())){
            number.setError("Bkash Number with which payment was made is required to Proceed");
        }
        else{
            BackgroundWorker bk=new BackgroundWorker(this);
            bk.execute("payment_made",number.getText().toString());
        }
    }
}