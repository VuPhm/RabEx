package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

public class Involce {
    private RID id;
    private double cost;
    private double converted_unit;
    private Status status;
    private double real_unit;
    private enum Status{};

    public Involce() {
    }

    public Involce(RID id, double cost, double converted_unit, Status status, double real_unit) {
        this.id = id;
        this.cost = cost;
        this.converted_unit = converted_unit;
        this.status = status;
        this.real_unit = real_unit;
    }

    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getConverted_unit() {
        return converted_unit;
    }

    public void setConverted_unit(double converted_unit) {
        this.converted_unit = converted_unit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getReal_unit() {
        return real_unit;
    }

    public void setReal_unit(double real_unit) {
        this.real_unit = real_unit;
    }
}
