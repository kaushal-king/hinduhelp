package com.example.hinduhelp.helppack;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.hinduhelp.R;
import com.example.hinduhelp.apiinterface.Api;
import com.example.hinduhelp.apiinterface.ApiClient;
import com.example.hinduhelp.apiinterface.get_set.User;
import com.example.hinduhelp.apiinterface.get_set.help_get_set;
import com.example.hinduhelp.apiinterface.responce.helpresponce;
import com.example.hinduhelp.helpcmpadapter;
import com.example.hinduhelp.storage.sareprefrencelogin;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class cmp extends Fragment {
    RecyclerView recyclerView;
    List<help_get_set> li;
    SwipeRefreshLayout swipe;
    helpcmpadapter ada;

    public cmp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_cmp, container, false);

        recyclerView=(RecyclerView) root.findViewById(R.id.cmprecycle);
        swipe=(SwipeRefreshLayout) root.findViewById(R.id.swipe_cmp);
        swipe.setColorSchemeColors(getResources().getColor(R.color.colorPrimary),getResources().getColor(R.color.lite_blue));

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        loadhelp();
                        swipe.setRefreshing(false);

                    }
                }, 2000);
                //swipe.setRefreshing(false);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadhelp();

        return  root;
    }






    public void loadhelp()
    {
User user;
        user= sareprefrencelogin.getInstance(getContext()).getuser();
        Api api= ApiClient.getClient().create(Api.class);
        Call<helpresponce> call=api.hcmp("helpdetail",user.getId()+"");
        call.enqueue(new Callback<helpresponce>() {
            @Override
            public void onResponse(Call<helpresponce> call, Response<helpresponce> response) {
                if (response.body().getSuccess()==200) {
                    li=response.body().getDe();
                    Collections.reverse(li);
                    ada=new helpcmpadapter(getContext(),li);
                    recyclerView.setAdapter(ada);
                }
                else {
                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<helpresponce> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
