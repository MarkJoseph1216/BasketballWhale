package com.sports.basketballwhale.Adapters.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.sports.basketballwhale.Model.Home.SportsNews;
import com.sports.basketballwhale.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeImageLatestNewsAdapter extends PagerAdapter {

    Context context;
    LayoutInflater mLayoutInflater;
    List<SportsNews.Article> getLatestNews;

    public HomeImageLatestNewsAdapter(Context context, List<SportsNews.Article> getLatestNews){
        this.context = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.getLatestNews = getLatestNews;
    }
    @Override
    public int getCount() {
        return getLatestNews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.home_latest_news_item, container, false);

        SportsNews.Article latestNews = getLatestNews.get(position);

        CircleImageView imgLatestNews =  itemView.findViewById(R.id.imgLatestNews);
        TextView txtItemName = itemView.findViewById(R.id.txtItemName);
        TextView txtAuthorName = itemView.findViewById(R.id.txtAuthorName);
        TextView txtDatePublished = itemView.findViewById(R.id.txtDatePublished);

        Picasso.with(context).load(latestNews.getUrlToImage()).into(imgLatestNews);

        if (latestNews.getAuthor() != null) {
            txtAuthorName.setText(latestNews.getAuthor());
        } else {
            txtAuthorName.setText("No Author Name");
        }

        txtItemName.setText(latestNews.getTitle());

        if (latestNews.getPublishedAt() != null) {
            String formatDateName = latestNews.getPublishedAt().substring(0, 10);
            SimpleDateFormat month_date = new SimpleDateFormat("MMM dd, yyyy ", Locale.ENGLISH);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(formatDateName);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String date_Name = month_date.format(date);
            txtDatePublished.setText("Published At: \n" + date_Name);
        } else {
            txtDatePublished.setText("No Published Date.");
        }

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}