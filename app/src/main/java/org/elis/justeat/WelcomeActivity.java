package org.elis.justeat;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

private static final String TAG = "WelcomeActivity";

TextView welcomeTV;
String email;
String openedEmail;
RecyclerView recyclerView;
LinearLayoutManager layoutManager;
FoodListAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        TextView welcomeTW= findViewById(R.id.welcome_tv);

        String mail= getIntent().getStringExtra(MainActivity.WELCOME);

        welcomeTW.setText(getString(R.string.welcome)+" "+mail);

        layoutManager = new LinearLayoutManager(this);

        ArrayList<food> foodList = new ArrayList<>();
        foodList.add(new food("milk","1.00", "1"));
        foodList.add(new food("bread","0.50", "1"));
        foodList.add(new food("juice","1.50", "1"));
        foodList.add(new food("pizza","4.00", "1"));

        adapter = new FoodListAdapter(this,foodList);



        recyclerView = findViewById(R.id.food_rv);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        if (getIntent().getStringExtra("EMAIL") != null){
            email= getIntent().getStringExtra("EMAIL");
            welcomeTV.setText(email);
        }
        else if(getIntent().getData() != null){
            openedEmail=getIntent().getData().toString().substring(7);
            welcomeTV.setText(openedEmail);
        }
    }

    public void sendEmail(View view){
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",getIntent().getStringExtra("EMAIL"), null));
        startActivity(Intent.createChooser(i, "Choose an Email client :"));
    }

    @Override
    public void onClick(View view) {
     if(view.getId()==R.id.welcome_tv){
         sendEmail(this.welcomeTV);
     }
    }
}
