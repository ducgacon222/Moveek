package com.littlechicken.bookmovieticket.fragment.detailfilm;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.littlechicken.bookmovieticket.MainActivity;
import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.base.BaseFragment;

public class RatingFilmFragment extends BaseFragment {
    private ImageView img_rating_1, img_rating_2, img_rating_3, img_rating_4, img_rating_5;
    private long mLastClickTimeRating = 0;
    private long betweentimeRating = 3000;
    public RatingFilmFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_rating_film;
    }

    @Override
    protected void initView(View view) {
        mapping(view);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    protected void initListener(View view) {
        img_rating_1.setOnClickListener(view1 -> {
            if(SystemClock.elapsedRealtime() - mLastClickTimeRating < betweentimeRating)
            {
                long a = (betweentimeRating - (SystemClock.elapsedRealtime() - mLastClickTimeRating))/1000;
                showToast("Thao tác quá nhanh, vui lòng thử lại trong " + a + " giây");
                return;
            }
            mLastClickTimeRating = SystemClock.elapsedRealtime();
            setDefaultRating();
            img_rating_1.setImageResource(R.drawable.ic_fb_angry);
        });
        img_rating_2.setOnClickListener(view2 -> {
            if(SystemClock.elapsedRealtime() - mLastClickTimeRating < betweentimeRating)
            {
                long a = (betweentimeRating - (SystemClock.elapsedRealtime() - mLastClickTimeRating))/1000;
                showToast("Thao tác quá nhanh, vui lòng thử lại trong " + a + " giây");
                return;
            }
            mLastClickTimeRating = SystemClock.elapsedRealtime();
            setDefaultRating();
            img_rating_2.setImageResource(R.drawable.ic_fb_sad);
        });
        img_rating_3.setOnClickListener(view3 -> {
            if(SystemClock.elapsedRealtime() - mLastClickTimeRating < betweentimeRating)
            {
                long a = (betweentimeRating - (SystemClock.elapsedRealtime() - mLastClickTimeRating))/1000;
                showToast("Thao tác quá nhanh, vui lòng thử lại trong " + a + " giây");
                return;
            }
            mLastClickTimeRating = SystemClock.elapsedRealtime();
            setDefaultRating();
            img_rating_3.setImageResource(R.drawable.ic_fb_wow);
        });
        img_rating_4.setOnClickListener(view4 -> {
            if(SystemClock.elapsedRealtime() - mLastClickTimeRating < betweentimeRating)
            {
                long a = (betweentimeRating - (SystemClock.elapsedRealtime() - mLastClickTimeRating))/1000;
                showToast("Thao tác quá nhanh, vui lòng thử lại trong " + a + " giây");
                return;
            }
            mLastClickTimeRating = SystemClock.elapsedRealtime();
            setDefaultRating();
            img_rating_4.setImageResource(R.drawable.ic_fb_haha);
        });
        img_rating_5.setOnClickListener(view5 -> {
            if(SystemClock.elapsedRealtime() - mLastClickTimeRating < betweentimeRating)
            {
                long a = (betweentimeRating - (SystemClock.elapsedRealtime() - mLastClickTimeRating))/1000;
                showToast("Thao tác quá nhanh, vui lòng thử lại trong " + a + " giây");
                return;
            }
            mLastClickTimeRating = SystemClock.elapsedRealtime();
            setDefaultRating();
            img_rating_5.setImageResource(R.drawable.ic_fb_lovelove);
        });

    }

    private void mapping(View view)
    {
        img_rating_1 = view.findViewById(R.id.img_rating_1_ratingfilm);
        img_rating_2 = view.findViewById(R.id.img_rating_2_ratingfilm);
        img_rating_3 = view.findViewById(R.id.img_rating_3_ratingfilm);
        img_rating_4 = view.findViewById(R.id.img_rating_4_ratingfilm);
        img_rating_5 = view.findViewById(R.id.img_rating_5_ratingfilm);
    }

    private void setDefaultRating()
    {
        img_rating_1.setImageResource(R.drawable.ic_fb_angry_blackwhite);
        img_rating_2.setImageResource(R.drawable.ic_fb_sad_blackwhite);
        img_rating_3.setImageResource(R.drawable.ic_fb_wow_blackwhite);
        img_rating_4.setImageResource(R.drawable.ic_fb_haha_blackwhite);
        img_rating_5.setImageResource(R.drawable.ic_fb_lovelove_blackwhite);
    }

}