package com.example.basketballwhale.Model.Banners;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Live {

    @SerializedName("title")
    private String title;
    @SerializedName("embed")
    private String embed;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("date")
    private String date;
    @SerializedName("videos")
    private List<Video> videos = null;

    public String getTitle() {
        return title;
    }

    public String getEmbed() {
        return embed;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDate() {
        return date;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public class Video {

        @SerializedName("title")
        private String title;
        @SerializedName("embed")
        private String embed;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEmbed() {
            return embed;
        }

        public void setEmbed(String embed) {
            this.embed = embed;
        }
    }
}
