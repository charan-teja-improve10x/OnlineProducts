package com.example.onlineproducts;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService fakeApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeApiService();
    }

    private void createFakeApiService() {
        fakeApiService = new FakeApi().createFakeApi();
    }
}
