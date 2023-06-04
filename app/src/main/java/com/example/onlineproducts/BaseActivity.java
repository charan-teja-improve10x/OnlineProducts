package com.example.onlineproducts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.onlineproducts.carts.CartsActivity;
import com.example.onlineproducts.network.FakeApi;
import com.example.onlineproducts.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {

    protected FakeApiService fakeApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeApiService();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.carts_item){
            Intent intent = new Intent(this,CartsActivity.class);
            startActivity(intent);
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.carts_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void createFakeApiService() {
        fakeApiService = new FakeApi().createFakeApi();
    }
}
