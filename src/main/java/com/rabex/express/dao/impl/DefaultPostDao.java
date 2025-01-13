package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.PostDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.PostMapper;
import com.rabex.express.model.Post;

public class DefaultPostDao extends TemplateDao<Post> implements PostDao {
    private PostMapper postMapper;

    @Override
    protected RowMapper<Post> rowMapper() {
        if (postMapper == null) postMapper = new PostMapper("post_", "manager_", "address_");
        return postMapper;
    }

    @Override
    protected String querySql() {
        // TODO (PC, 18/12/2024): To change the body of an implemented method
        return "";
    }

    @Override
    public boolean insert(Post request) {
        // TODO (PC, 18/12/2024): To change the body of an implemented method
        return false;
    }

    @Override
    public boolean update(RID id, Post request) {
        // TODO (PC, 18/12/2024): To change the body of an implemented method
        return false;
    }
}
