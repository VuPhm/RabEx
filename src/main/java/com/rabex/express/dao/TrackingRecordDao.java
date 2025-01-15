package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.TrackingRecord;

import java.util.List;

public interface TrackingRecordDao {
    List<TrackingRecord> findByOrderCode(String code);
}
