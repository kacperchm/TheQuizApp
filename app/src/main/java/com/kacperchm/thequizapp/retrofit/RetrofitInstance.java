package com.kacperchm.thequizapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    String baseUrl = "http://172.24.128.1:8080/quiz/";

    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
