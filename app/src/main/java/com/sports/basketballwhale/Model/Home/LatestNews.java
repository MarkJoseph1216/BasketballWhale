package com.sports.basketballwhale.Model.Home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatestNews {
    @SerializedName("data")
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("id")
        private Integer id;
        @SerializedName("slug")
        private String slug;
        @SerializedName("name")
        private String name;
        @SerializedName("has_logo")
        private Boolean hasLogo;
        @SerializedName("logo")
        private String logo;
        @SerializedName("start_date")
        private String startDate;
        @SerializedName("end_date")
        private String endDate;
        @SerializedName("priority")
        private Integer priority;
        @SerializedName("host")
        private Host host;
        @SerializedName("tennis_points")
        private Integer tennisPoints;
        @SerializedName("facts")
        private List<Fact> facts = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getHasLogo() {
            return hasLogo;
        }

        public void setHasLogo(Boolean hasLogo) {
            this.hasLogo = hasLogo;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public Host getHost() {
            return host;
        }

        public void setHost(Host host) {
            this.host = host;
        }

        public Integer getTennisPoints() {
            return tennisPoints;
        }

        public void setTennisPoints(Integer tennisPoints) {
            this.tennisPoints = tennisPoints;
        }

        public List<Fact> getFacts() {
            return facts;
        }

        public void setFacts(List<Fact> facts) {
            this.facts = facts;
        }

        public class Host {

            @SerializedName("country")
            private String country;
            @SerializedName("flag")
            private String flag;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }
        }

        public class Fact {

            @SerializedName("name")
            private String name;
            @SerializedName("value")
            private String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

        }

    }
}
