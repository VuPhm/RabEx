package com.rabex.express.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrimitiveMapper<T> implements RowMapper<T> {

    private Class<T> claszz;

    public PrimitiveMapper(Class<T> claszz) {
        this.claszz = claszz;
    }

    @Override
    public T mapRow(ResultSet resultSet, int row) throws SQLException {
        return resultSet.getObject(1, claszz);
    }
}
