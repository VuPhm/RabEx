package com.rabex.express.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    T mapRow(ResultSet resultSet, int row) throws SQLException;

    default String getPrefix(){
        return "";
    }
}
