package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.RecordAction;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class TrackingRecord {
    private RID id;
    private String orderCode;
    private String post;
    private RecordAction action;
    private Staff executor;
    private Staff staff;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
