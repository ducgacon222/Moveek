package com.littlechicken.bookmovieticket.fragment.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.islamkhsh.CardSliderViewPager;
import com.google.gson.Gson;
import com.littlechicken.bookmovieticket.MainActivity;
import com.littlechicken.bookmovieticket.adapter.FilmAdapter;
import com.littlechicken.bookmovieticket.api.APIClient;
import com.littlechicken.bookmovieticket.api.APIClientlpm;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.custom.OnClickInterface;
import com.littlechicken.bookmovieticket.custom.SpacesItemDecoration;
import com.littlechicken.bookmovieticket.fragment.detailfilm.DetailFilmFragment;
import com.littlechicken.bookmovieticket.model.Advertisement;
import com.littlechicken.bookmovieticket.adapter.AdvertisementAdapter;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.model.Film;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends BaseFragment implements OnClickInterface {
    private ArrayList<Advertisement> itemlist;
    private CardSliderViewPager cardSliderViewPager;
    private TextView tv_nowshowing, tv_comingsoon, tv_location;
    private ImageView img_location;
    private String[] locationArray = {"All", "Hà Nội", "TP Hồ Chí Minh", "Đà Nẵng", "An Giang", "Bến Tre", "Cà Mau", "Đắk Lắk", "Hải Phòng", "Nghệ An"};
    private ArrayList<Film> listFilm;
    private ArrayList<Film> listFilm2;
    private ArrayList<Film> listdata;
    private RecyclerView rcv_film;
    private FilmAdapter filmAdapter;
    private GridLayoutManager gridLayoutManager;
    Retrofit retrofit = APIClient.getInstance();
    private int indexLocation = -2;

    public HomeFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        callAPI();
        mapping(view);
        SharedPreferences sharedPreferences = initSharedPreferences(getContext());
        if (sharedPreferences != null) {
            if (sharedPreferences.contains("indexLocation_home")) {
                int index = sharedPreferences.getInt("indexLocation_home", -2);
                if (index != -2) {
                    indexLocation = index;
                    tv_location.setText(locationArray[index]);
                }
            }
        }
    }

    private void callAPI() {
        APIClientlpm userService = retrofit.create(APIClientlpm.class);
        userService.getFilm().enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", new Gson().toJson(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void initData(View view) {

        addDataAdvertisement();
        addDataFilm();

        cardSliderViewPager.setAdapter(new AdvertisementAdapter(itemlist));
        rcv_film.setHasFixedSize(true);
        filmAdapter = new FilmAdapter(getContext(), listdata, HomeFragment.this);
        rcv_film.setAdapter(filmAdapter);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rcv_film.setLayoutManager(gridLayoutManager);
        rcv_film.addItemDecoration(new SpacesItemDecoration(30));


    }

    @Override
    protected void initListener(View view) {
        tv_nowshowing.setOnClickListener(view1 -> {
            highlightedTV(tv_nowshowing);
            lowlightedTV(tv_comingsoon);
            listdata.clear();
            listdata.addAll(listFilm);
            filmAdapter.notifyDataSetChanged();
            gridLayoutManager.smoothScrollToPosition(rcv_film, null, 0);
        });
        tv_comingsoon.setOnClickListener(view2 -> {
            highlightedTV(tv_comingsoon);
            lowlightedTV(tv_nowshowing);
            listdata.clear();
            listdata.addAll(listFilm2);
            filmAdapter.notifyDataSetChanged();
            gridLayoutManager.smoothScrollToPosition(rcv_film, null, 0);
        });
        tv_location.setOnClickListener(view3 -> locationDialog());
        img_location.setOnClickListener(viet4 -> locationDialog());

    }

    private void mapping(View view) {
        cardSliderViewPager = view.findViewById(R.id.cardslider_home);
        tv_nowshowing = view.findViewById(R.id.tv_nowshowing_home);
        tv_comingsoon = view.findViewById(R.id.tv_comingsoon_home);
        tv_location = view.findViewById(R.id.tv_location_home);
        img_location = view.findViewById(R.id.img_location_home);
        rcv_film = view.findViewById(R.id.rcv_listfilm_home);
    }

    private void highlightedTV(TextView tv) {
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.home_bluetitle));
    }

    private void lowlightedTV(TextView tv) {
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.home_normaltext));
    }

    private void locationDialog() {
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(getContext());
        alt_bld.setTitle("Location");
        int checked = -1;
        if (indexLocation != -2) {
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

    private void addDataAdvertisement() {
        itemlist = new ArrayList<>();
        itemlist.add(new Advertisement(R.drawable.advertisement1));
        itemlist.add(new Advertisement(R.drawable.advertisement2));
        itemlist.add(new Advertisement(R.drawable.advertisement3));
    }

    private void addDataFilm() {
        listFilm = new ArrayList<>();
        listFilm.add(new Film(R.drawable.movie_notimetodie, "No Time To Die"));
        listFilm.add(new Film(R.drawable.movie_aquietplace2, "A Quite Place 2"));
        listFilm.add(new Film(R.drawable.movie_blackwidow, "Black Widow"));
        listFilm.add(new Film(R.drawable.movie_candyman, "Candy Man"));
        listFilm.add(new Film(R.drawable.movie_chuyenmagannha, "Chuyện Ma Gần Nhà"));
        listFilm.add(new Film(R.drawable.movie_eternals, "Eternals"));
        listFilm.add(new Film(R.drawable.movie_shangchi, "Shangchi"));
        listFilm.add(new Film(R.drawable.movie_venom, "Venom"));
        listFilm2 = new ArrayList<>();
        listFilm2.add(new Film(R.drawable.movie_venom, "Venom"));
        listFilm2.add(new Film(R.drawable.movie_shangchi, "Shangchi"));
        listFilm2.add(new Film(R.drawable.movie_eternals, "Eternals"));
        listFilm2.add(new Film(R.drawable.movie_chuyenmagannha, "Chuyện Ma Gần Nhà"));
        listFilm2.add(new Film(R.drawable.movie_candyman, "Candy Man"));
        listFilm2.add(new Film(R.drawable.movie_blackwidow, "Black Widow"));
        listFilm2.add(new Film(R.drawable.movie_aquietplace2, "A Quite Place 2"));
        listFilm2.add(new Film(R.drawable.movie_notimetodie, "No Time To Die"));
        listdata = new ArrayList<>();
        listdata.addAll(listFilm);
    }

    private void saveValueSP() {
        SharedPreferences sharedPreferences = initSharedPreferences(getContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("indexLocation_home", indexLocation);
        editor.apply();
    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        if (!isLongClick) {
            DetailFilmFragment detailFilmFragment = new DetailFilmFragment();
            ((MainActivity) getActivity()).replaceFrag(getActivity().getSupportFragmentManager(),
                    detailFilmFragment, detailFilmFragment.getClass().getSimpleName(), R.id.container_main);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        saveValueSP();
    }


}