package com.littlechicken.bookmovieticket.fragment.detailfilm;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.FoodAdapter;
import com.littlechicken.bookmovieticket.api.APIClient;
import com.littlechicken.bookmovieticket.api.APIClientlpm;
import com.littlechicken.bookmovieticket.api.Data;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.model.Food;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by CanhNamDinh
 * on 17,December,2021
 */
public class FootFragment extends BaseFragment implements FoodAdapter.onClickItem {
    private Toolbar toolbar;
    private Retrofit retrofit;
    private List<Food> list;
    private FoodAdapter adapter;
    private RecyclerView recyclerView;
    private TextView totalCocal, totalPepsi;
    private double priceCoca = 1;
    private int indexCocal = 1;
    private int indexPepsi = 1;
    private double pricePepsi = 2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_food;
    }

    @Override
    protected void initView(View view) {
        retrofit = APIClient.getInstance();
        toolbar = view.findViewById(R.id.toolbar_detailfilm);
        totalCocal = view.findViewById(R.id.total_cocal);
        totalPepsi = view.findViewById(R.id.total_pepsi);
        list = new ArrayList<>();
        adapter = new FoodAdapter();
        adapter.setItem(this::onClickFood);
        recyclerView = view.findViewById(R.id.rv_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData(View view) {
        APIClientlpm userService = retrofit.create(APIClientlpm.class);
        userService.getFood().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (response.isSuccessful()) {
                    list.addAll(response.body());
                    adapter.setList(list);
                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });

    }

    @Override
    protected void initListener(View view) {
        toolbar.setNavigationOnClickListener(view1 -> getFragmentManager().popBackStackImmediate());
    }

    @Override
    public void onClickFood(Food food) {
        if (food.getId().equals("1")) {
            priceCoca = Double.parseDouble(food.getPrice()) * indexCocal;
            indexCocal++;
            totalCocal.setText(String.valueOf(food.getPrice()));
        }
        if (food.getId().equals("2")) {
            pricePepsi = Double.parseDouble(food.getPrice()) * indexPepsi;
            indexPepsi++;
            totalPepsi.setText(String.valueOf(pricePepsi));
        }

    }
}
