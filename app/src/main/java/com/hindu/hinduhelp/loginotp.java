package com.hindu.hinduhelp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hindu.hinduhelp.apiinterface.Api;
import com.hindu.hinduhelp.apiinterface.ApiClient;
import com.hindu.hinduhelp.apiinterface.responce.loginresponce;
import com.hindu.hinduhelp.storage.sareprefrencelogin;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginotp extends AppCompatActivity {
    private String mVerificationId;
    private EditText editTextCode;
    String mobile;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginotp);
        mAuth = FirebaseAuth.getInstance();
        editTextCode = findViewById(R.id.editTextCode);


        Intent intent = getIntent();
        mobile= intent.getStringExtra("mobile");
        sendVerificationCode(mobile);


        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editTextCode.getText().toString().trim();
                if (code.isEmpty() || code.length() < 6) {
                    editTextCode.setError("Enter valid code");
                    editTextCode.requestFocus();
                    return;
                }

//                Intent intent = new Intent(Forgetpassword_otp.this, forget_pass_change.class);
//                intent.putExtra("mob", mobile);
//                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
                verifyVerificationCode(code);
            }
        });
    }


    private void sendVerificationCode(String mobile) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }


    //the callback to detect the verification status
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                editTextCode.setText(code);
                //verifying the code
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(loginotp.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            Toast.makeText(loginotp.this, "OTP Code Sent", Toast.LENGTH_SHORT).show();
            //storing the verification id that is sent to the user
            mVerificationId = s;
        }
    };


    private void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(loginotp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(loginotp.this, "OTP Match", Toast.LENGTH_SHORT).show();
                            //verification successful we will start the profile activity

        Api api = ApiClient.getClient().create(Api.class);
        Call<loginresponce> call=api.login("loginmember",mobile);
        call.enqueue(new Callback<loginresponce>() {
            @Override
            public void onResponse(Call<loginresponce> call, Response<loginresponce> response) {
                if (response.body().getSuccess()==405) {
                    loginresponce loginresponce=response.body();
                    sareprefrencelogin.getInstance(loginotp.this).saveuser(loginresponce.getUser());
                    Intent i = new Intent(loginotp.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(loginotp.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(loginotp.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
//
                }
            }

            @Override
            public void onFailure(Call<loginresponce> call, Throwable t) {
                Toast.makeText(loginotp.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });


                        } else {

                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }

                            Toast.makeText(loginotp.this, ""+message, Toast.LENGTH_SHORT).show();
//                            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_LONG);
//                            snackbar.setAction("Dismiss", new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//
//                                }
//                            });
//                            snackbar.show();
                        }
                    }
                });
    }
}
