package com.littlechicken.bookmovieticket.fragment.blog;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.BlogAdapter;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.custom.OnClickInterface;
import com.littlechicken.bookmovieticket.model.Blog;

import java.util.ArrayList;

public class BlogTab2Fragment extends BaseFragment implements OnClickInterface {
    private RecyclerView rcv_blogtab2;
    private ArrayList<Blog> listBlogtab2;
    private BlogAdapter blogAdapter;

    public BlogTab2Fragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blog_tab2;
    }

    @Override
    protected void initView(View view) {
        rcv_blogtab2 = view.findViewById(R.id.rcv_blogtab2);
    }

    @Override
    protected void initData(View view) {
        addDataBlogtab2();
        rcv_blogtab2.setHasFixedSize(true);
        blogAdapter = new BlogAdapter(getContext(),listBlogtab2, BlogTab2Fragment.this);
        rcv_blogtab2.setAdapter(blogAdapter);

    }

    @Override
    protected void initListener(View view) {

    }

    private void addDataBlogtab2()
    {
        listBlogtab2 = new ArrayList<>();
        listBlogtab2.add(new Blog(R.drawable.blogtintuc_marvel, "[Tin tức] Hé Lộ Mức Cát Xê Của Dàn Diễn Viên Avengers, Nhìn Ai Cũng Thấy Nghìn Tỷ Cả"));
        listBlogtab2.add(new Blog(R.drawable.blogtintuc_han, "[Tin tức] Top 10 Nữ Diễn Viên Hàn Quốc Xuất Sắc Nhất Năm 2021"));
        listBlogtab2.add(new Blog(R.drawable.blogtintuc_viet, "[Tin tức] Công Bố Top 5 Của 11 Hạng Mục VTV Awards 2021"));
        listBlogtab2.add(new Blog(R.drawable.blogtintuc_marvel, "[Tin tức] Hé Lộ Mức Cát Xê Của Dàn Diễn Viên Avengers, Nhìn Ai Cũng Thấy Nghìn Tỷ Cả"));
        listBlogtab2.add(new Blog(R.drawable.blogtintuc_han, "[Tin tức] Top 10 Nữ Diễn Viên Hàn Quốc Xuất Sắc Nhất Năm 2021"));
        listBlogtab2.add(new Blog(R.drawable.blogtintuc_viet, "[Tin tức] Công Bố Top 5 Của 11 Hạng Mục VTV Awards 2021"));
    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {

    }
}