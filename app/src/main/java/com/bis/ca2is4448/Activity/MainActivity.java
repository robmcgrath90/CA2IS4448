package com.bis.ca2is4448.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bis.ca2is4448.Adapter.HeroRecyclerAdapter;
import com.bis.ca2is4448.Model.Hero;
import com.bis.ca2is4448.Model.JSONResponseModel;
import com.bis.ca2is4448.R;
import com.bis.ca2is4448.Remote.APIUtils;
import com.bis.ca2is4448.Remote.HeroService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etSearch;
    RecyclerView rvHeroes;
    HeroService heroService;
    HeroRecyclerAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton fabAdd, fabCovid;
    List<Hero> heroList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = findViewById(R.id.etSearch);
        rvHeroes = findViewById(R.id.rvHeroes);
        fabAdd = findViewById(R.id.fabAdd);
        fabCovid = findViewById(R.id.fabCovid);
        heroService = APIUtils.getHeroService();

        //Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
        Call<JSONResponseModel> call = heroService.getHeroes();
        call.enqueue(new Callback<JSONResponseModel>() {
            @Override
            public void onResponse(Call<JSONResponseModel> call, Response<JSONResponseModel> response) {
                JSONResponseModel hero = response.body();

                List<Hero> heroes = hero.getHeroes();
                heroList = heroes;
                setupRecycler();
                //This calls the filter created in the adapter using a listener for the edit text
                etSearch.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        mAdapter.getFilter().filter(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

            }

            @Override
            public void onFailure(Call<JSONResponseModel> call, Throwable t) {

            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateHeroActivity.class);
                startActivity(intent);
            }
        });

        fabCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainCovidActivity.class);
                startActivity(intent);
            }
        });

    }

    //Adapted from https://www.youtube.com/watch?v=FFCpjZkqfb0
    private void setupRecycler() {
        rvHeroes.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        rvHeroes.setLayoutManager(layoutManager);
        mAdapter = new HeroRecyclerAdapter(heroList,MainActivity.this);
        //new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(rvHeroList);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(rvHeroes);
        rvHeroes.setAdapter(mAdapter);
    }


    //Swipe code adapted from https://codinginflow.com/tutorials/android/firebaseui-firestorerecycleradapter/part-5-swipe-to-delete
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }



        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            if (direction == ItemTouchHelper.RIGHT) {

                int pos = viewHolder.getAdapterPosition();
                Hero hero = mAdapter.getHerofromRecycler(pos);
                mAdapter.notifyDataSetChanged();
                Intent intent = new Intent(MainActivity.this, EditHeroActivity.class);
                intent.putExtra("id", hero.getId());
                intent.putExtra("name", hero.getName());
                intent.putExtra("realname", hero.getRealname());
                intent.putExtra("rating", hero.getRating());
                intent.putExtra("team", hero.getTeamaffiliation());
                startActivity(intent);

            } else if (direction == ItemTouchHelper.LEFT) {

                int position = viewHolder.getAdapterPosition();

                Call<Hero> call = heroService.deleteHero(mAdapter.getHeroId(position));
                call.enqueue(new Callback<Hero>() {
                    @Override
                    public void onResponse(Call<Hero> call, Response<Hero> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                        }
                        heroList.remove(viewHolder.getAdapterPosition());
                        mAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Hero> call, Throwable t) {

                    }
                });



            }

        }

    };

}