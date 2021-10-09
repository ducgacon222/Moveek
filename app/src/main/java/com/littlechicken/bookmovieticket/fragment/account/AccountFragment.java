package com.littlechicken.bookmovieticket.fragment.account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.base.BaseFragment;


public class AccountFragment extends BaseFragment {

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_account;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(View view) {

    }

    @Override
    protected void initListener(View view) {

    }
}