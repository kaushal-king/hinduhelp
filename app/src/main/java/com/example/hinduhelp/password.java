package com.example.hinduhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hinduhelp.apiinterface.Api;
import com.example.hinduhelp.apiinterface.ApiClient;
import com.example.hinduhelp.apiinterface.CommanResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class password extends AppCompatActivity {
    EditText password,conformpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        password=(EditText) findViewById(R.id.pass1);
        conformpassword=(EditText) findViewById(R.id.cpass);
    }
    public void regiback(View view) {
        super.onBackPressed();

    }

    public void checkpassmatchp(View view) {
        String s1=password.getText().toString();
        String s2=conformpassword.getText().toString();
        boolean k=true;
        if(s1.isEmpty()&&s1.length()<8){
            password.setError(" 8 character necessary");
            k=false;
        }
        if(s2.isEmpty()){
            conformpassword.setError("Invailid Conform-Password");
            k=false;
        }
        if(!s2.equals(s1)){
            conformpassword.setError("Not Match");
            k=false;
        }
        if(k==true){
//            tosttext1.setText("match passeord");
//            LayoutInflater li = getLayoutInflater();
//            View layout = li.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.toast));
//            Toast t=new Toast(getApplicationContext());
//            t.setDuration(Toast.LENGTH_SHORT);
//
//            t.setView(layout);
//            t.show();
            Intent i1=getIntent();
            String ffname=i1.getStringExtra("ifname");
            String llname=i1.getStringExtra("ilname");
            String mobino=i1.getStringExtra("imobno");
            String email=i1.getStringExtra("iemail");
            String address=i1.getStringExtra("iadd");
            String pincode=i1.getStringExtra("ipin");
            String district=i1.getStringExtra("dister");
            final String state=i1.getStringExtra("state");

            Toast.makeText(this, "possword set", Toast.LENGTH_SHORT).show();

            Api api= ApiClient.getClient().create(Api.class);

            Call<CommanResponse> call =api.createUser("loginregistration",ffname,llname,
                    mobino,email,address,pincode,state,district,s1);
            call.enqueue(new Callback<CommanResponse>() {
                @Override
                public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                    if (response.body().getSuccess()==200) {


                            Toast.makeText(password.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), Loginactivity.class);
                            startActivity(i);



                    }
                    else
                    {
                        Toast.makeText(password.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<CommanResponse> call, Throwable t) {
                    Toast.makeText(password.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
