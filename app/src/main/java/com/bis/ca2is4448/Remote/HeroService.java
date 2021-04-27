package com.bis.ca2is4448.Remote;

import com.bis.ca2is4448.Model.Hero;
import com.bis.ca2is4448.Model.JSONResponseModel;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
public interface HeroService {
    @GET("Api.php?apicall=getheroes")
    Call<JSONResponseModel> getHeroes();


    //Adapted from https://codinginflow.com/tutorials/android/retrofit/part-6-headers
    @FormUrlEncoded
    @POST("Api.php?apicall=createhero")
    Call<Hero> addHero(@Field("name") String name,
                       @Field("realname") String realname,
                       @Field("rating") int rating,
                       @Field("teamaffiliation") String team
    );

    //Adapted from https://codinginflow.com/tutorials/android/retrofit/part-6-headers
    @FormUrlEncoded
    @POST("Api.php?apicall=updatehero")
    Call<Hero> updateHero(@Query("id") int id, @Field("name") String name,
                          @Field("realname") String realname,
                          @Field("rating") int rating,
                          @Field("teamaffiliation") String team,
                          @Field("id") int fieldid);


    @DELETE("Api.php?apicall=deletehero")
    Call<Hero> deleteHero(@Query("id") int id);
}
