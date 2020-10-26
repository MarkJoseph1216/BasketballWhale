package com.example.basketballwhale.Adapters.Home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.basketballwhale.Activities.Banners.LiveActivity;
import com.example.basketballwhale.Activities.Dashboard;
import com.example.basketballwhale.Fragments.FragmentHome;
import com.example.basketballwhale.Fragments.FragmentPlayers;
import com.example.basketballwhale.Library.CircularTextView;
import com.example.basketballwhale.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeBannersAdapter extends RecyclerView.Adapter<HomeBannersAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    public Context context;
    ArrayList<String> bannerArrayList;

    public static final int[] Banner_Icons = {
            R.drawable.live,
            R.drawable.ball,
            R.drawable.team,
            R.drawable.player
    };

    public HomeBannersAdapter(Context context, ArrayList<String> bannerArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.bannerArrayList = bannerArrayList;
    }

    @Override
    public HomeBannersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_banners_item, parent, false);
        return new HomeBannersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeBannersAdapter.ViewHolder holder, final int position) {

        if (position == 0) {
            holder.txtBannerTitle.setTextColor(context.getResources().getColor(R.color.colorLightRed));
        }

        holder.txtBannerTitle.setText(bannerArrayList.get(position));
        Glide.with(context)
                .load(Banner_Icons[position])
                .into(holder.imgBanners);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position == bannerArrayList.size() -1) {
                    Dashboard.bottomNavigation.setSelectedItemId(R.id.navigation_players);
                } else if (position == 1) {
                    Dashboard.bottomNavigation.setSelectedItemId(R.id.navigation_scores);
                } else if (position == 2) {
                    FragmentHome.scrollView.smoothScrollTo(0, Math.round(FragmentHome.txtMatches.getY()));
                } else {
                    Intent openLiveActivity = new Intent(context, LiveActivity.class);
                    context.startActivity(openLiveActivity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bannerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgBanners;
        TextView txtBannerTitle;

        ViewHolder(View itemView) {
            super(itemView);
            imgBanners = itemView.findViewById(R.id.imgBanners);
            txtBannerTitle = itemView.findViewById(R.id.txtBannerTitle);
        }
    }
}