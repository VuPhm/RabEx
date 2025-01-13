package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
@Getter
@Setter
@Builder
@ToString
public class Parcel {
    private RID id;
    private RID creatorId;
//    private User creator;
    private String name;
    private double weight;
    private double longg;
    private double high;
    private double wide;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private boolean fragile;
}
