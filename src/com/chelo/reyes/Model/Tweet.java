package com.chelo.reyes.Model;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.URLEntity;

import java.util.*;

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
    private MyPlace place;
    private long retweetCount;
    private boolean sensitive;
    private String lang;
    private Set<String> url;
    private List<String> hashtags;
    private String scope;
    private String userId;

    public Tweet(Status status) {
        if(status != null){
            try{
                this.createAt = status.getCreatedAt();
                this.favoriteCount = status.getFavoriteCount();
                this.id = status.getId();
                this.text = status.getText();
                this.source = status.getSource();
                this.latitude = (status.getGeoLocation()!=null)? status.getGeoLocation().getLatitude(): 0;
                this.longitude = (status.getGeoLocation()!=null)? status.getGeoLocation().getLongitude(): 0;
                this.place = new MyPlace(status.getPlace());
                this.retweetCount = status.getRetweetCount();
                this.sensitive = status.isPossiblySensitive();
                this.lang = status.getLang();
                this.url = getUrlList(status.getURLEntities());
                this.hashtags = getHashtagsList(status.getHashtagEntities());
                this.scope = (status.getScopes()!=null)? status.getScopes().toString(): "";
                this.userId = Long.toString((status.getUser()!=null)? status.getUser().getId(): -1);
            }catch (NullPointerException e){
                System.out.println("Error parsing tweet: " + e.getLocalizedMessage());
            }
        }
    }

    private List<String> getHashtagsList(HashtagEntity[] hashtagEntities) {
        List<String> hashtagsList = new ArrayList<>();
        if(hashtagEntities != null){
            for(HashtagEntity entity: hashtagEntities){
                hashtagsList.add(entity.getText());
            }
        }
        return hashtagsList;
    }

    private Set<String> getUrlList(URLEntity[] urlEntities) {
        Set<String> urlList  = new HashSet<>();
        if(urlEntities != null){
            for(URLEntity entity: urlEntities){
                urlList.add(entity.getURL());
            }
        }
        return urlList;
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

    public MyPlace getPlace() {
        return place;
    }

    public void setPlace(MyPlace place) {
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


