package com.example.moham.portfolio_2;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class new_recipe extends AppCompatActivity {

    GridLayout gridlayout1;
    EditText etName, etDesc, etSteps, etRating;
    ImageView ivRecipe;
    Button btnAdd;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

//TEXTFIELD RETRIEVAL AND SAVING
        etName = findViewById(R.id.etRecName);
        etDesc = findViewById(R.id.etdesc);
        etSteps = findViewById(R.id.etSteps);
        etRating = findViewById(R.id.etDifficulty);
        btnAdd = findViewById(R.id.btnAdd);
        ivRecipe = findViewById(R.id.imageViewrECIPE);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String Desc = etDesc.getText().toString();
                String steps = etSteps.getText().toString();
                int rating = Integer.parseInt(etRating.getText().toString());


                Intent newRecIntent = new Intent();
                newRecIntent.putExtra("name",name);
                newRecIntent.putExtra("desc",Desc);
                newRecIntent.putExtra("steps",steps);
                newRecIntent.putExtra("rating",rating);
                setResult(RESULT_OK,newRecIntent);
                finish();




            }
        });

//GRID LAYOUT MENU
        gridlayout1 = findViewById(R.id.mainGrid);
        setToggleEvent(gridlayout1);
    }
    private void setToggleEvent(GridLayout mainGrid){
        for(int i =0; i < mainGrid.getChildCount();i++){
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int cardPos = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardPos == 0){
                        Intent myIntent = new Intent(new_recipe.this, homePage.class);
                        new_recipe.this.startActivity(myIntent);
                    }else if(cardPos == 2){
                        Intent myIntent = new Intent(new_recipe.this, settings_page.class);
                        new_recipe.this.startActivity(myIntent);

                    }
                }
            });
        }

    }


}
