package com.littlechicken.bookmovieticket.fragment.landing;

import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.littlechicken.bookmovieticket.MainActivity;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.fragment.account.AccountFragment;
import com.littlechicken.bookmovieticket.fragment.blog.BlogFragment;
import com.littlechicken.bookmovieticket.fragment.cinema.CinemaFragment;
import com.littlechicken.bookmovieticket.fragment.home.HomeFragment;

public class LandingFragment extends BaseFragment {
    BottomNavigationView mBottomNavigationView;

    public LandingFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_landing;
    }

    @Override
    protected void initView(View view) {
        mBottomNavigationView = view.findViewById(R.id.bottomnavigation_landing);
        HomeFragment homeFragment = new HomeFragment();
        ((MainActivity)getActivity()).replaceFrag(getChildFragmentManager(),homeFragment,homeFragment.getClass().getSimpleName(),R.id.container_landing);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    protected void initListener(View view) {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.bottomnav_home:
                        HomeFragment homeFragment = new HomeFragment();
                        ((MainActivity)getActivity()).replaceFrag(getChildFragmentManager(),homeFragment,homeFragment.getClass().getSimpleName(),R.id.container_landing);
                        return true;
                    case R.id.bottomnav_cinema:
                        CinemaFragment cinemaFragment = new CinemaFragment();
                        ((MainActivity)getActivity()).replaceFrag(getChildFragmentManager(),cinemaFragment,cinemaFragment.getClass().getSimpleName(),R.id.container_landing);
                        return true;
                    case R.id.bottomnav_blog:
                        BlogFragment blogFragment = new BlogFragment();
                        ((MainActivity)getActivity()).replaceFrag(getChildFragmentManager(),blogFragment,blogFragment.getClass().getSimpleName(),R.id.container_landing);
                        return true;
                    case R.id.bottomnav_account:
                        AccountFragment accountFragment = new AccountFragment();
                        ((MainActivity)getActivity()).replaceFrag(getChildFragmentManager(),accountFragment,accountFragment.getClass().getSimpleName(),R.id.container_landing);
                        return true;
                }
                return false;
            }
        });
    }

}