package com.example.basketballwhale.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.basketballwhale.Adapters.Home.HomeBannersAdapter;
import com.example.basketballwhale.Adapters.Home.HomeImageLatestNewsAdapter;
import com.example.basketballwhale.Adapters.Home.HomeMatchesAdapter;
import com.example.basketballwhale.Interface.APIService;
import com.example.basketballwhale.Library.ModifiedViewPager;
import com.example.basketballwhale.Model.Home.SportsNews;
import com.example.basketballwhale.Model.Players;
import com.example.basketballwhale.Model.Scores;
import com.example.basketballwhale.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentHome extends Fragment {

    ImageView imgSearch, imgClose;
    EditText edtSearchItems;

    RecyclerView recyclerViewHeader, recyclerViewMatches;

    HomeBannersAdapter homeBannersAdapter;
    ModifiedViewPager viewPagerLatestNews;

    ArrayList<String> bannersItems;
    List<Scores.Datum> events;

    public static NestedScrollView scrollView;
    public static TextView txtMatches;

    TextView txtHeader;
    HomeImageLatestNewsAdapter homeImageLatestNews;
    ImageView loadLatestNews, loadingMatches;
    DotsIndicator dotsIndicator;

    HomeMatchesAdapter homeMatchesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        onClickListener();
        return view;
    }

    @SuppressLint("ResourceAsColor")
    private void init(View view){
        getActivity().getWindow().setStatusBarColor(R.color.colorLightBlack);

        edtSearchItems = view.findViewById(R.id.edtSearchItems);
        recyclerViewHeader = view.findViewById(R.id.recyclerViewHeader);

        imgSearch = view.findViewById(R.id.imgSearch);
        imgClose = view.findViewById(R.id.imgClose);
        scrollView = view.findViewById(R.id.scrollView);
        txtHeader = view.findViewById(R.id.txtHeader);
        viewPagerLatestNews = view.findViewById(R.id.viewPagerLatestNews);
        loadLatestNews = view.findViewById(R.id.loadLatestNews);
        dotsIndicator = view.findViewById(R.id.dots_indicator);
        recyclerViewMatches = view.findViewById(R.id.recyclerViewMatches);
        loadingMatches = view.findViewById(R.id.loadingMatches);
        txtMatches = view.findViewById(R.id.txtMatches);

        GridLayoutManager layoutManager = new GridLayoutManager (getContext(),  1, GridLayoutManager.HORIZONTAL, false);
        recyclerViewHeader.setLayoutManager(layoutManager);

        bannersItems = new ArrayList<>();
        bannersItems.add("Live");
        bannersItems.add("Scores");
        bannersItems.add("Matches");
        bannersItems.add("Players");

        homeBannersAdapter = new HomeBannersAdapter(getContext(), bannersItems);
        recyclerViewHeader.setAdapter(homeBannersAdapter);

        getSportsNews();
        getMatches();
    }

    private void onClickListener(){
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearchItems.setVisibility(View.VISIBLE);
                imgClose.setVisibility(View.VISIBLE);
                imgSearch.setVisibility(View.GONE);
                txtHeader.setVisibility(View.GONE);
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearchItems.setVisibility(View.GONE);
                imgClose.setVisibility(View.GONE);
                imgSearch.setVisibility(View.VISIBLE);
                txtHeader.setVisibility(View.VISIBLE);
                edtSearchItems.setText("");
                filterMatches("");
            }
        });

        edtSearchItems.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filterMatches(editable.toString());
            }
        });
    }

    private void filterMatches(String text){
        ArrayList<Scores.Datum> temp = new ArrayList();
        for(Scores.Datum teams: events){
            if(teams.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(teams);
            }
        }
        //Update Recyclerview
        homeMatchesAdapter.updateList(temp);
    }

    public void getSportsNews() {
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(loadLatestNews);
        Glide.with(getContext()).load(R.raw.loadinghome).into(imageViewTarget);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.SPORTS_NEWS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService api = retrofit.create(APIService.class);
        Call<SportsNews> call = api.getSportsNews();
        call.enqueue(new Callback<SportsNews>() {
            @Override
            public void onResponse(Call<SportsNews> call, retrofit2.Response<SportsNews> response) {
                try {
                    List<SportsNews.Article> latestNews = response.body().getArticles(); // Data fetch from request

                    Collections.reverse(latestNews);
                    homeImageLatestNews = new HomeImageLatestNewsAdapter(getContext(), latestNews);
                    viewPagerLatestNews.setAnimationEnabled(true);
                    viewPagerLatestNews.setFadeEnabled(true);
                    viewPagerLatestNews.setFadeFactor(0.6f);
                    viewPagerLatestNews.setAdapter(homeImageLatestNews);
                    dotsIndicator.setViewPager(viewPagerLatestNews);
                    loadLatestNews.setVisibility(View.GONE);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            @Override
            public void onFailure(Call<SportsNews> call, Throwable t) {
            }
        });
    }

    public void getMatches() {
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(loadingMatches);
        Glide.with(getContext()).load(R.raw.loadinghome).into(imageViewTarget);
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
                recyclerViewMatches.setLayoutManager(layoutManager);

                events = response.body().getData(); // Data fetch from request
                events.remove(0);

                Collections.reverse(events);

                if (getActivity() != null) {
                    homeMatchesAdapter = new HomeMatchesAdapter(getContext(), events);
                    recyclerViewMatches.setAdapter(homeMatchesAdapter);
                    homeMatchesAdapter.notifyDataSetChanged();
                    loadingMatches.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<Scores> call, Throwable t) {
            }
        });
    }
}
