package com.example.appuser.Utils;

import java.lang.reflect.GenericArrayType;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static Retrofit getRetrofit(String url){
        Retrofit  retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
