package com.hindu.hinduhelp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.hindu.hinduhelp.R;

public class dashboard extends Fragment {
    TextView txt;
    CardView c1,c2,c3,c4,c5,c6;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        txt = root.findViewById(R.id.texttr);
        c1 = root.findViewById(R.id.card_add);
        c2 = root.findViewById(R.id.status);
        c3 = root.findViewById(R.id.tools);
        c4 = root.findViewById(R.id.aboutus);
//        c5 = root.findViewById(R.id.aboutus);
//        c6 = root.findViewById(R.id.card_offer);

        txt.setSelected(true);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add);
            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_slideshow);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_tools);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_send);
            }
        });

//        c5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_share);
//            }
//        });
//
//        c6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_add);
//            }
//        });

        return root;
    }
}