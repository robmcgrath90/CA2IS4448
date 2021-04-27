package com.bis.ca2is4448.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bis.ca2is4448.Adapter.CovidRecyclerAdapter;
import com.bis.ca2is4448.Model.CovidStat;
import com.bis.ca2is4448.R;
import com.bis.ca2is4448.Remote.APIUtils;
import com.bis.ca2is4448.Remote.CovidService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidStatsActivity extends AppCompatActivity {

    RecyclerView rvCovid;
    CovidService covidService;
    CovidRecyclerAdapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<CovidStat> covidStatList = new ArrayList<>();
    FloatingActionButton fabHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_stats);

        rvCovid = findViewById(R.id.rvCovid);
        covidService = APIUtils.getCOVIDService();
        fabHero = findViewById(R.id.floatingActionButton);

        fabHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CovidStatsActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
        Call<List<CovidStat>> call = covidService.getIrishCovidStats();
        call.enqueue(new Callback<List<CovidStat>>() {
            @Override
            public void onResponse(Call<List<CovidStat>>call, Response<List<CovidStat>> response) {
                covidStatList = response.body();

                setupRecycler();


            }

            @Override
            public void onFailure(Call<List<CovidStat>> call, Throwable t) {

            }
        });



    }

    //took from this tutorial https://www.youtube.com/watch?v=FFCpjZkqfb0
    public void setupRecycler() {
        rvCovid.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(CovidStatsActivity.this);
        rvCovid.setLayoutManager(layoutManager);
        mAdapter = new CovidRecyclerAdapter(covidStatList,CovidStatsActivity.this);
        rvCovid.setAdapter(mAdapter);
    }

}