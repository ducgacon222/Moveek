package com.littlechicken.bookmovieticket.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleRegistryOwner;
import androidx.lifecycle.Observer;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.littlechicken.bookmovieticket.MainActivity;
import com.littlechicken.bookmovieticket.model.ConnectionModel;
import com.littlechicken.bookmovieticket.network.ConnectionLiveData;
import com.littlechicken.bookmovieticket.R;

import java.io.IOException;
import java.security.GeneralSecurityException;

public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initData();
        initListener();

    }

    protected abstract int getContentView();
    protected abstract void initView();
    protected abstract void initData();
    protected abstract void initListener();

    public void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (getCurrentFocus() != null)
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            Log.e("MultiBackStack", "Failed to add fragment to back stack", e);
        }
    }

    public void showBackArrow() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
    }

    public void showProgressDialog(String title, @NonNull String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            if (title != null)
                mProgressDialog.setTitle(title);
            mProgressDialog.setIcon(R.mipmap.ic_launcher);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(false);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }
    }


    public void hideDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showAlertDialogBasic(String msg) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle(null);
        dialogBuilder.setIcon(R.mipmap.ic_launcher);
        dialogBuilder.setMessage(msg);
        dialogBuilder.setPositiveButton(getString(R.string.baseactivity_dialog_ok_button), (dialog, which) -> dialog.cancel());

        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }

    public void showToast(String mToastMsg) {
        Toast.makeText(this, mToastMsg, Toast.LENGTH_SHORT).show();
    }

    public void addFrag(FragmentManager manager, Fragment fragment, String tag, int containerId)
    {
        String fragmentTag = fragment.getClass().getSimpleName();
        boolean fragmentPopped = manager.popBackStackImmediate(fragmentTag, 0);
        FragmentTransaction transaction = manager.beginTransaction();
        if(!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null)
        {
            transaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out,
                    R.anim.trans_right_in, R.anim.trans_right_out);
            transaction.add(containerId, fragment, tag)
                    .addToBackStack(tag)
                    .commit();
            manager.executePendingTransactions();
        }
    }

    public void addFrag(FragmentManager manager, Fragment fragment, String tag, int containerId, Bundle bundle)
    {
        String fragmentTag = fragment.getClass().getSimpleName();
        boolean fragmentPopped = manager.popBackStackImmediate(fragmentTag, 0);
        FragmentTransaction transaction = manager.beginTransaction();
        if(!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null)
        {
            fragment.setArguments(bundle);
            transaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out,
                    R.anim.trans_right_in, R.anim.trans_right_out);
            transaction.add(containerId, fragment, tag)
                    .addToBackStack(tag)
                    .commit();
            manager.executePendingTransactions();
        }
    }

    public void replaceFrag(FragmentManager manager, Fragment fragment, String tag, int containerId)
    {
        String fragmentTag = fragment.getClass().getSimpleName();
        boolean fragmentPopped = manager.popBackStackImmediate(fragmentTag, 0);
        FragmentTransaction transaction = manager.beginTransaction();
        if(!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null)
        {
            transaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out,
                    R.anim.trans_right_in, R.anim.trans_right_out);
            transaction.replace(containerId, fragment, tag)
                    .addToBackStack(tag)
                    .commit();
            manager.executePendingTransactions();
        }
    }

    public void replaceFrag(FragmentManager manager, Fragment fragment, String tag, int containerId, Bundle bundle)
    {
        String fragmentTag = fragment.getClass().getSimpleName();
        boolean fragmentPopped = manager.popBackStackImmediate(fragmentTag, 0);
        FragmentTransaction transaction = manager.beginTransaction();
        if(!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null)
        {
            fragment.setArguments(bundle);
            transaction.setCustomAnimations(R.anim.trans_left_in, R.anim.trans_left_out,
                    R.anim.trans_right_in, R.anim.trans_right_out);
            transaction.replace(containerId, fragment, tag)
                    .addToBackStack(tag)
                    .commit();
            manager.executePendingTransactions();
        }
    }

    public void hideFrag(FragmentManager manager, String tag)
    {
        Fragment fragmentcheck = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();
        if(fragmentcheck != null)
        {
            transaction.hide(fragmentcheck);
            transaction.commit();
        }
    }

    public void showFrag(FragmentManager manager, String tag) {
        Fragment fragmentcheck = manager.findFragmentByTag(tag);
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentcheck != null) {
            transaction.show(fragmentcheck);
            transaction.commit();
        }
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