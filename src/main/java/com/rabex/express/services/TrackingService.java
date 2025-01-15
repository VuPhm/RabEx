package com.rabex.express.services;

import com.rabex.express.model.TrackingRecord;

import java.util.List;

public interface TrackingService {
    List<TrackingRecord> searchByOrderCode(String code);
}
