package com.example.basketballwhale.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.basketballwhale.Adapters.Leagues.LeaguesAdapter;
import com.example.basketballwhale.Interface.APIService;
import com.example.basketballwhale.Model.Leagues.Leagues;
import com.example.basketballwhale.Model.Leagues.LeaguesDetails;
import com.example.basketballwhale.R;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentLeagues extends Fragment {

    RecyclerView recyclerViewLeagues;
    LeaguesAdapter leaguesAdapter;
    ImageView loadLeagues;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leagues, container, false);
        init(view);
        getLeagues();
        return view;
    }

    private void init(View view){
        recyclerViewLeagues = view.findViewById(R.id.recyclerViewLeagues);
        loadLeagues = view.findViewById(R.id.loadLeagues);
    }

    public void getLeagues() {
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(loadLeagues);
        Glide.with(getContext()).load(R.raw.loadinghome).into(imageViewTarget);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService api = retrofit.create(APIService.class);
        Call<LeaguesDetails> call = api.getLeagueDetails();
        call.enqueue(new Callback<LeaguesDetails>() {
            @Override
            public void onResponse(Call<LeaguesDetails> call, retrofit2.Response<LeaguesDetails> response) {

                try {
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerViewLeagues.setLayoutManager(layoutManager);

                    List<LeaguesDetails.Datum> events = response.body().getData(); // Data fetch from request
                    Collections.reverse(events);

                    leaguesAdapter = new LeaguesAdapter(getContext(), events);
                    recyclerViewLeagues.setAdapter(leaguesAdapter);
                    leaguesAdapter.notifyDataSetChanged();
                    loadLeagues.setVisibility(View.GONE);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            @Override
            public void onFailure(Call<LeaguesDetails> call, Throwable t) {
                Log.d("GetLogo",String.valueOf(t.getMessage()));
            }
        });
    }
}
