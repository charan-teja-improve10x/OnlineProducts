package com.example.onlineproducts.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FakeApi {

    public FakeApiService createFakeApi() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.escuelajs.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        FakeApiService fakeApiService = retrofit.create(FakeApiService.class);
        return fakeApiService;
    }
}
