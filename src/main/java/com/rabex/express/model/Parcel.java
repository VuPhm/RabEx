package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

import java.sql.Timestamp;

public class Parcel {
    private RID id;
    private double weight;
    private RID created_by;
    private Timestamp created_at;
    private Timestamp modified_at;
    private boolean fragment;

    public RID getId() {
        return id;
    }

    public Parcel(RID id, double weight, RID created_by, Timestamp created_at, Timestamp modified_at, boolean fragment) {
        this.id = id;
        this.weight = weight;
        this.created_by = created_by;
        this.created_at = created_at;
        this.modified_at = modified_at;
        this.fragment = fragment;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public RID getCreated_by() {
        return created_by;
    }

    public void setCreated_by(RID created_by) {
        this.created_by = created_by;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }

    public boolean isFragment() {
        return fragment;
    }

    public void setFragment(boolean fragment) {
        this.fragment = fragment;
    }

    public Parcel() {
    }
}
