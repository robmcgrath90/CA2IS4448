package com.bis.ca2is4448.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.bis.ca2is4448.Model.Hero;
import com.bis.ca2is4448.R;
import com.bis.ca2is4448.Remote.APIUtils;
import com.bis.ca2is4448.Remote.HeroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateHeroActivity extends AppCompatActivity {


    EditText etName, etRealName;
    Spinner spTeam;
    RatingBar rbRating;
    HeroService heroService;
    Button btnAdd, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_hero);

        heroService = APIUtils.getHeroService();
        etName = findViewById(R.id.etCreateName);
        etRealName = findViewById(R.id.etCreateRealName);
        spTeam = findViewById(R.id.spTeamCreate);
        rbRating = findViewById(R.id.rbCreateRating);
        btnAdd = findViewById(R.id.btnCreateRecord);
        btnCancel = findViewById(R.id.btnCancelCreate);


        //https://stackoverflow.com/a/13449622/15339465
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spTeam.setAdapter(adapter);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
                Call<Hero> call = heroService.addHero(etName.getText().toString(),etRealName.getText().toString(), (int) rbRating.getRating(),spTeam.getSelectedItem().toString());
                call.enqueue(new Callback<Hero>() {
                    @Override
                    public void onResponse(Call<Hero> call, Response<Hero> response) {
                        if(!response.isSuccessful()) {
                            Toast.makeText(CreateHeroActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(CreateHeroActivity.this, "Hero Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CreateHeroActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Hero> call, Throwable t) {

                    }
                });
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateHeroActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}