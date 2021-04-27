package com.bis.ca2is4448.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Generated by https://www.jsonschema2pojo.org/
public class CovidStat {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("Province")
    @Expose
    private String province;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("CityCode")
    @Expose
    private String cityCode;
    @SerializedName("Lat")
    @Expose
    private String lat;
    @SerializedName("Lon")
    @Expose
    private String lon;
    @SerializedName("Confirmed")
    @Expose
    private int confirmed;
    @SerializedName("Deaths")
    @Expose
    private int deaths;
    @SerializedName("Recovered")
    @Expose
    private int recovered;
    @SerializedName("Active")
    @Expose
    private int active;
    @SerializedName("Date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     *
     */
    public CovidStat() {
    }

    /**
     *
     * @param date
     * @param country
     * @param city
     * @param cityCode
     * @param active
     * @param lon
     * @param confirmed
     * @param recovered
     * @param province
     * @param countryCode
     * @param iD
     * @param lat
     * @param deaths
     */
    public CovidStat(String iD, String country, String countryCode, String province, String city, String cityCode, String lat, String lon, int confirmed, int deaths, int recovered, int active, String date) {
        super();
        this.iD = iD;
        this.country = country;
        this.countryCode = countryCode;
        this.province = province;
        this.city = city;
        this.cityCode = cityCode;
        this.lat = lat;
        this.lon = lon;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.active = active;
        this.date = date;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}