package com.bis.ca2is4448.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bis.ca2is4448.Dialogs.DialogFortheWorldTotalCovid19cases;
import com.bis.ca2is4448.Dialogs.DialogforTheboysHeroImage;
import com.bis.ca2is4448.Dialogs.DialogforTotalIrishCases;
import com.bis.ca2is4448.R;

public class MainCovidActivity extends AppCompatActivity {


   Button showallirishcases, showWorldtotalcases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_covid);


         showallirishcases = findViewById(R.id.btn_ShowallIrishCases);
         showWorldtotalcases = findViewById(R.id.btnworldTotal);



        //creating a clickable help popup to help users
        //https://www.youtube.com/watch?v=Bsm-BlXo2SI
        Button btninforworld = (Button) findViewById(R.id.btnInfoWorldCasses);
        btninforworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogworldcases();
            }
        });



        //creating a clickable help popup to help users
        //https://www.youtube.com/watch?v=Bsm-BlXo2SI
        Button btnIrishcases = (Button) findViewById(R.id.btnIirhscases);
        btnIrishcases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogallIrishCasses();
            }
        });


        showallirishcases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainCovidActivity.this,CovidStatsActivity.class);
                startActivity(intent);
            }
        });


        showWorldtotalcases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainCovidActivity.this,WorldTotalCovidStats.class);
                startActivity(intent);
            }
        });

    }

    //reference https://www.youtube.com/watch?v=Bsm-BlXo2SI
    //for showing info on the class finder
    public void openDialogallIrishCasses(){
        DialogforTotalIrishCases dialogforTheboysHeroImage = new DialogforTotalIrishCases();
        dialogforTheboysHeroImage.show(getSupportFragmentManager(), "Heros info");
    }


    //reference https://www.youtube.com/watch?v=Bsm-BlXo2SI
    //for showing info on the class finder
    public void openDialogworldcases(){
        DialogFortheWorldTotalCovid19cases dialogforworld = new DialogFortheWorldTotalCovid19cases();
        dialogforworld.show(getSupportFragmentManager(), "Heros info");
    }

}