package com.selbylei.jdbc.entetity;

/**
 * Created by selbylei on 16/12/26.
 */
public class Address extends IdEntity{
    private String city;
    private String country;
    private String userId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
