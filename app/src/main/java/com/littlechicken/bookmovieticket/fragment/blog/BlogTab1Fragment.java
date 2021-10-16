package com.littlechicken.bookmovieticket.fragment.blog;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.BlogAdapter;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.custom.OnClickInterface;
import com.littlechicken.bookmovieticket.model.Blog;

import java.util.ArrayList;

public class BlogTab1Fragment extends BaseFragment implements OnClickInterface {
    private RecyclerView rcv_blogtab1;
    private ArrayList<Blog> listBlogtab1;
    private BlogAdapter blogAdapter;

    public BlogTab1Fragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blog_tab1;
    }

    @Override
    protected void initView(View view) {
        rcv_blogtab1 = view.findViewById(R.id.rcv_blogtab1);

    }

    @Override
    protected void initData(View view) {
        addDataBlogtab1();
        rcv_blogtab1.setHasFixedSize(true);
        blogAdapter = new BlogAdapter(getContext(),listBlogtab1, BlogTab1Fragment.this);
        rcv_blogtab1.setAdapter(blogAdapter);
    }

    @Override
    protected void initListener(View view) {

    }

    private void addDataBlogtab1()
    {
        listBlogtab1 = new ArrayList<>();
        listBlogtab1.add(new Blog(R.drawable.blogreview_trangti, "[Review] Trạng Tí: Một Bộ Phim Đầy Sáng Tạo!"));
        listBlogtab1.add(new Blog(R.drawable.blogreview_venom, "[Review] Sau 5 Lần Rời Lịch, Venom Có Đáng Xem?"));
        listBlogtab1.add(new Blog(R.drawable.blogreview_shangchi, "[Review] Cảm Nghĩ Đầu Tiên Về Shangchi"));
        listBlogtab1.add(new Blog(R.drawable.blogreview_trangti, "[Review] Trạng Tí: Một Bộ Phim Đầy Sáng Tạo!"));
        listBlogtab1.add(new Blog(R.drawable.blogreview_venom, "[Review] Sau 5 Lần Rời Lịch, Venom Có Đáng Xem?"));
        listBlogtab1.add(new Blog(R.drawable.blogreview_shangchi, "[Review] Cảm Nghĩ Đầu Tiên Về Shangchi"));
    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {

    }
}