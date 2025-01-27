package com.rabex.express.dao;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.mapper.SurchargeTierMapper;
import com.rabex.express.model.SurchargeTier;

import java.util.List;

public class DefaultSurchargeTierDao extends TemplateDao<SurchargeTier> implements SurchargeTierDao {
    //language=MySQL
    static final String SELECT_QUERY = """
            SELECT st.id AS st_id,
                   st.description AS st_description,
                   st.weight_start AS st_weight_start,
                   st.weight_end AS st_weight_end,
                   st.step_increment AS st_step_increment,
                   st.price_per_step AS st_price_per_step,
                   st.base_price AS st_base_price,
                   st.unit_type AS st_unit_type
            FROM surcharge_tiers st
            
            """;
    RowMapper<SurchargeTier> mapper;

    @Override
    protected RowMapper<SurchargeTier> rowMapper() {
        return mapper == null ? mapper = new SurchargeTierMapper("st_") : mapper;
    }

    @Override
    protected String querySql() {
        return SELECT_QUERY;
    }

    @Override
    public boolean insert(SurchargeTier request) {
        return false;
    }

    @Override
    public boolean update(RID id, SurchargeTier request) {
        return false;
    }

    @Override
    public List<SurchargeTier> findByServiceId(String sid) {
        String findQuery = querySql() + " WHERE service_id = ?";
        return query(findQuery, rowMapper(), sid);
    }
}
