package com.rabex.express.model;

import com.rabex.express.core.dao.RID;

public class Post {
    private RID id;                // char(16)
    private Address address;         // char(16)
    private String code;              // char(16)
    private String email;             // varchar(320)
    private String phoneNumber;       // varchar(10)
    private RID managerId;         // char(16)

    public Post() {
    }

    public Post(RID id, Address address, String code, String email, String phoneNumber, RID managerId) {
        this.id = id;
        this.address = address;
        this.code = code;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.managerId = managerId;
    }

    // Getter và Setter cho từng thuộc tính
    public RID getId() {
        return id;
    }

    public void setId(RID id) {
        this.id = id;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RID getManagerId() {
        return managerId;
    }

    public void setManagerId(RID managerId) {
        this.managerId = managerId;
    }

}

