package com.chelo.reyes.Model;
import twitter4j.GeoLocation;
import twitter4j.Place;
/**
 * Created by cheloreyes on 15/04/17.
 */
public class MyPlace {
    private String name;
    private String streetAddress;
    private String countryCode;
    private String id;
    private String country;
    private String placeType;
    private String url;
    private String fullName;
    private double latitude;
    private double longitude;

    public MyPlace(Place place) {
        if(place != null){
            this.name = place.getName();
            this.streetAddress = place.getStreetAddress();
            this.countryCode = place.getCountryCode();
            this.id = place.getId();
            this.country = place.getCountry();
            this.placeType = place.getPlaceType();
            this.url = place.getURL();
            this.fullName = place.getFullName();
            getCordinates(place.getBoundingBoxCoordinates());
        }
    }

    private void getCordinates(GeoLocation[][] boundingBoxCoordinates) {
        if(boundingBoxCoordinates != null){
            for(GeoLocation[] geoLocations: boundingBoxCoordinates){
                for (GeoLocation geo: geoLocations){
                    this.latitude = geo.getLatitude();
                    this.longitude = geo.getLongitude();
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
