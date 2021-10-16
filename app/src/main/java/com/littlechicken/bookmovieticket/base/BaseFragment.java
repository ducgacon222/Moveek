package com.littlechicken.bookmovieticket.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.littlechicken.bookmovieticket.MainActivity;
import com.littlechicken.bookmovieticket.R;

import java.io.IOException;
import java.security.GeneralSecurityException;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getContext()).inflate(getLayoutId(),container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData(view);
        initListener(view);
    }

    protected abstract int getLayoutId();
    protected abstract void initView(View view);
    protected abstract void initData(View view);
    protected abstract void initListener(View view);

    public void showToast(String message) {
        if(MainActivity.mToast != null)
        {
            MainActivity.mToast.cancel();
        }
        MainActivity.mToast = Toast.makeText(getContext(), message, Toast.LENGTH_SHORT);
        MainActivity.mToast.show();
    }

    public SharedPreferences initSharedPreferences(Context context)
    {
        SharedPreferences sharedPreferences = null;
        try {
            String masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            sharedPreferences = EncryptedSharedPreferences.create(
                    "mySharedPreferences",masterKeyAlias,context
                    ,EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV
                    ,EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sharedPreferences;
    }

}
