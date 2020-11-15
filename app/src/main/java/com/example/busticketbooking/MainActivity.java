package com.example.busticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void lg_btnclick(View view) {
        email=findViewById(R.id.lgn_name);
        pass=findViewById(R.id.lgn_pass);
        BackgroundWorker bw=new BackgroundWorker(MainActivity.this);
        bw.execute("login",email.getText().toString(),pass.getText().toString());
    }

    public void lg_register(View view) {
        Intent in=new Intent(this,Register.class);
        this.startActivity(in);
    }
}