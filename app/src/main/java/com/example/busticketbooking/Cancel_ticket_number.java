package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Cancel_ticket_number extends AppCompatActivity {
    TextView refund,texted;
    EditText number_taken;
    String ticket_number,refundvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_ticket_number);
        refund=findViewById(R.id.refund);
        texted=findViewById(R.id.texted);
        number_taken=findViewById(R.id.number_taken);
        Intent in=getIntent();
        ticket_number=in.getStringExtra("ticket_no");
        refundvalue=in.getStringExtra("refund");
        if(refundvalue.equals("0")){
            refund.setText("No Refund is Available");
            texted.setText("**Enter your contact number");
        }
        else{
            refund.setText("Refund Recievable: "+refundvalue+" Tk");
            texted.setText("**Enter Bkash number at which refund will be recieved");
        }
    }

    public void confirm_cancellation(View view) {
        if(TextUtils.isEmpty(number_taken.getText())){
            number_taken.setError("Must enter number!");
        }
        else{
            BackgroundWorker backgroundWorker=new BackgroundWorker(Cancel_ticket_number.this);
            backgroundWorker.execute("cancel_ticket",ticket_number, refundvalue,number_taken.getText().toString());
        }
    }
}