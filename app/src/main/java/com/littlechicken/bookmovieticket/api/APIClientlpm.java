package com.littlechicken.bookmovieticket.api;

import com.littlechicken.bookmovieticket.model.login.Data;
import com.littlechicken.bookmovieticket.model.login.Request;
import com.littlechicken.bookmovieticket.model.login.SignUp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIClientlpm {

    @POST("api/Auth/SignUp")
    Call<ResponseBody> postSignUp(@Body SignUp signUp);

    @POST("api/Auth/SignIn")
    Call<Data> login(@Body Request request);

}
