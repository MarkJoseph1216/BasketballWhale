package com.example.basketballwhale.Adapters.Scores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.basketballwhale.Model.Scores;
import com.example.basketballwhale.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ScoresAdapter extends RecyclerView.Adapter<ScoresAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    public Context context;
    List<Scores.Datum> eventsArrayList;

    public ScoresAdapter(Context context, List<Scores.Datum> eventsArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.eventsArrayList = eventsArrayList;
    }

    @Override
    public ScoresAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.scores_item, parent, false);
        return new ScoresAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScoresAdapter.ViewHolder holder, int position) {
        Scores.Datum eventDetails = eventsArrayList.get(position);

        Picasso.with(context).load(eventDetails.getHomeTeam().getLogo()).into(holder.imgHomeTeam);
        Picasso.with(context).load(eventDetails.getAwayTeam().getLogo()).into(holder.imgAwayTeam);

        holder.txtTeamHomeName.setText(eventDetails.getHomeTeam().getNameCode());
        holder.txtHomeCountry.setText(eventDetails.getHomeTeam().getCountry());

        holder.txtTeamAwayName.setText(eventDetails.getAwayTeam().getNameCode());
        holder.txtAwayCountry.setText(eventDetails.getAwayTeam().getCountry());

        holder.txtHomeScore.setText(String.valueOf(eventDetails.getHomeScore().getCurrent()));
        holder.txtAwayScore.setText(String.valueOf(eventDetails.getAwayScore().getCurrent()));
    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgHomeTeam, imgAwayTeam;
        TextView txtTeamHomeName, txtHomeCountry , txtTeamAwayName, txtAwayCountry, txtHomeScore, txtAwayScore;

        ViewHolder(View itemView) {
            super(itemView);

            imgHomeTeam = itemView.findViewById(R.id.imgHomeTeam);
            imgAwayTeam = itemView.findViewById(R.id.imgAwayTeam);

            txtTeamHomeName = itemView.findViewById(R.id.txtTeamHomeName);
            txtHomeCountry = itemView.findViewById(R.id.txtHomeCountry);

            txtTeamAwayName = itemView.findViewById(R.id.txtTeamAwayName);
            txtAwayCountry = itemView.findViewById(R.id.txtAwayCountry);

            txtHomeScore = itemView.findViewById(R.id.txtHomeScore);
            txtAwayScore = itemView.findViewById(R.id.txtAwayScore);
        }
    }
}
