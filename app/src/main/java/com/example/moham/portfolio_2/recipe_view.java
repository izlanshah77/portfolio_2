package com.example.moham.portfolio_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class recipe_view extends AppCompatActivity {
    TextView tvTitle, tvName, tvRating, tvDesc, tvSteps;
    ImageView ivFood;
    GridLayout gridlayout1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        tvTitle = findViewById(R.id.textGrid);
        tvName = findViewById(R.id.textRecName);
        tvRating = findViewById(R.id.textViewRating);
        tvDesc = findViewById(R.id.textRecDesc);
        tvSteps = findViewById(R.id.textRecSteps);
        ivFood = findViewById(R.id.ivFood);

        Intent intentRecieved = getIntent();
        String recname = intentRecieved.getStringExtra("name");
        tvTitle.setText(recname);
        tvName.setText(recname);
        String desc = intentRecieved.getStringExtra("desc");
        tvDesc.setText(desc);
        String steps = intentRecieved.getStringExtra("steps");
        tvSteps.setText(steps);
        int rating = intentRecieved.getIntExtra("rating",0);
        tvRating.setText("Difficulty Level: "+ Integer.toString(rating) + "/10");
        int img = intentRecieved.getIntExtra("image",0);
        ivFood.setImageResource(img);

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
                    if(cardPos == 1){
                        int requestCode = 1;
                        Intent intentPlus = new Intent(recipe_view.this,new_recipe.class);
                        recipe_view.this.startActivityForResult(intentPlus, requestCode);

                    }else if(cardPos == 2){
                        Intent myIntent = new Intent(recipe_view.this, settings_page.class);
                        recipe_view.this.startActivity(myIntent);

                    }else if(cardPos == 0){
                        Intent myIntent = new Intent(recipe_view.this, homePage.class);
                        recipe_view.this.startActivity(myIntent);
                    }
                }
            });
        }

    }
}
