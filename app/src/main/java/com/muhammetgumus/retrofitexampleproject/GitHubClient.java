package com.muhammetgumus.retrofitexampleproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

    @GET("/den")
    Call<String> deneme();

    @POST("create")
    Call<String> createAccount(@Body User user);


}
