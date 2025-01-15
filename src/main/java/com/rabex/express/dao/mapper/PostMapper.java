package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Post;
import com.rabex.express.model.TrackingRecord;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {
    private final String prefix;
    private final Convertor<String, RID> idConvertor = new StringToRidConvertor();

    public PostMapper(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Post mapRow(ResultSet resultSet, int row) throws SQLException {
        return Post.builder()
                .id(idConvertor.convert(resultSet.getString(getPrefix() + "id")))
                // address
                .code(resultSet.getString(getPrefix() + "code"))
                .email(resultSet.getString(getPrefix() + "email"))
                .phoneNumber(resultSet.getString(getPrefix() + "phone_number"))
                //manager
                .createdAt(resultSet.getTimestamp(getPrefix() + "created_at"))
                .modifiedAt(resultSet.getTimestamp(getPrefix() + "modified_at"))

                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
