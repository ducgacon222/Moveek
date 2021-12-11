package com.littlechicken.bookmovieticket.fragment.account;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.api.APIClient;
import com.littlechicken.bookmovieticket.api.APIClientlpm;
import com.littlechicken.bookmovieticket.model.SignUp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {
    EditText edName,edUserName, edEmail, edPass, edAddres;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btnSignUp.setOnClickListener(v -> {
//                 if (TextUtils.isEmpty(edName.getText().toString()) && !TextUtils.isEmpty(edEmail.getText().toString())
//                         && !TextUtils.isEmpty(edUserName.getText().toString())
//                         && !TextUtils.isEmpty(edAddres.getText().toString()) && ! TextUtils.isEmpty(edPass.getText().toString())) {
                     SignUp signUp = new SignUp();
                     signUp.setStatus("11");
                     signUp.setUpdatedAt("2021-12-07T15:22:27.557Z");
                     signUp.setCreatedAt("2021-12-07T15:22:27.557Z");
                     signUp.setAddress(edAddres.getText().toString());
                     signUp.setUserName(edUserName.getText().toString());
                     signUp.setLastName(edUserName.getText().toString().trim());
                     signUp.setEmail(edEmail.getText().toString());
                     signUp.setFirstName(edName.getText().toString());
                     signUp.setIsLocked(false);
                     signUp.setPassword(edPass.getText().toString());


            signUp(signUp);
//             }
        });

    }

    public void initView() {
        btnSignUp = findViewById(R.id.btnDangKi);
        edName = findViewById(R.id.editTextTextPersonName);
        edUserName = findViewById(R.id.editTextTextUserName);
        edEmail = findViewById(R.id.editTextTextEmailAddress);
        edAddres = findViewById(R.id.editTextTextAdress);
        edPass = findViewById(R.id.editTextTextPassword);


    }

    private void signUp(SignUp signUp) {
        SignUp up = new SignUp();
        up.setStatus("10");
        up.setUpdatedAt("2021-12-07T15:22:27.557Z");
        up.setCreatedAt("2021-12-07T15:22:27.557Z");
        up.setAddress(edAddres.getText().toString());
        up.setUserName(edUserName.getText().toString());
        up.setLastName(edUserName.getText().toString().trim());
        up.setEmail(edEmail.getText().toString());
        up.setFirstName(edName.getText().toString());
        up.setIsLocked(false);
        up.setPassword(edPass.getText().toString());
        Retrofit retrofit = APIClient.getInstance();
        APIClientlpm userService = retrofit.create(APIClientlpm.class);
        userService.postSignUp(up).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("TAG", "onResponse: " + response.isSuccessful());
                Toast.makeText(getApplicationContext(), ""+response.isSuccessful(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });

    }

}