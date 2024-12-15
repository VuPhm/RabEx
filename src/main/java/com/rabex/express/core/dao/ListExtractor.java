package com.rabex.express.core.dao;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListExtractor<T> implements ResultSetExtractor<List<T>>{

    private final RowMapper<T> mapper;

    public ListExtractor(RowMapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> extractData(ResultSet resultSet) throws SQLException {
        List<T> list = new ArrayList<>();
        for (int i = 1; resultSet.next(); i++){
            var entity = mapper.mapRow(resultSet, i);
            if(entity != null){
                list.add(entity);
            }
        }
        return list;
    }
}
