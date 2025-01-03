package com.rabex.express.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {

    T extractData(ResultSet resultSet) throws SQLException;

}
