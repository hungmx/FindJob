package com.example.bearpanda.findjob;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.example.bearpanda.findjob.model.SignUp;
import com.example.bearpanda.findjob.service.APIClient;
import com.example.bearpanda.findjob.service.APIService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BearPanda on 6/29/2017.
 */

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btSignup)
    public void signUpUser(){
//        progressDialog = ProgressDialog.show(this, "dialog title",
//                "dialog message", true);
//        String name = etName.getText().toString();
//        String email = etEmail.getText().toString();
//        String password = etPassword.getText().toString();
        String name = "hung";
        String email = "hung345@gmail.com";
        String password = "hng1234";

        APIService apiService = APIClient.getClient().create(APIService.class);
        Call<SignUp> callback = apiService.signUpUser(name, email, password);
        callback.enqueue(new Callback<SignUp>() {
            @Override
            public void onResponse(Call<SignUp> call, Response<SignUp> response) {
//                SignUp signUp = response.body();
//                Log.d("message ", signUp.getMessage());
//                Log.d("signUp ", String.valueOf(signUp));
                Log.d("code ", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<SignUp> call, Throwable t) {
//                progressDialog.dismiss();
                Log.d("onFail ", t.getMessage());
            }
        });
    }
}
