package com.hindu.hinduhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hindu.hinduhelp.apiinterface.Api;
import com.hindu.hinduhelp.apiinterface.ApiClient;
import com.hindu.hinduhelp.apiinterface.CommanResponse;
import com.hindu.hinduhelp.apiinterface.responce.loginresponce;
import com.hindu.hinduhelp.storage.sareprefrencelogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Loginactivity extends AppCompatActivity {
    TextView re;
    EditText no;
    ProgressBar o;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        re = (TextView) findViewById(R.id.regi);
        b = (Button) findViewById(R.id.loginbutton);
        o = (ProgressBar) findViewById(R.id.logprog);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Loginactivity.this, Registration.class);
                startActivity(i);

            }
        });
        no = (EditText) findViewById(R.id.mono);



    }
    @Override
    protected void onStart() {
        super.onStart();
        if(sareprefrencelogin.getInstance(this).islogin())
        {
            Intent i = new Intent(Loginactivity.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

    }




    public void login(View view) {

        final String n=no.getText().toString();
o.setVisibility(View.VISIBLE);
b.setVisibility(View.GONE);




        if (n.isEmpty() || n.length() < 10) {
            no.setError("Enter a valid mobile");
            no.requestFocus();
            return;
        }

        Api api = ApiClient.getClient().create(Api.class);
        Call<CommanResponse> call = api.mobnoex("passmobnoex", n);
        call.enqueue(new Callback<CommanResponse>() {
            @Override
            public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                if (response.body().getSuccess()==200) {
                    o.setVisibility(View.GONE);
                    b.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(Loginactivity.this, loginotp.class);
                    intent.putExtra("mobile", n);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Loginactivity.this, response.body().getMessage() + "", Toast.LENGTH_SHORT).show();
                    o.setVisibility(View.GONE);
                    b.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<CommanResponse> call, Throwable t) {
                Toast.makeText(Loginactivity.this, t.getLocalizedMessage() + "", Toast.LENGTH_SHORT).show();
                o.setVisibility(View.GONE);
                b.setVisibility(View.VISIBLE);
            }
        });






    }

}
