package com.littlechicken.bookmovieticket.fragment.detailfilm;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.littlechicken.bookmovieticket.R;
import com.littlechicken.bookmovieticket.adapter.ActorAdapter;
import com.littlechicken.bookmovieticket.base.BaseFragment;
import com.littlechicken.bookmovieticket.custom.OnClickInterface;
import com.littlechicken.bookmovieticket.custom.SpacesItemDecoration;
import com.littlechicken.bookmovieticket.custom.SpacesItemDecorationNoLeft;
import com.littlechicken.bookmovieticket.model.Actor;

import java.util.ArrayList;

import at.blogc.android.views.ExpandableTextView;

public class InfoFilmFragment extends BaseFragment implements OnClickInterface {
    ExpandableTextView tv_content;
    TextView tv_togglecontent;
    RecyclerView rcv_actor, rcv_director;
    ArrayList<Actor> listActor;
    ActorAdapter actorAdapter;
    ArrayList<Actor> listDirector;
    ActorAdapter directorAdapter;
    LinearLayoutManager linearLayoutManagerActor,linearLayoutManagerDirector;

    public InfoFilmFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_info_film;
    }

    @Override
    protected void initView(View view) {
        mapping(view);

    }

    @Override
    protected void initData(View view) {
        addDataActor();
        addDataDirector();
        rcv_actor.setHasFixedSize(true);
        rcv_director.setHasFixedSize(true);
        actorAdapter = new ActorAdapter(getContext(), listActor, InfoFilmFragment.this);
        directorAdapter = new ActorAdapter(getContext(), listDirector,InfoFilmFragment.this);
        rcv_actor.setAdapter(actorAdapter);
        rcv_director.setAdapter(directorAdapter);
        setupRecyclerViewActor(rcv_actor,linearLayoutManagerActor);
        setupRecyclerViewActor(rcv_director,linearLayoutManagerDirector);
    }

    @Override
    protected void initListener(View view) {
        tv_content.setInterpolator(new OvershootInterpolator());
        tv_togglecontent.setOnClickListener(view1 -> {
            tv_content.toggle();
            tv_togglecontent.setText(tv_content.isExpanded() ? R.string.tv_contentshowmore_infofilm : R.string.tv_contentshowless_infofilm);
        });
    }

    private void mapping(View view)
    {
        tv_content = view.findViewById(R.id.tv_content_infofilm);
        tv_togglecontent = view.findViewById(R.id.tv_togglecontent_infofilm);
        rcv_actor = view.findViewById(R.id.rcv_actor_infofilm);
        rcv_director = view.findViewById(R.id.rcv_director_infofilm);
    }

    private void addDataActor()
    {
        listActor = new ArrayList<>();
        listActor.add(new Actor(R.drawable.actor_daniel_craig_infofilm,"Daniel Craig"));
        listActor.add(new Actor(R.drawable.actor_rami_malek_infofilm,"Rami Malek"));
        listActor.add(new Actor(R.drawable.actor_lea_seydoux_infofilm,"Lea Seydoux"));
        listActor.add(new Actor(R.drawable.actor_daniel_craig_infofilm,"Daniel Craig"));
        listActor.add(new Actor(R.drawable.actor_rami_malek_infofilm,"Rami Malek"));
        listActor.add(new Actor(R.drawable.actor_lea_seydoux_infofilm,"Lea Seydoux"));
        listActor.add(new Actor(R.drawable.actor_daniel_craig_infofilm,"Daniel Craig"));
        listActor.add(new Actor(R.drawable.actor_rami_malek_infofilm,"Rami Malek"));
        listActor.add(new Actor(R.drawable.actor_lea_seydoux_infofilm,"Lea Seydoux"));
        listActor.add(new Actor(R.drawable.actor_daniel_craig_infofilm,"Daniel Craig"));
        listActor.add(new Actor(R.drawable.actor_rami_malek_infofilm,"Rami Malek"));
        listActor.add(new Actor(R.drawable.actor_lea_seydoux_infofilm,"Lea Seydoux"));
    }

    private void addDataDirector()
    {
        listDirector = new ArrayList<>();
        listDirector.add(new Actor(R.drawable.director_cary_fukunaga_infofilm,"Cary Fukunaga"));
    }

    private void setupRecyclerViewActor(RecyclerView rcv, LinearLayoutManager llm)
    {
        llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.HORIZONTAL);
        rcv.setLayoutManager(llm);
        rcv.addItemDecoration(new SpacesItemDecorationNoLeft(20));
        rcv.setNestedScrollingEnabled(true);
    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {

    }
}