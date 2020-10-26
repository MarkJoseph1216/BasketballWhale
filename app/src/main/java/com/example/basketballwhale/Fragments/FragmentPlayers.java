package com.example.basketballwhale.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basketballwhale.Adapters.Players.PlayerListAdapter;
import com.example.basketballwhale.Interface.APIService;
import com.example.basketballwhale.Model.Players;
import com.example.basketballwhale.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentPlayers extends Fragment {

    RecyclerView recyclerViewPlayers;
    PlayerListAdapter playerListAdapter;
    RelativeLayout relativeHandler;
    EditText edtSearchPlayers;

    List<Players.Datum> players;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players, container, false);
        init(view);
        getPlayers();
        onListener();
        return view;
    }

    private void init(View view){
        recyclerViewPlayers = view.findViewById(R.id.recyclerViewPlayers);
        relativeHandler = view.findViewById(R.id.relativeHandler);
        edtSearchPlayers = view.findViewById(R.id.edtSearchPlayers);
    }

    private void onListener() {
        edtSearchPlayers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filterPlayers(editable.toString());
            }
        });
    }

    private void filterPlayers(String text){
        ArrayList<Players.Datum> temp = new ArrayList();
        for(Players.Datum teams: players){
            if(teams.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(teams);
            }
        }
        //Update Recyclerview
        playerListAdapter.updateList(temp);
    }

    public void getPlayers() {
        relativeHandler.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.PLAYERS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService api = retrofit.create(APIService.class);
        Call<Players> call = api.getPlayers();
        call.enqueue(new Callback<Players>() {
            @Override
            public void onResponse(Call<Players> call, retrofit2.Response<Players> response) {
                recyclerViewPlayers.setLayoutManager(new GridLayoutManager(getContext(), 3));

                players = response.body().getData(); // Data fetch from request

                if (getActivity() != null) {
                    playerListAdapter = new PlayerListAdapter(getContext(), players);
                    recyclerViewPlayers.setAdapter(playerListAdapter);
                    playerListAdapter.notifyDataSetChanged();
                    relativeHandler.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<Players> call, Throwable t) {
            }
        });
    }
}
