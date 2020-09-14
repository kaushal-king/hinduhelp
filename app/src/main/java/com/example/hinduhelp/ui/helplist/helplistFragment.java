package com.example.hinduhelp.ui.helplist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.hinduhelp.R;
import com.example.hinduhelp.helppack.cmp;
import com.example.hinduhelp.helppack.pending;
import com.google.android.material.tabs.TabLayout;

public class helplistFragment extends Fragment implements TabLayout.OnTabSelectedListener  {
    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment fragment;
    FragmentManager manager;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_helplist, container, false);
        tabLayout = root.findViewById(R.id.tabhelp);

        viewPager = root.findViewById(R.id.viewpagehelp);
        manager = getFragmentManager();
        viewPager.setAdapter(new helplistFragment.adapter(manager));
        viewPager.setOffscreenPageLimit(2);
        tabLayout.addOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        return root;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    public class adapter extends FragmentStatePagerAdapter {

        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            fragment = null;
            if (position == 0) {

                fragment = new pending();


            }
            if (position == 1) {

                fragment = new cmp();

            }


            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}