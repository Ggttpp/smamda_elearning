package com.smamda.elearning.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smamda.elearning.R;
import com.smamda.elearning.activities.MainActivity;
import com.smamda.elearning.adapters.ViewPagerArtikelAdapter;

/**
 * Created by khusika on 16/12/15.
 */
public class FragmentArtikel extends Fragment {

    private MainActivity mainActivity;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public FragmentArtikel() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_artikel, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.tab_artikel_toolbar);

        setupToolbar();

        viewPager = (ViewPager)view.findViewById(R.id.tab_artikel_view_pager);

        setupViewPager();

        tabLayout = (TabLayout)view.findViewById(R.id.tab_artikel_layout);

        setupTab();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity.setupNavigationDrawer(toolbar);
    }

    private void setupToolbar(){
        toolbar.setTitle(getString(R.string.artikel_fragment_title));
        mainActivity.setSupportActionBar(toolbar);
    }

    private void setupTab(){
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(){
        viewPager.setAdapter(new ViewPagerArtikelAdapter(getChildFragmentManager()));
    }

}
