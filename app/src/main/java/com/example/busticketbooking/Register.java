package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText email,pass,copass,number,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void re_register(View view) {
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        copass=findViewById(R.id.copass);
        number=findViewById(R.id.num);
        if(copass.getText().toString().equals(pass.getText().toString())){
            BackgroundWorker bw=new BackgroundWorker(Register.this);
            bw.execute("register",email.getText().toString(),pass.getText().toString(),number.getText().toString(),name.getText().toString());
        }
        else{
            Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show();
        }
    }
}