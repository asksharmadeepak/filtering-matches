package com.example.demo.entity;

import java.math.BigDecimal;

/**
 * Created by dsm2061 on 12/3/18.
 */
public class City {

    private String name;
    private BigDecimal lat;
    private BigDecimal lon;

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }
}
