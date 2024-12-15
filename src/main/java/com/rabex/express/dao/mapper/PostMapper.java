package com.rabex.express.dao.mapper;


import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.model.Address;
import com.rabex.express.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PostMapper implements RowMapper<Post> {

    private AddressMapper addressMapper;

    private String prefix;

    public PostMapper(String prefix, String addressPrefix) {
        this.prefix = prefix;
        this.addressMapper = new AddressMapper(addressPrefix);
    }

    @Override
    public Post mapRow(ResultSet resultSet, int row) throws SQLException {
        Post post = new Post();
        // mapp ...
        Address address = addressMapper.mapRow(resultSet, row);
        post.setAddress(address);
        return post;
    }
}
