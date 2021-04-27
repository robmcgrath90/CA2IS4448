package com.bis.ca2is4448.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bis.ca2is4448.Model.Hero;
import com.bis.ca2is4448.R;
import com.bis.ca2is4448.Remote.APIUtils;
import com.bis.ca2is4448.Remote.HeroService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditHeroActivity extends AppCompatActivity {
    EditText etName, etRealName, etID;
    Spinner spTeam;
    RatingBar rbHero;
    Button btnCancel, btnUpdate;
    HeroService heroService;
    String compareValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_hero);

        heroService = APIUtils.getHeroService();
        etName = findViewById(R.id.etUpdateName);
        etRealName = findViewById(R.id.etUpdateRealName);
        etID = findViewById(R.id.etHeroID);
        spTeam = findViewById(R.id.spTeamCreate);
        rbHero = findViewById(R.id.rbUpdateRating);
        btnCancel = findViewById(R.id.btnCancelUpdate);
        btnUpdate = findViewById(R.id.btnUpdateRecord);

        //Adapted from https://stackoverflow.com/a/4228121/15339465
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spTeam.setAdapter(adapter);


        //Getting extras on intent so the correct hero is updated
        Intent intent = getIntent();
        if(intent.hasExtra("name")) {
            etName.setText(intent.getStringExtra("name"));
            etRealName.setText(intent.getStringExtra("realname"));
            etID.setText(String.valueOf(intent.getIntExtra("id",0)));
            rbHero.setRating(intent.getIntExtra("rating",0));
            compareValue = intent.getStringExtra("team");

        }

        //https://stackoverflow.com/a/4228121/15339465
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spTeam.setSelection(spinnerPosition);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hero hero = new Hero(Integer.parseInt(String.valueOf(etID.getText().toString())),etName.getText().toString(),etRealName.getText().toString(), (int) rbHero.getRating(),spTeam.getSelectedItem().toString());
                //Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
                Call<Hero> call = heroService.updateHero(hero.getId(),hero.getName(),hero.getRealname(),hero.getRating(),hero.getTeamaffiliation(), hero.getId());
                call.enqueue(new Callback<Hero>() {
                    @Override
                    public void onResponse(Call<Hero> call, Response<Hero> response) {
                        if(!response.isSuccessful()) {
                            Toast.makeText(EditHeroActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(EditHeroActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(EditHeroActivity.this,MainActivity.class);
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
                Intent intent = new Intent(EditHeroActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
