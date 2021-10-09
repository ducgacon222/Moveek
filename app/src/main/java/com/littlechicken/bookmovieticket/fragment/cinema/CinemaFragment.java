package com.littlechicken.bookmovieticket.fragment.cinema;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.base.BaseFragment;

public class CinemaFragment extends BaseFragment {
    private String[] locationArray = {"All","Hà Nội","TP Hồ Chí Minh","Đà Nẵng","An Giang","Bến Tre","Cà Mau","Đắk Lắk","Hải Phòng","Nghệ An"};
    private TextView tv_location;
    private ImageView img_location;
    private int indexLocation = -2;

    public CinemaFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initView(View view) {
        mapping(view);
        SharedPreferences sharedPreferences = initSharedPreferences(getContext());
        if(sharedPreferences != null)
        {
            if(sharedPreferences.contains("indexLocation_home"))
            {
                int index = sharedPreferences.getInt("indexLocation_home",-2);
                if(index != -2)
                {
                    indexLocation = index;
                    tv_location.setText(locationArray[index]);
                }
            }
        }
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    protected void initListener(View view) {
        tv_location.setOnClickListener(view3 -> {
            locationDialog();
        });
        img_location.setOnClickListener(viet4 -> {
            locationDialog();
        });
    }

    private void locationDialog()
    {
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(getContext());
        alt_bld.setTitle("Location");
        int checked = -1;
        if(indexLocation != -2)
        {
            checked = indexLocation;
        }
        alt_bld.setSingleChoiceItems(locationArray, checked, (DialogInterface.OnClickListener) (dialog, item) -> {
            tv_location.setText(locationArray[item]);
            indexLocation = item;
            dialog.dismiss();
        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }

    private void mapping(View view)
    {
        tv_location = view.findViewById(R.id.tv_location_cinema);
        img_location = view.findViewById(R.id.img_location_cinema);
    }

    private void saveValueSP()
    {
        SharedPreferences sharedPreferences = initSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("indexLocation_home",indexLocation);
        editor.apply();
    }

    @Override
    public void onStop() {
        super.onStop();
        saveValueSP();
    }

}