package com.example.bearpanda.findjob.service;

import com.example.bearpanda.findjob.category.model.Category;
import com.example.bearpanda.findjob.model.SignUp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by BearPanda on 6/29/2017.
 */

public interface APIService {
    //dang ky
    @FormUrlEncoded
    @POST("/api/auth/signup")
    Call<SignUp> signUpUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    //get category
    @GET("/api/categories")
    Call<Category> getCategory();

}

