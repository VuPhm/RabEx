package com.rabex.express.core.dao;




import com.rabex.express.config.DataSource;
import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;
import jakarta.inject.Inject;

import java.sql.*;
import java.util.List;
import java.util.StringJoiner;


/**
 * abstract repository
 *
 * @author Jakhang
 */
public abstract class AbstractDao<Entity> implements Dao<Entity> {

    @Inject
    private DataSource dataSource;

    private final SortToSqlConvertor sortToSqlConvertor = new SortToSqlConvertor();



    protected Connection connect() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch ( ClassNotFoundException classNotFoundException) {
                throw new DataAccessException("Couldn't found driver class");
            }
            return DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());

    }

    protected <U> U query(String sql, ResultSetExtractor<U> resultSetExtractor, Object... parameters) {
        try (Connection connection = connect()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                setParameter(statement, parameters);
                try(ResultSet resultSet = statement.executeQuery()){
                    return resultSetExtractor.extractData(resultSet);
                }
            }
        } catch (SQLException e) {
           throw new DataAccessException(e.getMessage());
        }
    }

    protected void setParameter(PreparedStatement statement, Object... parameters) {
        int index = 0;
        try {
            for (Object parameter : parameters) {
                index++;
                if (parameter == null)
                    statement.setObject(index, null);
                else if (parameter instanceof String s) {
                    statement.setString(index, s);
                } else if (parameter instanceof Integer i) {
                    statement.setInt(index, i);
                } else if (parameter instanceof Boolean b) {
                    statement.setBoolean(index, b);
                } else if (parameter instanceof Date d) {
                    statement.setDate(index, d);
                } else if (parameter instanceof Long l) {
                    statement.setLong(index, l);
                } else if (parameter instanceof Enum<?> e) {
                    statement.setString(index, e.toString());
                } else if(parameter instanceof RID rid){
                    statement.setBytes(index, rid.toBytes());
                } else {
                    assert parameter != null;
                    statement.setString(index, parameter.toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected <U> List<U> query(String sql, RowMapper<U> mapper, Object... parameters) {
        return query(sql, new ListExtractor<>(mapper), parameters);
    }

    protected <U> Page<U> queryPage(String querySql, String countSql, Pageable pageable, RowMapper<U> mapper, Object... params) {
        String sql = generatePaginationSql(querySql, pageable);
        List<U> content = query(sql, mapper, params);
        int total = count(countSql, params);
        return Page.of(content, total, pageable);
    }

    protected <U> Page<U> queryPage(String querySql, String countSql, Pageable pageable, ResultSetExtractor<List<U>> mapper, Object... params) {
        String sql = generatePaginationSql(querySql, pageable);
        List<U> content = query(sql, mapper, params);
        int total = count(countSql, params);
        return Page.of(content, total, pageable);
    }

    private String generatePaginationSql(String querySql, Pageable pageable) {
        return new StringJoiner(" ")
                .add(querySql)
                .add(sortToSqlConvertor.convert(pageable.getSort()))
                .add("LIMIT")
                .add(String.valueOf(pageable.getLimit()))
                .add("OFFSET")
                .add(String.valueOf(pageable.getOffset()))
                .toString();
    }

    protected <U> U singleQuery(String sql, RowMapper<U> mapper, Object... parameters) {
        return query(sql, new ModelExtractor<>(mapper), parameters);
    }

    protected int count(String sql, Object... parameters) {
        return query(sql, new ModelExtractor<>(new PrimitiveMapper<>(Integer.class)), parameters);
    }

    protected boolean insert(String sql, Object... parameters) {
        ResultSet resultSet = null;
        try (Connection connection = connect()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                setParameter(statement, parameters);
                statement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected boolean update(String sql, Object... parameters) {
        try (Connection connection = connect()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                setParameter(statement, parameters);
                return statement.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    protected <U> U executeTransaction(TransactionCallback<U> callback) {
        Connection connection = null;
        try {
            connection = connect();
            connection.setAutoCommit(false);
            U u = callback.doCallBack(connection);
            connection.commit();
            return u;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



    /*------------------
          Ov
    --------------------*/
}