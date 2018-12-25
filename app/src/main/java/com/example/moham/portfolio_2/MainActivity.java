package com.example.moham.portfolio_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etPass;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking stuff
        etName = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Toast.makeText(MainActivity.this,"Signed in as " + name,Toast.LENGTH_LONG ).show();
                Intent myintent = new Intent(MainActivity.this,homePage.class);
                MainActivity.this.startActivity(myintent);


            }
        });

    }
}
