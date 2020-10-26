package com.example.basketballwhale.Adapters.Players;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.basketballwhale.Model.Players;
import com.example.basketballwhale.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    public Context context;
    List<Players.Datum> eventsArrayList;
    Dialog showDialogInformation;

    TextView txtName, txtShortName, txtBornDate, txtPosition, txtCountry;
    ImageView imagePlayers, imgClose;

    public PlayerListAdapter(Context context, List<Players.Datum> eventsArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.eventsArrayList = eventsArrayList;

        showDialogInformation = new Dialog(context);
    }

    @Override
    public PlayerListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.players_list_item, parent, false);
        return new PlayerListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PlayerListAdapter.ViewHolder holder, int position) {
        final Players.Datum playerDetails = eventsArrayList.get(position);

        holder.txtPlayerName.setText(playerDetails.getName());
        Glide.with(context).load(playerDetails.getPhoto()).into(holder.imgPlayers);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogDetails(playerDetails.getName(), playerDetails.getPhoto(), playerDetails.getNameShort(), playerDetails.getDateBirthAt(), playerDetails.getPosition(), playerDetails.getFlag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgPlayers;
        TextView txtPlayerName;

        ViewHolder(View itemView) {
            super(itemView);

            imgPlayers = itemView.findViewById(R.id.imgPlayers);
            txtPlayerName = itemView.findViewById(R.id.txtPlayerName);
        }
    }

    public void updateList(ArrayList<Players.Datum> list){
        eventsArrayList = list;
        notifyDataSetChanged();
    }

    private void showDialogDetails(String playerName, String playerPhoto, String playerShortName, String playerBirthDate, String playerPosition, String playerCountry) {
        showDialogInformation.setContentView(R.layout.players_dialog_layout);
        txtName = showDialogInformation.findViewById(R.id.txtName);
        txtShortName = showDialogInformation.findViewById(R.id.txtShortName);
        txtBornDate = showDialogInformation.findViewById(R.id.txtBornDate);
        txtPosition = showDialogInformation.findViewById(R.id.txtPosition);
        txtCountry = showDialogInformation.findViewById(R.id.txtCountry);

        imagePlayers = showDialogInformation.findViewById(R.id.imagePlayers);
        imgClose = showDialogInformation.findViewById(R.id.imgClose);

        final ProgressBar loadingImage = showDialogInformation.findViewById(R.id.loadingImage);

        txtName.setText(playerName);
        txtShortName.setText("Short Name: " + playerShortName);
        txtPosition.setText("Position: " + playerPosition);
        txtCountry.setText("Country: " + playerCountry);

        String formatDateName = playerBirthDate.substring(0, 9);
        SimpleDateFormat month_date = new SimpleDateFormat("MMM dd, yyyy ", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(formatDateName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String date_Name = month_date.format(date);
        txtBornDate.setText("Born Date: " + date_Name);

        Picasso.with(context).load(playerPhoto).into(imagePlayers, new Callback.EmptyCallback() {
            @Override public void onSuccess() {
                loadingImage.setVisibility(View.GONE);
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInformation.dismiss();
            }
        });

        showDialogInformation.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        showDialogInformation.setCanceledOnTouchOutside(true);
        showDialogInformation.show();
    }
}
