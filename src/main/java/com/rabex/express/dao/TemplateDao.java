package com.rabex.express.dao;

import com.rabex.express.core.dao.*;
import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;

import java.util.List;

public abstract class TemplateDao<T> extends AbstractDao<T> {
    protected ResultSetExtractor<List<T>> extractor() {
        return new ListExtractor<>(rowMapper());
    }

    protected abstract RowMapper<T> rowMapper();

    protected abstract String querySql();

    protected abstract String countAllSql();

    @Override
    public T findById(RID id) {
        String sql = querySql() + "WHERE id = ?";
        List<T> entities = query(sql, extractor(), id);
        return entities.isEmpty() ? null : entities.get(0);
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
}
