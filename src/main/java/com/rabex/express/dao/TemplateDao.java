package com.rabex.express.dao;

import com.rabex.express.core.dao.*;
import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;

import java.util.List;
import java.util.Optional;

public abstract class TemplateDao<T> extends AbstractDao<T> {
    protected ResultSetExtractor<List<T>> extractor() {
        return new ListExtractor<>(rowMapper());
    }

    protected abstract RowMapper<T> rowMapper();

    protected abstract String querySql();

    protected String countAllSql(){
        return "SELECT COUNT(*) FROM " + table();
    }

    protected String tableLabel() {
        return "this";
    }

    protected String table(){
        return "";
    }

    @Override
    public Optional<T> findById(RID id) {
        String sql = querySql() + " WHERE " + tableLabel() + ".id = ?";
        List<T> entities = query(sql, extractor(), id);
        return entities.stream().findFirst();
    }

    @Override
    public List<T> findAll() {
        String sql = querySql();
        return query(sql, extractor());
    }

    @Override
    public int countAll() {
        return count(countAllSql());
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return queryPage(querySql(), countAllSql(), pageable, extractor());
    }

    @Override
    public boolean deleteById(RID id) {
        String sql = "DELETE FROM " + table() + " WHERE id = ?";
        return update(sql, id);
    }
}
