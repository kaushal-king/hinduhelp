package com.hindu.hinduhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class cmpdetail extends AppCompatActivity {
    TextView email, mobile;
    String s, s3;
    ImageView call, message, copyimage1;
    ImageView iemail, iweb,imap;
    TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmpdetail);
        email = findViewById(R.id.samratjewellersgmail);
        mobile = findViewById(R.id.mobile_number_contact);


        iemail = findViewById(R.id.image_email);
        iweb = findViewById(R.id.image_wesite);
        imap = findViewById(R.id.image_address);

        t1 = findViewById(R.id.text_email);
        t2 = findViewById(R.id.text_website);


        s = mobile.getText().toString();


        call = findViewById(R.id.image_call);
        message = findViewById(R.id.image_message);

        copyimage1 = findViewById(R.id.copyimage);





        copyimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager) getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(email.getText());
                Toast.makeText(getApplicationContext(), "Email is Copyed", Toast.LENGTH_SHORT).show();
            }
        });
        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + s));
                startActivity(intent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + s));
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri sms_uri = Uri.parse("smsto:7383846827");
                Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
                sms_intent.putExtra("sms_body", "Hello, Samrat Jewellers");
                startActivity(sms_intent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] mails={"kaushaljethava12@gmail.com"};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
               /* intent.putExtra(Intent.EXTRA_SUBJECT, "Subject is Here");
                intent.putExtra(Intent.EXTRA_TEXT, "Write Your Message Here ");*/
                intent.setPackage("com.google.android.gm");
                intent.putExtra(Intent.EXTRA_EMAIL, mails);
                startActivity(Intent.createChooser(intent, ""));
            }
        });








        iemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject is Here");
                intent.putExtra(Intent.EXTRA_TEXT, "Write Your Message Here ");
                startActivity(Intent.createChooser(intent, ""));
            }
        });


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject is Here");
                intent.putExtra(Intent.EXTRA_TEXT, "Write Your Message Here ");
                startActivity(Intent.createChooser(intent, ""));
            }
        });



    }
}
