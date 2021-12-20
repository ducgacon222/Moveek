package com.littlechicken.bookmovieticket.fragment.account;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.api.APIClient;
import com.littlechicken.bookmovieticket.api.APIClientlpm;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.api.Request;
import com.littlechicken.bookmovieticket.databinding.ActivityLogin2Binding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {
    ActivityLogin2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        binding = ActivityLogin2Binding.inflate(getLayoutInflater());
        binding.button3.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        setContentView(binding.getRoot());
        binding.button2.setOnClickListener(v -> {
            Request signUp = new Request();
            signUp.setPassword(binding.editTextTextPassword.getText().toString());
            signUp.setUsername(binding.editTextTextPassword.getText().toString());
            Retrofit retrofit = APIClient.getInstance();
            APIClientlpm userService = retrofit.create(APIClientlpm.class);
            userService.login(binding.editTextTextPassword.getText().toString(),binding.editTextTextPassword.getText().toString()).enqueue(new Callback<Data>() {
                @Override
                public void onResponse(Call<Data> call, Response<Data> response) {
                    Log.d("TAG", new Gson().toJson(response.body()) + "");
                }

                @Override
                public void onFailure(Call<Data> call, Throwable t) {
                    Log.d("TAG", t.getMessage() + "");
                }
            });
        });

    }

}