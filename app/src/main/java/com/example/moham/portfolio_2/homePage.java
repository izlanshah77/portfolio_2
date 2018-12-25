package com.example.moham.portfolio_2;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioFocusRequest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class homePage extends AppCompatActivity {

    ListView lvRecipe;
    ArrayList<Recipe> alRecipe;
    GridLayout gridlayout1;
    CustomAdapter caRecipe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//HOMEPAGE LISTVIEW STUFF
        alRecipe = new ArrayList<>();
        lvRecipe = (ListView) findViewById(R.id.lvRecipe);
        Recipe recipe1 = new Recipe("Steak", "yummy", "1.cook 2.eat", 3, R.drawable.foodpic1);
        Recipe recipe2 = new Recipe("Fried Rice","this is a description","1.cook, 2.eat",3,R.drawable.foodpic2);
        Recipe recipe3 = new Recipe("Roast Chicken","this is a description","1.cook, 2.eat",5,R.drawable.foodpic3);
        Recipe recipe4 = new Recipe("Pho","this is a description","1.cook, 2.eat",5,R.drawable.foodpic4);
        Recipe recipe5 = new Recipe("Pan Seared Salmon","this is a description","1.cook, 2.eat",5,R.drawable.foodpic5);
        Recipe recipe6 = new Recipe("Mac 'N' Cheese","this is a description","1.cook, 2.eat",5,R.drawable.foodpic6);
        alRecipe.add(recipe1);
        alRecipe.add(recipe2);
        alRecipe.add(recipe3);
        alRecipe.add(recipe4);
        alRecipe.add(recipe5);
        alRecipe.add(recipe6);
        caRecipe = new CustomAdapter(this , R.layout.recipe_layout, alRecipe);
        lvRecipe.setAdapter(caRecipe);


//HOMEPAGE GRID MENU STUFF
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
                        Intent intentPlus = new Intent(homePage.this,new_recipe.class);
                        homePage.this.startActivityForResult(intentPlus, requestCode);

                    }else if(cardPos == 2){
                        Intent myIntent = new Intent(homePage.this, settings_page.class);
                        homePage.this.startActivity(myIntent);

                    }
                }
            });
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {

            if (data != null) {
                Recipe a=new Recipe(data.getStringExtra("name"),data.getStringExtra("desc"),data.getStringExtra("steps"),data.getIntExtra("rating",0),R.drawable.plus1);
                alRecipe.add(a);
                caRecipe.notifyDataSetChanged();
            }

        }

    }

}

