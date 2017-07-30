package com.example.bearpanda.findjob.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BearPanda on 6/29/2017.
 */

public class APIClient {
    public static final String BASE_URL = "http://hihidongoc.esy.es";

    private static Retrofit retrofit = null;
    //gui yeu cau den 1 API REST
    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
