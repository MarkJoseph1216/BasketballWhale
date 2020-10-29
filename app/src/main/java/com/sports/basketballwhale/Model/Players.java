package com.sports.basketballwhale.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Players {

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
        @SerializedName("name_translations")
        private NameTranslations nameTranslations;
        @SerializedName("name_short")
        private String nameShort;
        @SerializedName("has_photo")
        private Boolean hasPhoto;
        @SerializedName("photo")
        private String photo;
        @SerializedName("position")
        private String position;
        @SerializedName("weight")
        private Object weight;
        @SerializedName("age")
        private Integer age;
        @SerializedName("date_birth_at")
        private String dateBirthAt;
        @SerializedName("height")
        private Double height;
        @SerializedName("shirt_number")
        private Integer shirtNumber;
        @SerializedName("preferred_foot")
        private Object preferredFoot;
        @SerializedName("nationality_code")
        private String nationalityCode;
        @SerializedName("flag")
        private String flag;
        @SerializedName("market_currency")
        private String marketCurrency;
        @SerializedName("market_value")
        private Object marketValue;
        @SerializedName("contract_until")
        private String contractUntil;
        @SerializedName("rating")
        private Object rating;
        @SerializedName("characteristics")
        private Object characteristics;
        @SerializedName("positions")
        private Object positions;
        @SerializedName("ability")
        private Object ability;

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

        public NameTranslations getNameTranslations() {
            return nameTranslations;
        }

        public void setNameTranslations(NameTranslations nameTranslations) {
            this.nameTranslations = nameTranslations;
        }

        public String getNameShort() {
            return nameShort;
        }

        public void setNameShort(String nameShort) {
            this.nameShort = nameShort;
        }

        public Boolean getHasPhoto() {
            return hasPhoto;
        }

        public void setHasPhoto(Boolean hasPhoto) {
            this.hasPhoto = hasPhoto;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Object getWeight() {
            return weight;
        }

        public void setWeight(Object weight) {
            this.weight = weight;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getDateBirthAt() {
            return dateBirthAt;
        }

        public void setDateBirthAt(String dateBirthAt) {
            this.dateBirthAt = dateBirthAt;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        public Integer getShirtNumber() {
            return shirtNumber;
        }

        public void setShirtNumber(Integer shirtNumber) {
            this.shirtNumber = shirtNumber;
        }

        public Object getPreferredFoot() {
            return preferredFoot;
        }

        public void setPreferredFoot(Object preferredFoot) {
            this.preferredFoot = preferredFoot;
        }

        public String getNationalityCode() {
            return nationalityCode;
        }

        public void setNationalityCode(String nationalityCode) {
            this.nationalityCode = nationalityCode;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getMarketCurrency() {
            return marketCurrency;
        }

        public void setMarketCurrency(String marketCurrency) {
            this.marketCurrency = marketCurrency;
        }

        public Object getMarketValue() {
            return marketValue;
        }

        public void setMarketValue(Object marketValue) {
            this.marketValue = marketValue;
        }

        public String getContractUntil() {
            return contractUntil;
        }

        public void setContractUntil(String contractUntil) {
            this.contractUntil = contractUntil;
        }

        public Object getRating() {
            return rating;
        }

        public void setRating(Object rating) {
            this.rating = rating;
        }

        public Object getCharacteristics() {
            return characteristics;
        }

        public void setCharacteristics(Object characteristics) {
            this.characteristics = characteristics;
        }

        public Object getPositions() {
            return positions;
        }

        public void setPositions(Object positions) {
            this.positions = positions;
        }

        public Object getAbility() {
            return ability;
        }

        public void setAbility(Object ability) {
            this.ability = ability;
        }

        public class NameTranslations {
            @SerializedName("en")
            private String en;

            public String getEn() {
                return en;
            }

            public void setEn(String en) {
                this.en = en;
            }

        }

    }
}
