package com.littlechicken.bookmovieticket.fragment.filmdetail;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.base.BaseFragment;

public class FilmDetailFragment extends BaseFragment {
    CollapsingToolbarLayout collapsingToolbarLayout;
    ConstraintLayout constraintLayout_basicinfo;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    public FilmDetailFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_film_detail;
    }

    @Override
    protected void initView(View view) {
        mapping(view);
        collapsechange();
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    protected void initListener(View view) {
        toolbar.setNavigationOnClickListener(view1 -> {
            getFragmentManager().popBackStackImmediate();
        });
    }

    private void mapping(View view)
    {
        collapsingToolbarLayout = view.findViewById(R.id.collapsingtoolbar_filmdetail);
        constraintLayout_basicinfo = view.findViewById(R.id.constraintLayout_basicinfo_filmdetail);
        appBarLayout = view.findViewById(R.id.appbarlayout_filmdetail);
        toolbar = view.findViewById(R.id.toolbar_filmdetail);
    }

    private void collapsechange()
    {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("No Time To Die");
                    appBarLayout.setBackgroundColor(getResources().getColor(R.color.home_bluetitle));
                    constraintLayout_basicinfo.setVisibility(View.GONE);
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    appBarLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    constraintLayout_basicinfo.setVisibility(View.VISIBLE);
                    isShow = false;
                }
            }
        });
    }
}