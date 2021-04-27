package com.bis.ca2is4448.Remote;

import com.bis.ca2is4448.Model.CovidStat;
import com.bis.ca2is4448.Model.CovidWorldTotal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
public interface CovidService {

    @GET("https://api.covid19api.com/live/country/ireland")
    Call<List<CovidStat>> getIrishCovidStats();


    @GET("https://api.covid19api.com/world")
    Call<List<CovidWorldTotal>> getWorldStats();



}
