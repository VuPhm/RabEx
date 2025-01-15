package com.rabex.express.services.impl;

import com.rabex.express.dao.TrackingRecordDao;
import com.rabex.express.model.TrackingRecord;
import com.rabex.express.services.TrackingService;
import jakarta.inject.Inject;

import java.util.List;

public class TrackingServiceImpl implements TrackingService {

    @Inject
    private TrackingRecordDao trackingRecordDao;
    @Override
    public List<TrackingRecord> searchByOrderCode(String code) {
        return trackingRecordDao.findByOrderCode(code);
    }
}
