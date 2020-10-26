package com.example.basketballwhale.Adapters.Home;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.basketballwhale.Model.Players;
import com.example.basketballwhale.Model.Scores;
import com.example.basketballwhale.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeMatchesAdapter extends RecyclerView.Adapter<HomeMatchesAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    public Context context;
    List<Scores.Datum> eventsArrayList;

    public HomeMatchesAdapter(Context context, List<Scores.Datum> eventsArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.eventsArrayList = eventsArrayList;
    }

    @Override
    public HomeMatchesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_matches_item, parent, false);
        return new HomeMatchesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeMatchesAdapter.ViewHolder holder, int position) {
        Scores.Datum eventDetails = eventsArrayList.get(position);

        holder.txtTeamHomeName.setText(eventDetails.getHomeTeam().getName());
        holder.txtTeamAwayName.setText(eventDetails.getAwayTeam().getName());

        Picasso.with(context).load(eventDetails.getHomeTeam().getLogo()).into(holder.imgHomeTeam);
        Picasso.with(context).load(eventDetails.getAwayTeam().getLogo()).into(holder.imgAwayTeam);
    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgHomeTeam, imgAwayTeam;
        TextView txtTeamHomeName, txtTeamAwayName, txtLetterV, txtLetterS;

        ViewHolder(View itemView) {
            super(itemView);

            txtTeamHomeName = itemView.findViewById(R.id.txtTeamHomeName);
            txtTeamAwayName = itemView.findViewById(R.id.txtTeamAwayName);

            imgHomeTeam = itemView.findViewById(R.id.imgHomeTeam);
            imgAwayTeam = itemView.findViewById(R.id.imgAwayTeam);

            txtLetterV = itemView.findViewById(R.id.txtLetterV);
            txtLetterS = itemView.findViewById(R.id.txtLetterS);
        }
    }

    public void updateList(ArrayList<Scores.Datum> list){
        eventsArrayList = list;
        notifyDataSetChanged();
    }
}