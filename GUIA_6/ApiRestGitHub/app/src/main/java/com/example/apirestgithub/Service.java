package com.example.apirestgithub;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface Service {
    @GET("/users/{username}")
    Call<UserGit> getUser(@Path("username") String username);
}
