package com.example.hinduhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinduhelp.Otpverification.Forgetpassword_otp;
import com.example.hinduhelp.apiinterface.Api;
import com.example.hinduhelp.apiinterface.ApiClient;
import com.example.hinduhelp.apiinterface.CommanResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Forgotpassword_form extends AppCompatActivity {
    EditText mono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword_form);
        mono = (EditText) findViewById(R.id.forgot_mobile_ed);
        mono.requestFocus();

        findViewById(R.id.forget_mob_sendotp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mobile = mono.getText().toString().trim();

                if (mobile.isEmpty() || mobile.length() < 10) {
                    mono.setError("Enter a valid mobile");
                    mono.requestFocus();
                    return;
                }
                Toast.makeText(Forgotpassword_form.this, "sorfot password", Toast.LENGTH_SHORT).show();

                Api api = ApiClient.getClient().create(Api.class);
                Call<CommanResponse> call = api.mobnoex("passmobnoex", mobile);
                call.enqueue(new Callback<CommanResponse>() {
                    @Override
                    public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                        if (response.body().getSuccess()==200) {
                            Intent intent = new Intent(Forgotpassword_form.this, Forgetpassword_otp.class);
                            intent.putExtra("mobile", mobile);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(Forgotpassword_form.this, response.body().getMessage() + "", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<CommanResponse> call, Throwable t) {
                        Toast.makeText(Forgotpassword_form.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });
    }
    public void loginback2(View view) {
        Intent i = new Intent(Forgotpassword_form.this, Loginactivity.class);
        startActivity(i);
        finish();
    }
    public void regiback(View view) {
        Intent i = new Intent(Forgotpassword_form.this, Loginactivity.class);
        startActivity(i);
        finish();
    }
}
