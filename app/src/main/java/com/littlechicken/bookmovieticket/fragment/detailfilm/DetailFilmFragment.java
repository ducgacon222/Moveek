package com.littlechicken.bookmovieticket.fragment.detailfilm;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.ViewPagerAdapter;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.fragment.blog.BlogTab1Fragment;
import com.littlechicken.bookmovieticket.fragment.blog.BlogTab2Fragment;

public class DetailFilmFragment extends BaseFragment {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ConstraintLayout constraintLayout_basicinfo;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public DetailFilmFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detail_film;
    }

    @Override
    protected void initView(View view) {
        mapping(view);
        collapsechange();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new ShowTimeFragment(), getString(R.string.tabtitle1_filmdetail));
        viewPagerAdapter.addFragment(new InfoFilmFragment(), getString(R.string.tabtitle2_filmdetail));
        viewPagerAdapter.addFragment(new RatingFilmFragment(), getString(R.string.tabtitle3_filmdetail));
        viewPager.setAdapter(viewPagerAdapter);
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
        collapsingToolbarLayout = view.findViewById(R.id.collapsingtoolbar_detailfilm);
        constraintLayout_basicinfo = view.findViewById(R.id.constraintLayout_basicinfo_detailfilm);
        appBarLayout = view.findViewById(R.id.appbarlayout_detailfilm);
        toolbar = view.findViewById(R.id.toolbar_detailfilm);
        tabLayout = view.findViewById(R.id.tablayout_detailfilm);
        viewPager = view.findViewById(R.id.viewpager_detailfilm);
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