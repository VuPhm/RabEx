package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.TrackingRecordDao;
import com.rabex.express.dao.mapper.OrderMapper;
import com.rabex.express.dao.mapper.PostMapper;
import com.rabex.express.dao.mapper.StaffMapper;
import com.rabex.express.dao.mapper.TrackingRecordMapper;
import com.rabex.express.model.TrackingRecord;

import java.util.List;
import java.util.Optional;

public class TrackingRecordDaoImpl extends TemplateDao<TrackingRecord> implements TrackingRecordDao {
    private final String QUERY = """
            SELECT rec.id AS rec_id,rec.action AS rec_action,rec.created_at AS rec_created_at,rec.updated_at AS rec_updated_at,
                   ord.code AS ord_code,
                   post.title AS post_title,
                   exe.id AS exe_id, exe.post_id AS exe_post_id, exe.position AS exe_position, exe.phone_number AS exe_phone_number, exe.created_at AS exe_created_at, exe.modified_at AS exe_modified_at,
                   stf.id AS stf_id, stf.post_id AS stf_post_id, stf.position AS stf_position, stf.phone_number AS stf_phone_number, stf.created_at AS stf_created_at, stf.modified_at AS stf_modified_at
            FROM tracking_records rec
                     JOIN orders ord ON ord.id = rec.order_id
                     JOIN posts post ON rec.pos_id = post.id
                     JOIN staffs exe ON rec.executed_by = exe.id
                     JOIN staffs stf ON rec.staff = stf.id
            """;
    private RowMapper<TrackingRecord> recMapper;

    @Override
    protected String tableLabel() {
        return "rec";
    }

    @Override
    protected RowMapper<TrackingRecord> rowMapper() {
        return recMapper == null ?
                recMapper = TrackingRecordMapper.builder()
                        .prefix("rec_")
                        .orderMapper(new OrderMapper("ord_"))
                        .postMapper(new PostMapper("post_"))
                        .executorMapper(new StaffMapper("exe_"))
                        .staffMapper(new StaffMapper("stf_"))

                        .build()
                : recMapper;
    }

    @Override
    protected ResultSetExtractor<List<TrackingRecord>> extractor() {
        return super.extractor();
    }

    @Override
    protected String querySql() {
        return QUERY;
    }

    @Override
    public boolean insert(TrackingRecord request) {
        return false;
    }

    @Override
    public Optional<TrackingRecord> findById(RID id) {
        return Optional.empty();
    }

    @Override
    public boolean update(RID id, TrackingRecord request) {
        return false;
    }

    @Override
    public List<TrackingRecord> findByOrderCode(String code) {
        String sql = QUERY + " WHERE ord.code = ?" + " ORDER BY rec.updated_at DESC";
        return query(sql, rowMapper(), code);
    }
}
