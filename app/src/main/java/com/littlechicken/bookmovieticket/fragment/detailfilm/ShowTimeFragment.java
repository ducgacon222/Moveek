package com.littlechicken.bookmovieticket.fragment.detailfilm;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.littlechicken.bookmovieticket.MainActivity;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.ChooseDayAdapter;
import com.littlechicken.bookmovieticket.adapter.ChooseSeateMovie;
import com.littlechicken.bookmovieticket.adapter.ChooseSpinerAdapter;
import com.littlechicken.bookmovieticket.api.APIClient;
import com.littlechicken.bookmovieticket.api.APIClientlpm;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShowTimeFragment extends BaseFragment {
    private String[] locationArray = {"Hà Nội"};
    private Spinner spinner;
    private RecyclerView rv_day, rv_product, rv_seate;
    private ChooseDayAdapter dayAdapter;
    private ChooseDayAdapter dayAdapterproduct;
    private ChooseSeateMovie chooseSeateMovie;
    private List<Data> listDay;
    private ArrayList<Data> listLocation;
    private List<Data> listProduct;
    private List<Data> listSeate;
    private AppCompatButton btn_next;
    private ChooseSpinerAdapter adapter;
    private Retrofit retrofit;

    public ShowTimeFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show_time;
    }

    @Override
    protected void initView(View view) {
        adapter = new ChooseSpinerAdapter(listLocation, getContext());
        retrofit = APIClient.getInstance();
        rv_day = view.findViewById(R.id.rv_day);
        btn_next = view.findViewById(R.id.next);
        rv_product = view.findViewById(R.id.rv_product);
        rv_seate = view.findViewById(R.id.rv_seate);
        dayAdapter = new ChooseDayAdapter();
        dayAdapterproduct = new ChooseDayAdapter();
        chooseSeateMovie = new ChooseSeateMovie();
        listDay = new ArrayList<>();
        listProduct = new ArrayList<>();
        listSeate = new ArrayList<>();
        listLocation = new ArrayList<>();
        spinner = view.findViewById(R.id.spinner_city_showtime);
        rv_day.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_day.setAdapter(dayAdapter);
        rv_product.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_product.setAdapter(dayAdapterproduct);
        rv_seate.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_seate.setAdapter(chooseSeateMovie);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "sadasd", Toast.LENGTH_SHORT).show();
            }

        });
        btn_next.setOnClickListener(v -> {
            FootFragment footFragment = new FootFragment();
            ((MainActivity) getActivity()).replaceFrag(getActivity().getSupportFragmentManager(),
                    footFragment, footFragment.getClass().getSimpleName(), R.id.container_main);
        });
    }

    private void callAPI() {
        APIClientlpm userService = retrofit.create(APIClientlpm.class);
        userService.getLocation().enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful()) {
                    listLocation.addAll(response.body());
                    adapter.setListSpiner(listLocation);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData(View view) {
        callAPI();
        Data data = new Data();
        Data data1 = new Data();
        Data data2 = new Data();
        data2.setSeate("H");
        data.setDate("20/20/2021");
        data.setToday("Now");
        data1.setDate("10AM");
        data1.setToday("Het");
        listDay.add(data);
        listDay.add(data);
        for (int i = 0; i < 20; i++) {
            listSeate.add(data2);
        }
        listProduct.add(data1);
        listProduct.add(data1);
        dayAdapter.setList(listDay);
        dayAdapter.setList(listDay);
        dayAdapterproduct.setList(listProduct);
        chooseSeateMovie.setList(listSeate);
    }

    @Override
    protected void initListener(View view) {

    }
}