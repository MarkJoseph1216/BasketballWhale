package com.sports.basketballwhale.Interface;

import com.sports.basketballwhale.Model.Banners.Live;
import com.sports.basketballwhale.Model.Home.SportsNews;
import com.sports.basketballwhale.Model.Leagues.LeaguesDetails;
import com.sports.basketballwhale.Model.Players;
import com.sports.basketballwhale.Model.Scores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {
    String BASE_URL = "https://rapidapi.p.rapidapi.com/sports/3/";
    String LIVE_URL = "https://www.scorebat.com/video-api/";
    String PLAYERS_URL = "https://rapidapi.p.rapidapi.com/sports/3/";
    String LEAGUES_URL = "https://rapidapi.p.rapidapi.com/sports/3/events/";
    String SPORTS_NEWS_URL = "https://newsapi.org/v2/";

    @GET("top-headlines?country=us&category=sports&apiKey=fb5e220f67b84d6cabdb345e031da5a1")
    Call<SportsNews> getSportsNews();

    @GET("v1")
    Call<List<Live.Video>> getLiveData();

    @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
            "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
            "useQueryString: true"})

    @GET("leagues")
    Call<LeaguesDetails> getLeagueDetails();

    @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
            "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
            "useQueryString: true"})
    @GET("events")
    Call<Scores> getScores();

    @Headers({"x-rapidapi-host: sportscore1.p.rapidapi.com",
            "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
            "useQueryString: true"})
    @GET("players")
    Call<Players> getPlayers();
}