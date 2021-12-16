package com.littlechicken.bookmovieticket.fragment.detailfilm;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.ChooseDayAdapter;
import com.littlechicken.bookmovieticket.adapter.ChooseSeateMovie;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class ShowTimeFragment extends BaseFragment {
    private String[] locationArray = {"All", "Hà Nội", "TP Hồ Chí Minh", "Đà Nẵng", "An Giang", "Bến Tre", "Cà Mau", "Đắk Lắk", "Hải Phòng", "Nghệ An"};
    private Spinner spinner;
    private RecyclerView rv_day, rv_product, rv_seate;
    ChooseDayAdapter dayAdapter;
    ChooseDayAdapter dayAdapterproduct;
    ChooseSeateMovie chooseSeateMovie;
    private List<Data> listDay;
    private List<Data> listProduct;
    private List<Data> listSeate;

    public ShowTimeFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show_time;
    }

    @Override
    protected void initView(View view) {
        rv_day = view.findViewById(R.id.rv_day);
        rv_product = view.findViewById(R.id.rv_product);
        rv_seate = view.findViewById(R.id.rv_seate);
        dayAdapter = new ChooseDayAdapter();
        dayAdapterproduct = new ChooseDayAdapter();
        chooseSeateMovie = new ChooseSeateMovie();
        listDay = new ArrayList<>();
        listProduct = new ArrayList<>();
        listSeate = new ArrayList<>();
        spinner = view.findViewById(R.id.spinner_city_showtime);
        rv_day.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_day.setAdapter(dayAdapter);
        rv_product.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_product.setAdapter(dayAdapterproduct);
        rv_seate.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_seate.setAdapter(chooseSeateMovie);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item,
                locationArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "" + locationArray[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    protected void initData(View view) {
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
       for (int i=0;i<20;i++){
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