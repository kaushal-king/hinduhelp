package com.hindu.hinduhelp.ui.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.hindu.hinduhelp.Loginactivity;
import com.hindu.hinduhelp.MainActivity;
import com.hindu.hinduhelp.R;
import com.hindu.hinduhelp.apiinterface.Api;
import com.hindu.hinduhelp.apiinterface.ApiClient;
import com.hindu.hinduhelp.apiinterface.get_set.User;
import com.hindu.hinduhelp.apiinterface.responce.loginresponce;
import com.hindu.hinduhelp.storage.sareprefrencelogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToolsFragment extends Fragment {
    TextView name,mob;
    TextView log;
    AlertDialog.Builder builder;


    private ToolsViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
       log=(TextView) root.findViewById(R.id.exit_pro);
        name=(TextView) root.findViewById(R.id.user_name);
        mob=(TextView) root.findViewById(R.id.user_mob);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sareprefrencelogin.getInstance(getContext()).clear();
                Intent i=new Intent(getContext(), Loginactivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });



        root.findViewById(R.id.personal_pro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder= new AlertDialog.Builder(getContext());
                LayoutInflater inflater=(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v=inflater.inflate(R.layout.fragment_personaldetails,null);
                builder.setView(v);
                builder.setCancelable(true);
                final AlertDialog alert=builder.create();
                final User user= sareprefrencelogin.getInstance(getContext()).getuser();
                String fname=user.getFname();
                String lname=user.getLname();
                String email=user.getEmail()+" ";
                String mob=user.getMobileno();

                final EditText efname,elname,eemail,emobno;
                Button save;
                efname=v.findViewById(R.id.personal_fname);
                elname=v.findViewById(R.id.personal_lname);
                eemail=v.findViewById(R.id.personal_email);
                emobno=v.findViewById(R.id.personal_mobno);
                save=v.findViewById(R.id.personal_save);

                efname.setText(fname);
                elname.setText(lname);
                eemail.setText(email);
                emobno.setText(mob);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Api api = ApiClient.getClient().create(Api.class);
                        Call<loginresponce> call=api.personalupdate("profilepersonal",
                                efname.getText()+"",
                                elname.getText()+"",
                                emobno.getText()+"",
                                eemail.getText()+"",
                                user.getId()+"");
                        call.enqueue(new Callback<loginresponce>() {
                            @Override
                            public void onResponse(Call<loginresponce> call, Response<loginresponce> response) {
                                if (response.body().getSuccess()==200) {
                                    loginresponce loginresponce=response.body();
                                    sareprefrencelogin.getInstance(getContext()).saveuser(loginresponce.getUser());
                                    Intent i = new Intent(getContext(), MainActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<loginresponce> call, Throwable t) {
                                Toast.makeText(getContext(), "Mobile no Already exist", Toast.LENGTH_SHORT).show();
                            }
                        });


                        alert.dismiss();
                    }
                });

                alert.show();
            }
        });









        return root;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        User user= sareprefrencelogin.getInstance(getContext()).getuser();
        String s=user.getFname()+" "+user.getLname();
        name.setText(s);
        mob.setText(user.getMobileno());
    }






}