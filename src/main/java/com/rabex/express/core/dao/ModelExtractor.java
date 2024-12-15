package com.rabex.express.core.dao;



import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelExtractor<T> implements ResultSetExtractor<T> {

    private RowMapper<T> mapper;

    public ModelExtractor(RowMapper<T> mapper) {
        this.mapper = mapper;
    }

    public ModelExtractor() {

    }

    @Override
    public T extractData(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return mapper == null ? (T) resultSet.getObject(1) : mapper.mapRow(resultSet, 0);
        } else {
            return null;
        }
    }
}
