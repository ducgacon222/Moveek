package com.littlechicken.bookmovieticket.api;

import com.littlechicken.bookmovieticket.model.Food;
import com.littlechicken.bookmovieticket.model.SignUp;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface APIClientlpm {

    @POST("api/Auth/SignUp")
    Call<ResponseBody> postSignUp(@Body SignUp signUp);

    @POST("api/Auth/SignIn")
    Call<Data> login(@Field("username") String username, @Field("password") String password);

    @GET("/api/Film")
    Call<List<Data>> getFilm();

    @GET("/api/Food")
    Call<List<Food>> getFood();

    @GET("/api/Location")
    Call<List<Data>> getLocation();

}
