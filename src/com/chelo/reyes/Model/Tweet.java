package com.chelo.reyes.Model;

import twitter4j.Place;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by cheloreyes on 15/04/17.
 */
public class Tweet {
    private Date createAt;
    private long id;
    private String text;
    private String source;
    private int favoriteCount;
    private double latitude;
    private double longitude;
    private Place place;
    private long retweetCount;
    private boolean sensitive;
    private String lang;
    private Set<String> url;
    private List<String> hashtags;
    private String scope;
    private String userId;

    public Tweet(Date createAt, long id, String text, String source, int favoriteCount, double latitude, double longitude, Place place, long retweetCount, boolean sensitive, String lang, Set<String> url, List<String> hashtags, String scope, String userId) {
        this.createAt = createAt;
        this.id = id;
        this.text = text;
        this.source = source;
        this.favoriteCount = favoriteCount;
        this.latitude = latitude;
        this.longitude = longitude;
        this.place = place;
        this.retweetCount = retweetCount;
        this.sensitive = sensitive;
        this.lang = lang;
        this.url = url;
        this.hashtags = hashtags;
        this.scope = scope;
        this.userId = userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public long getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(long retweetCount) {
        this.retweetCount = retweetCount;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Set<String> getUrl() {
        return url;
    }

    public void setUrl(Set<String> url) {
        this.url = url;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}


