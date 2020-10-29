package com.sports.basketballwhale.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sports.basketballwhale.Adapters.Scores.ScoresAdapter;
import com.sports.basketballwhale.Interface.APIService;
import com.sports.basketballwhale.Model.Scores;
import com.sports.basketballwhale.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentScores extends Fragment {

    RecyclerView recyclerViewSportsScores;
    ScoresAdapter homeScoresAdapter;
    AVLoadingIndicatorView loadingScores;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        init(view);
        getScores();
        return view;
    }

    private void init(View view){
        getActivity().getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.toolbarColorScores));
        recyclerViewSportsScores = view.findViewById(R.id.recyclerViewSportsScores);
        loadingScores = view.findViewById(R.id.loadingScores);
    }

    public void getScores() {
        loadingScores.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService api = retrofit.create(APIService.class);
        Call<Scores> call = api.getScores();
        call.enqueue(new Callback<Scores>() {
            @Override
            public void onResponse(Call<Scores> call, retrofit2.Response<Scores> response) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                recyclerViewSportsScores.setLayoutManager(layoutManager);

                List<Scores.Datum> events = response.body().getData(); // Data fetch from request
                events.remove(0);

                if (getActivity() != null) {
                    homeScoresAdapter = new ScoresAdapter(getContext(), events);
                    recyclerViewSportsScores.setAdapter(homeScoresAdapter);
                    homeScoresAdapter.notifyDataSetChanged();
                }

                loadingScores.setVisibility(View.GONE);
            }
            @Override
            public void onFailure(Call<Scores> call, Throwable t) {
            }
        });
    }
}
