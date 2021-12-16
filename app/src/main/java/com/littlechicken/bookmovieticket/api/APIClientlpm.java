package com.littlechicken.bookmovieticket.api;

import com.littlechicken.bookmovieticket.model.SignUp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIClientlpm {

    @POST("api/Auth/SignUp")
    Call<ResponseBody> postSignUp(@Body SignUp signUp);

    @POST("api/Auth/SignIn")
    Call<Data> login(@Body Request request);

    @GET("/api/Film")
    Call<List<Data>> getFilm();

}
