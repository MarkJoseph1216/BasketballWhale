package com.sports.basketballwhale.Adapters.Leagues;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sports.basketballwhale.Model.Leagues.LeaguesDetails;
import com.sports.basketballwhale.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    public Context context;
    List<LeaguesDetails.Datum> eventsArrayList;

    public LeaguesAdapter(Context context, List<LeaguesDetails.Datum> eventsArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.eventsArrayList = eventsArrayList;
    }

    @Override
    public LeaguesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.leagues_item, parent, false);
        return new LeaguesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LeaguesAdapter.ViewHolder holder, int position) {
        LeaguesDetails.Datum leaguesDetails = eventsArrayList.get(position);
        Picasso.with(context).load(leaguesDetails.getLogo()).into(holder.imgLeagues);
        holder.txtLeaguesName.setText(leaguesDetails.getName());
        holder.txtStartDate.setText("Start: " + formateDate(leaguesDetails.getStartDate()));
        holder.txtEndDate.setText("End: " + formateDate(leaguesDetails.getEndDate()));
        holder.txtSlugName.setText("Country Code: " + leaguesDetails.getSlug());
    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgLeagues;
        TextView txtLeaguesName, txtStartDate, txtEndDate, txtSlugName;

        ViewHolder(View itemView) {
            super(itemView);

            imgLeagues = itemView.findViewById(R.id.imgLeagues);
            txtLeaguesName = itemView.findViewById(R.id.txtLeaguesName);
            txtStartDate = itemView.findViewById(R.id.txtStartDate);
            txtEndDate = itemView.findViewById(R.id.txtEndDate);
            txtSlugName = itemView.findViewById(R.id.txtSlugName);
        }
    }

    private String formateDate (String dateResult){

        String dateName = "";
        SimpleDateFormat month_date = new SimpleDateFormat("MMM dd, yyyy ", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        if (dateResult == null) {
            return "No Available Date";
        } else {
            try {
                date = sdf.parse(dateResult);

                return dateName = month_date.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "No Available Date";
    }
}