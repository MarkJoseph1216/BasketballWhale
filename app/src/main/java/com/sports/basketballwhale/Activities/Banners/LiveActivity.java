package com.sports.basketballwhale.Activities.Banners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sports.basketballwhale.Adapters.Live.LiveAdapter;
import com.sports.basketballwhale.Interface.APIService;
import com.sports.basketballwhale.Model.Banners.Live;
import com.sports.basketballwhale.R;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LiveActivity extends AppCompatActivity {

    ImageView imgBack;
    RecyclerView recyclerViewBannerHandler;
    LiveAdapter liveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        overridePendingTransition(R.anim.bounce, android.R.anim.fade_out);

        init();
        onClickListener();
        getLiveData();
    }

    private void init(){
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorWhite));

        imgBack = findViewById(R.id.imgBack);
        recyclerViewBannerHandler = findViewById(R.id.recyclerViewBannerHandler);
    }

    private void onClickListener(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getLiveData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.LIVE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService api = retrofit.create(APIService.class);
        Call<List<Live.Video>> call = api.getLiveData();
        call.enqueue(new Callback<List<Live.Video>>() {
            @Override
            public void onResponse(Call<List<Live.Video>> call, retrofit2.Response<List<Live.Video>> response) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(LiveActivity.this);
                recyclerViewBannerHandler.setLayoutManager(layoutManager);

                List<Live.Video> events = response.body(); // Data fetch from request
                Collections.reverse(events);

                liveAdapter = new LiveAdapter(LiveActivity.this, events);
                recyclerViewBannerHandler.setAdapter(liveAdapter);
            }
            @Override
            public void onFailure(Call<List<Live.Video>> call, Throwable t) {
            }
        });
    }
}