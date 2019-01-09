package com.example.moham.portfolio_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.graphics.ColorSpace.Model.XYZ;

public class settings_page extends AppCompatActivity {

    GridLayout gridlayout1;
    TextView tvColor;
    Spinner spnLang;
    Button btnLogOut;
    LinearLayout settingsView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        tvColor = findViewById(R.id.textViewChangeColor);
        spnLang = findViewById(R.id.spinnerLang);
        btnLogOut = findViewById(R.id.buttonLogOut);

        registerForContextMenu(tvColor);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnLang.setAdapter(adapter);

        spnLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 1:
                        String languageToLoad  = "en";
                        Locale locale = new Locale(languageToLoad);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        Context context = settings_page.this;
                        context.getResources().updateConfiguration(config,context.getResources().getDisplayMetrics());

                        Intent intent = new Intent(settings_page.this, homePage.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);


                        break;
                    case 2:
                        String languageToLoad1  = "ms";
                        Locale locale1 = new Locale(languageToLoad1);
                        Locale.setDefault(locale1);
                        Configuration config1 = new Configuration();
                        config1.locale = locale1;
                        Context context1 = settings_page.this;
                        context1.getResources().updateConfiguration(config1,context1.getResources().getDisplayMetrics());

                        Intent intent1 = new Intent(settings_page.this, homePage.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(settings_page.this);
                myBuilder.setTitle("Sign Out?");
                myBuilder.setMessage("Click 'Yes' to Sign Out");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Sign Out", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(settings_page.this,"Signed Out",Toast.LENGTH_LONG ).show();
                        Intent myIntent = new Intent(settings_page.this, MainActivity.class);
                        settings_page.this.startActivity(myIntent);

                    }
                });
                myBuilder.setNeutralButton("Cancel",null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });



        gridlayout1 = findViewById(R.id.mainGrid);
        setToggleEvent(gridlayout1);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Light");
        menu.add(0,1,1,"Dark");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0){
            settingsView = findViewById(R.id.settingsView);
            settingsView.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        else{
            settingsView = findViewById(R.id.settingsView);
            settingsView.setBackgroundColor(Color.parseColor("#030303"));
        }
        return false;
    }

    private void setToggleEvent(GridLayout mainGrid){
        for(int i =0; i < mainGrid.getChildCount();i++){
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int cardPos = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardPos == 0){
                        Intent myIntent = new Intent(settings_page.this, homePage.class);
                        settings_page.this.startActivity(myIntent);
                    }else if(cardPos == 1){
                        Intent myIntent = new Intent(settings_page.this, new_recipe.class);
                        settings_page.this.startActivity(myIntent);
                    }
                }
            });
        }

    }
}
