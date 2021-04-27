package com.bis.ca2is4448.Remote;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Adapted from https://www.jackrutorial.com/2018/06/retrofit-2-crud-android-example.html
public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                        Request originalRequest = chain.request();
                        Request newRequest = originalRequest.newBuilder()
                                .build();
                        return chain.proceed(newRequest);
                    }
                })
                .build();

        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }

}
