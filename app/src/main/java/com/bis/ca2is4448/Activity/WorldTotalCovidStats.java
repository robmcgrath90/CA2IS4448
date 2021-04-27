package com.bis.ca2is4448.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bis.ca2is4448.Adapter.CovidRecyclerAdapter;
import com.bis.ca2is4448.Adapter.WorldCovidAdapter;
import com.bis.ca2is4448.Model.CovidStat;
import com.bis.ca2is4448.Model.CovidWorldTotal;
import com.bis.ca2is4448.R;
import com.bis.ca2is4448.Remote.APIUtils;
import com.bis.ca2is4448.Remote.CovidService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorldTotalCovidStats extends AppCompatActivity {

    RecyclerView rvCovidw;
    CovidService covidService;
    WorldCovidAdapter mAdapterW;
    RecyclerView.LayoutManager layoutManager;
    List<CovidWorldTotal> WorldStatList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_total_covid_stats);

        rvCovidw = findViewById(R.id.rvCovidWorldTotal);
        covidService = APIUtils.getCOVIDService();



        //Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
        Call<List<CovidWorldTotal>> call = covidService.getWorldStats();
        call.enqueue(new Callback<List<CovidWorldTotal>>() {
            @Override
            public void onResponse(Call<List<CovidWorldTotal>>call, Response<List<CovidWorldTotal>> response) {
                WorldStatList = response.body();

                setupRecycler();


            }

            @Override
            public void onFailure(Call<List<CovidWorldTotal>> call, Throwable t) {

            }
        });


    }


    //took from this tutorial https://www.youtube.com/watch?v=FFCpjZkqfb0
    public void setupRecycler() {

        rvCovidw.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(WorldTotalCovidStats.this);
        rvCovidw.setLayoutManager(layoutManager);
        mAdapterW = new WorldCovidAdapter(WorldStatList,WorldTotalCovidStats.this);
        rvCovidw.setAdapter(mAdapterW);
    }


}