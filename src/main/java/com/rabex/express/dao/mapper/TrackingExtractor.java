package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.TrackingRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackingExtractor implements ResultSetExtractor<List<TrackingRecord>> {
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();



    @Override
    public List<TrackingRecord> extractData(ResultSet resultSet) throws SQLException {
        Map<RID, TrackingRecord> records = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            RID recordId = idConvertor.convert(resultSet.getString(orderRowMapper.getPrefix() + "id"));


            i++;
        }
        return records.values().stream().toList();
    }
}
