package com.sports.basketballwhale.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Scores {
    @SerializedName("data")
    private List<Datum> data = null;

    public List<Datum> getData() {
        return data;
    }

    public static class Datum{
        @SerializedName("id")
        private Integer id;
        @SerializedName("slug")
        private String slug;
        @SerializedName("name")
        private String name;
        @SerializedName("status")
        private String status;
        @SerializedName("home_team")
        private Teams homeTeam;
        @SerializedName("away_team")
        private Teams awayTeam;
        @SerializedName("home_score")
        private Score homeScore;
        @SerializedName("away_score")
        private Score awayScore;
        @SerializedName("main_stat")
        private MainStat mainStat;
        @SerializedName("lasted_period")
        private String lastedPeriod;
        @SerializedName("season")
        private Season season;
        @SerializedName("league")
        private League league;

        public Integer getId() {
            return id;
        }

        public String getSlug() {
            return slug;
        }

        public String getName() {
            return name;
        }

        public String getStatus() {
            return status;
        }

        public Teams getHomeTeam() {
            return homeTeam;
        }

        public Teams getAwayTeam() {
            return awayTeam;
        }

        public Score getHomeScore() {
            return homeScore;
        }

        public Score getAwayScore() {
            return awayScore;
        }

        public MainStat getMainStat() {
            return mainStat;
        }

        public String getLastedPeriod() {
            return lastedPeriod;
        }

        public Season getSeason() {
            return season;
        }

        public League getLeague() {
            return league;
        }

        public static class Teams{
            @SerializedName("id")
            private Integer id;
            @SerializedName("slug")
            private String slug;
            @SerializedName("name")
            private String name;
            @SerializedName("name_short")
            private String nameShort;
            @SerializedName("name_full")
            private String nameFull;
            @SerializedName("name_code")
            private String nameCode;
            @SerializedName("has_sub")
            private Boolean hasSub;
            @SerializedName("has_logo")
            private Boolean hasLogo;
            @SerializedName("logo")
            private String logo;
            @SerializedName("gender")
            private String gender;
            @SerializedName("is_nationality")
            private Boolean isNationality;
            @SerializedName("country_code")
            private String countryCode;
            @SerializedName("country")
            private String country;
            @SerializedName("flag")
            private String flag;
            @SerializedName("foundation")
            private String foundation;
            @SerializedName("details")
            private Object details;

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }

            public String getNameShort() {
                return nameShort;
            }

            public String getNameFull() {
                return nameFull;
            }

            public String getNameCode() {
                return nameCode;
            }

            public Boolean getHasSub() {
                return hasSub;
            }

            public Boolean getHasLogo() {
                return hasLogo;
            }

            public String getLogo() {
                return logo;
            }

            public String getGender() {
                return gender;
            }

            public Boolean getNationality() {
                return isNationality;
            }

            public String getCountryCode() {
                return countryCode;
            }

            public String getCountry() {
                return country;
            }

            public String getFlag() {
                return flag;
            }

            public String getFoundation() {
                return foundation;
            }

            public Object getDetails() {
                return details;
            }
        }

        public static class Score{
            @SerializedName("current")
            private Integer current;
            @SerializedName("display")
            private Integer display;
            @SerializedName("period_1")
            private Integer period1;
            @SerializedName("period_2")
            private Integer period2;
            @SerializedName("period_3")
            private Integer period3;
            @SerializedName("period_4")
            private Integer period4;
            @SerializedName("normal_time")
            private Integer normalTime;

            public Integer getCurrent() {
                return current;
            }

            public Integer getDisplay() {
                return display;
            }

            public Integer getPeriod1() {
                return period1;
            }

            public Integer getPeriod2() {
                return period2;
            }

            public Integer getPeriod3() {
                return period3;
            }

            public Integer getPeriod4() {
                return period4;
            }

            public Integer getNormalTime() {
                return normalTime;
            }
        }

        public static class MainStat{
            @SerializedName("free_throws")
            private FreeThrows freeThrows;
            @SerializedName("2_pointers")
            private FreeThrows _2Pointers;
            @SerializedName("3_pointers")
            private FreeThrows _3Pointers;
            @SerializedName("field_goals")
            private FreeThrows fieldGoals;
            @SerializedName("rebounds")
            private FreeThrows rebounds;
            @SerializedName("fouls")
            private FreeThrows fouls;
            @SerializedName("time_spent_in_lead")
            private FreeThrows timeSpentInLead;

            public static class FreeThrows{
                @SerializedName("home")
                private Integer home;
                @SerializedName("away")
                private Integer away;

                public Integer getHome() {
                    return home;
                }

                public Integer getAway() {
                    return away;
                }
            }

            public FreeThrows getFreeThrows() {
                return freeThrows;
            }

            public FreeThrows get_2Pointers() {
                return _2Pointers;
            }

            public FreeThrows get_3Pointers() {
                return _3Pointers;
            }

            public FreeThrows getFieldGoals() {
                return fieldGoals;
            }

            public FreeThrows getRebounds() {
                return rebounds;
            }

            public FreeThrows getFouls() {
                return fouls;
            }

            public FreeThrows getTimeSpentInLead() {
                return timeSpentInLead;
            }
        }
        public static class Season{
            @SerializedName("id")
            private Integer id;
            @SerializedName("slug")
            private String slug;
            @SerializedName("name")
            private String name;
            @SerializedName("year_start")
            private Integer yearStart;
            @SerializedName("year_end")
            private Object yearEnd;

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }

            public Integer getYearStart() {
                return yearStart;
            }

            public Object getYearEnd() {
                return yearEnd;
            }
        }

        public static class League{
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
            @SerializedName("tennis_points")
            private Integer tennisPoints;
            @SerializedName("facts")
            private Object facts;

            public Integer getId() {
                return id;
            }

            public String getSlug() {
                return slug;
            }

            public String getName() {
                return name;
            }

            public Boolean getHasLogo() {
                return hasLogo;
            }

            public String getLogo() {
                return logo;
            }

            public String getStartDate() {
                return startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Integer getPriority() {
                return priority;
            }

            public Integer getTennisPoints() {
                return tennisPoints;
            }

            public Object getFacts() {
                return facts;
            }

        }

    }
}
