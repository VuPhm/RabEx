package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

import java.sql.Timestamp;

public class Address {
    private RID id;              // char(16)
    private String description;     // text
    private String ward;            // varchar(45)
    private String district;        // varchar(45)
    private String province;        // varchar(45)
    private Timestamp createdAt;    // timestamp
    private Timestamp updateAt;   // timestamp

    public Address() {
    }

    public Address(RID id, String description, String ward, String district, String province,
                   Timestamp createdAt, Timestamp updateAt) {
        this.id = id;
        this.description = description;
        this.ward = ward;
        this.district = district;
        this.province = province;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    // Các phương thức getter và setter cho từng thuộc tính
    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", ward='" + ward + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + updateAt +
                '}';
    }
}

