package com.littlechicken.bookmovieticket.fragment.blog;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.ViewPagerAdapter;
import com.littlechicken.bookmovieticket.base.BaseFragment;

public class BlogFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public BlogFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blog;
    }

    @Override
    protected void initView(View view) {
        tabLayout = view.findViewById(R.id.tablayout_blog);
        viewPager = view.findViewById(R.id.viewpager_blog);

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new BlogTab1Fragment(), getString(R.string.tabtitle1_blog));
        viewPagerAdapter.addFragment(new BlogTab2Fragment(), getString(R.string.tabtitle2_blog));
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    protected void initListener(View view) {

    }
}