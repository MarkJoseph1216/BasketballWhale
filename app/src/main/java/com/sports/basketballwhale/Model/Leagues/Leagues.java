package com.sports.basketballwhale.Model.Leagues;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Leagues {
    @SerializedName("data")
    private List<Datum> data = null;
    @SerializedName("links")

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
        @SerializedName("status")
        private String status;
        @SerializedName("status_more")
        private String statusMore;
        @SerializedName("time_details")
        private Object timeDetails;
        @SerializedName("home_team")
        private Team homeTeam;
        @SerializedName("away_team")
        private Team awayTeam;
        @SerializedName("start_at")
        private String startAt;
        @SerializedName("priority")
        private Integer priority;
        @SerializedName("home_score")
        private Score homeScore;
        @SerializedName("away_score")
        private Score awayScore;
        @SerializedName("winner_code")
        private Integer winnerCode;
        @SerializedName("aggregated_winner_code")
        private Object aggregatedWinnerCode;
        @SerializedName("result_only")
        private Boolean resultOnly;
        @SerializedName("coverage")
        private Object coverage;
        @SerializedName("ground_type")
        private Object groundType;
        @SerializedName("round_info")
        private Object roundInfo;
        @SerializedName("round_number")
        private Object roundNumber;
        @SerializedName("main_odds")
        private List<Object> mainOdds = null;
        @SerializedName("series_count")
        private Integer seriesCount;
        @SerializedName("medias_count")
        private Object mediasCount;
        @SerializedName("status_lineup")
        private Object statusLineup;
        @SerializedName("first_supply")
        private Object firstSupply;
        @SerializedName("cards_code")
        private Object cardsCode;
        @SerializedName("main_stat")
        private MainStat mainStat;
        @SerializedName("lasted_period")
        private String lastedPeriod;
        @SerializedName("default_period_count")
        private Integer defaultPeriodCount;
        @SerializedName("attendance")
        private Object attendance;
        @SerializedName("cup_match_order")
        private Object cupMatchOrder;
        @SerializedName("cup_match_in_round")
        private Object cupMatchInRound;
        @SerializedName("season")
        private Object season;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatusMore() {
            return statusMore;
        }

        public void setStatusMore(String statusMore) {
            this.statusMore = statusMore;
        }

        public Object getTimeDetails() {
            return timeDetails;
        }

        public void setTimeDetails(Object timeDetails) {
            this.timeDetails = timeDetails;
        }

        public Team getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(Team homeTeam) {
            this.homeTeam = homeTeam;
        }

        public Team getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(Team awayTeam) {
            this.awayTeam = awayTeam;
        }

        public String getStartAt() {
            return startAt;
        }

        public void setStartAt(String startAt) {
            this.startAt = startAt;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        public Score getHomeScore() {
            return homeScore;
        }

        public void setHomeScore(Score homeScore) {
            this.homeScore = homeScore;
        }

        public Score getAwayScore() {
            return awayScore;
        }

        public void setAwayScore(Score awayScore) {
            this.awayScore = awayScore;
        }

        public Integer getWinnerCode() {
            return winnerCode;
        }

        public void setWinnerCode(Integer winnerCode) {
            this.winnerCode = winnerCode;
        }

        public Object getAggregatedWinnerCode() {
            return aggregatedWinnerCode;
        }

        public void setAggregatedWinnerCode(Object aggregatedWinnerCode) {
            this.aggregatedWinnerCode = aggregatedWinnerCode;
        }

        public Boolean getResultOnly() {
            return resultOnly;
        }

        public void setResultOnly(Boolean resultOnly) {
            this.resultOnly = resultOnly;
        }

        public Object getCoverage() {
            return coverage;
        }

        public void setCoverage(Object coverage) {
            this.coverage = coverage;
        }

        public Object getGroundType() {
            return groundType;
        }

        public void setGroundType(Object groundType) {
            this.groundType = groundType;
        }

        public Object getRoundInfo() {
            return roundInfo;
        }

        public void setRoundInfo(Object roundInfo) {
            this.roundInfo = roundInfo;
        }

        public Object getRoundNumber() {
            return roundNumber;
        }

        public void setRoundNumber(Object roundNumber) {
            this.roundNumber = roundNumber;
        }

        public List<Object> getMainOdds() {
            return mainOdds;
        }

        public void setMainOdds(List<Object> mainOdds) {
            this.mainOdds = mainOdds;
        }

        public Integer getSeriesCount() {
            return seriesCount;
        }

        public void setSeriesCount(Integer seriesCount) {
            this.seriesCount = seriesCount;
        }

        public Object getMediasCount() {
            return mediasCount;
        }

        public void setMediasCount(Object mediasCount) {
            this.mediasCount = mediasCount;
        }

        public Object getStatusLineup() {
            return statusLineup;
        }

        public void setStatusLineup(Object statusLineup) {
            this.statusLineup = statusLineup;
        }

        public Object getFirstSupply() {
            return firstSupply;
        }

        public void setFirstSupply(Object firstSupply) {
            this.firstSupply = firstSupply;
        }

        public Object getCardsCode() {
            return cardsCode;
        }

        public void setCardsCode(Object cardsCode) {
            this.cardsCode = cardsCode;
        }

        public MainStat getMainStat() {
            return mainStat;
        }

        public void setMainStat(MainStat mainStat) {
            this.mainStat = mainStat;
        }

        public Integer getDefaultPeriodCount() {
            return defaultPeriodCount;
        }

        public void setDefaultPeriodCount(Integer defaultPeriodCount) {
            this.defaultPeriodCount = defaultPeriodCount;
        }

        public Object getAttendance() {
            return attendance;
        }

        public void setAttendance(Object attendance) {
            this.attendance = attendance;
        }

        public Object getCupMatchOrder() {
            return cupMatchOrder;
        }

        public void setCupMatchOrder(Object cupMatchOrder) {
            this.cupMatchOrder = cupMatchOrder;
        }

        public Object getCupMatchInRound() {
            return cupMatchInRound;
        }

        public void setCupMatchInRound(Object cupMatchInRound) {
            this.cupMatchInRound = cupMatchInRound;
        }

        public Object getSeason() {
            return season;
        }

        public void setSeason(Object season) {
            this.season = season;
        }

        public class Team {

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
            private Object gender;
            @SerializedName("is_nationality")
            private Boolean isNationality;
            @SerializedName("country_code")
            private Object countryCode;
            @SerializedName("country")
            private Object country;
            @SerializedName("flag")
            private Object flag;
            @SerializedName("foundation")
            private String foundation;
            @SerializedName("details")
            private Object details;

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

            public String getNameShort() {
                return nameShort;
            }

            public void setNameShort(String nameShort) {
                this.nameShort = nameShort;
            }

            public String getNameFull() {
                return nameFull;
            }

            public void setNameFull(String nameFull) {
                this.nameFull = nameFull;
            }

            public String getNameCode() {
                return nameCode;
            }

            public void setNameCode(String nameCode) {
                this.nameCode = nameCode;
            }

            public Boolean getHasSub() {
                return hasSub;
            }

            public void setHasSub(Boolean hasSub) {
                this.hasSub = hasSub;
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

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Boolean getIsNationality() {
                return isNationality;
            }

            public void setIsNationality(Boolean isNationality) {
                this.isNationality = isNationality;
            }

            public Object getCountryCode() {
                return countryCode;
            }

            public void setCountryCode(Object countryCode) {
                this.countryCode = countryCode;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getFlag() {
                return flag;
            }

            public void setFlag(Object flag) {
                this.flag = flag;
            }

            public String getFoundation() {
                return foundation;
            }

            public void setFoundation(String foundation) {
                this.foundation = foundation;
            }

            public Object getDetails() {
                return details;
            }

            public void setDetails(Object details) {
                this.details = details;
            }

        }

        public class Score {

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

            public Integer getCurrent() {
                return current;
            }

            public void setCurrent(Integer current) {
                this.current = current;
            }

            public Integer getDisplay() {
                return display;
            }

            public void setDisplay(Integer display) {
                this.display = display;
            }

            public Integer getPeriod1() {
                return period1;
            }

            public void setPeriod1(Integer period1) {
                this.period1 = period1;
            }

            public Integer getPeriod2() {
                return period2;
            }

            public void setPeriod2(Integer period2) {
                this.period2 = period2;
            }

            public Integer getPeriod3() {
                return period3;
            }

            public void setPeriod3(Integer period3) {
                this.period3 = period3;
            }

            public Integer getPeriod4() {
                return period4;
            }

            public void setPeriod4(Integer period4) {
                this.period4 = period4;
            }

        }

        public class MainStat {

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

            public FreeThrows getFreeThrows() {
                return freeThrows;
            }

            public void setFreeThrows(FreeThrows freeThrows) {
                this.freeThrows = freeThrows;
            }

            public FreeThrows get2Pointers() {
                return _2Pointers;
            }

            public void set2Pointers(FreeThrows _2Pointers) {
                this._2Pointers = _2Pointers;
            }

            public FreeThrows get3Pointers() {
                return _3Pointers;
            }

            public void set3Pointers(FreeThrows _3Pointers) {
                this._3Pointers = _3Pointers;
            }

            public FreeThrows getFieldGoals() {
                return fieldGoals;
            }

            public void setFieldGoals(FreeThrows fieldGoals) {
                this.fieldGoals = fieldGoals;
            }

            public FreeThrows getRebounds() {
                return rebounds;
            }

            public void setRebounds(FreeThrows rebounds) {
                this.rebounds = rebounds;
            }

            public FreeThrows getFouls() {
                return fouls;
            }

            public void setFouls(FreeThrows fouls) {
                this.fouls = fouls;
            }

            public FreeThrows getTimeSpentInLead() {
                return timeSpentInLead;
            }

            public void setTimeSpentInLead(FreeThrows timeSpentInLead) {
                this.timeSpentInLead = timeSpentInLead;
            }

            public class FreeThrows {

                @SerializedName("home")
                private Integer home;
                @SerializedName("away")
                private Integer away;

                public Integer getHome() {
                    return home;
                }

                public void setHome(Integer home) {
                    this.home = home;
                }

                public Integer getAway() {
                    return away;
                }

                public void setAway(Integer away) {
                    this.away = away;
                }
            }
        }
    }
}
