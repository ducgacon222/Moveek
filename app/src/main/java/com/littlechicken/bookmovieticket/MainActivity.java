package com.littlechicken.bookmovieticket;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.littlechicken.bookmovieticket.base.BaseActivity;
import com.littlechicken.bookmovieticket.fragment.filmdetail.FilmDetailFragment;
import com.littlechicken.bookmovieticket.fragment.landing.LandingFragment;
import com.littlechicken.bookmovieticket.network.ConnectionLiveData;

public class MainActivity extends BaseActivity {
    private ConnectionLiveData connectionLiveData;
    private AlertDialog dialogNoInternet;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        this.getSupportActionBar().hide();
        dialogNoInternet = createInternetDialog(MainActivity.this);
        connectionLiveData = new ConnectionLiveData(this);
        connectionLiveData.observe(this, connection -> {
            if (connection.getIsConnected()) {
                switch (connection.getType()) {
                    case 1:
                        showToast("Connected to wifi!");
                        if(dialogNoInternet.isShowing())
                            dialogNoInternet.dismiss();
                        break;
                    case 2:
                        showToast("Connected to mobile data!");
                        if(dialogNoInternet.isShowing())
                            dialogNoInternet.dismiss();
                        break;
                }
            } else {
                dialogNoInternet.show();
            }
        });
        LandingFragment landingFragment = new LandingFragment();
        addFrag(getSupportFragmentManager(), landingFragment, landingFragment.getClass().getSimpleName(),R.id.container_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            this.finish();
//            super.onBackPressed();
        }
    }

    private AlertDialog createInternetDialog(Context context)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.nointernet_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        Button buttonRetry = view.findViewById(R.id.nointernet_btnRetry);
        builder.setView(view);
        AlertDialog dialog = builder.create();

        buttonRetry.setOnClickListener(btnRetry -> {
            dialog.dismiss();
            connectionLiveData.checkInternet();
        });
        dialog.getWindow().setGravity(Gravity.CENTER);
        return dialog;
    }

}