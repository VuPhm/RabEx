package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

import java.sql.Timestamp;

public class Parcel {
    private RID id;
    private String name;
    private double weight;
    private double longg;
    private double high;
    private double wide;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private boolean fragile;

    public Parcel() {
    }

    public Parcel(RID id, String name, double weight, double longg, double high, double wide, Timestamp created_at, Timestamp modified_at, boolean fragile) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.longg = longg;
        this.high = high;
        this.wide = wide;
        this.createdAt = created_at;
        this.modifiedAt = modified_at;
        this.fragile = fragile;
    }

    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLongg() {
        return longg;
    }

    public void setLongg(double longg) {
        this.longg = longg;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getWide() {
        return wide;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
}
