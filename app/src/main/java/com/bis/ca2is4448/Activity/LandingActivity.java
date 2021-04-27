package com.bis.ca2is4448.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bis.ca2is4448.Dialogs.DialogforCovidImageonlandingpage;
import com.bis.ca2is4448.Dialogs.DialogforTheboysHeroImage;
import com.bis.ca2is4448.R;

public class LandingActivity extends AppCompatActivity {


    private ImageView cvew, theboys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        cvew = (ImageView) findViewById(R.id.ivcvwe);
        theboys = (ImageView) findViewById(R.id.ivtheboys);





        //creating a clickable help popup to help users
        //https://www.youtube.com/watch?v=Bsm-BlXo2SI
        Button btnInfotheboys = (Button) findViewById(R.id.btnHeroPopupIntent);
        btnInfotheboys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


        //creating a clickable help popup to help users
        //https://www.youtube.com/watch?v=Bsm-BlXo2SI
        Button btnInfoCovidLanding = (Button) findViewById(R.id.btnCovidPopuplandingpage);
        btnInfoCovidLanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogCovidlanding();
            }
        });






        //clickable images
        theboys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        cvew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingActivity.this,MainCovidActivity.class);
                startActivity(intent);
            }
        });




    }

    //reference https://www.youtube.com/watch?v=Bsm-BlXo2SI
    //for showing info on the class finder
    public void openDialog(){
        DialogforTheboysHeroImage dialogforTheboysHeroImage = new DialogforTheboysHeroImage();
        dialogforTheboysHeroImage.show(getSupportFragmentManager(), "Heros info");
    }

    //reference https://www.youtube.com/watch?v=Bsm-BlXo2SI
    //for showing info on the class finder
    public void openDialogCovidlanding(){
        DialogforCovidImageonlandingpage dialogfortotalIrish = new DialogforCovidImageonlandingpage();
        dialogfortotalIrish.show(getSupportFragmentManager(), "Covid Info");
    }



}