package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.PersonInfoDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PersonInfoMapper;
import com.rabex.express.model.PersonInfo;

public class DefaultPersonInfoDao extends TemplateDao<PersonInfo> implements PersonInfoDao {
    private PersonInfoMapper personInfoMapper;
    private static final String QUERY_SQL = "SELECT this.id, this.phone_number, this.full_name, this.email FROM person_info this";

    @Override
    public boolean insert(PersonInfo personInfo) {
        return insert("INSERT INTO person_info(id, phone_number, full_name, email) VALUES (?, ?, ?, ?)", personInfo.getId(), personInfo.getPhoneNumber(), personInfo.getFullName(), personInfo.getEmail());
    }

    @Override
    public boolean update(RID id, PersonInfo personInfo) {
        String sql = "UPDATE person_info SET phone_number = ?, full_name = ?, email = ? WHERE id = ?";
        return update(sql, personInfo.getPhoneNumber(), personInfo.getFullName(), personInfo.getEmail(), personInfo.getId());
    }

    @Override
    protected RowMapper<PersonInfo> rowMapper() {
        if (personInfoMapper == null) personInfoMapper = new PersonInfoMapper("person_");
        return personInfoMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM person_info;";
    }
}
