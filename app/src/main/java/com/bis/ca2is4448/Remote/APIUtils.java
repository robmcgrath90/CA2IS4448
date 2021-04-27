package com.bis.ca2is4448.Remote;

//Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
public class APIUtils {

    public static final String API_URL = "https://gleeson.io/IS4447/HeroAPI/v1/";
    public static final String COVID_URL = "https://api.covid19api.com/live/country/";

    public static HeroService getHeroService(){
        return RetrofitClient.getClient(API_URL).create(HeroService.class);
    }

    public static CovidService getCOVIDService(){
        return RetrofitClient.getClient(COVID_URL).create(CovidService.class);
    }

}
