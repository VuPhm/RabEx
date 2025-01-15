package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.enumm.TrackingStatus;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class TrackingRecord {
    private RID id;
    private Post post;
    private Order order;
    private TrackingStatus status;
    private Staff trackingBy;
    private Post destination;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
