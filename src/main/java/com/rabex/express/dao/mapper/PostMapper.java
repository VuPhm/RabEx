package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Address;
import com.rabex.express.model.Post;
import com.rabex.express.model.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {

    private final String prefix;
    private final Convertor<String, RID> ridConvertor;
    private final RowMapper<Staff> staffRowMapper;
    private final RowMapper<Address> addressRowMapper;

    public PostMapper(String prefix, Convertor<String, RID> ridConvertor, RowMapper<Staff> staffRowMapper, RowMapper<Address> addressRowMapper) {
        this.prefix = prefix;
        this.ridConvertor = ridConvertor;
        this.staffRowMapper = staffRowMapper;
        this.addressRowMapper = addressRowMapper;
    }

    public PostMapper(String prefix, String staffPrefix, String addressPrefix) {
        this.ridConvertor = new StringToRidConvertor();
        this.addressRowMapper = new AddressMapper(addressPrefix, ridConvertor);
        this.staffRowMapper = new ShortStaffMapper(staffPrefix, ridConvertor);
        this.prefix = prefix;

    }

    @Override
    public Post mapRow(ResultSet rs, int row) throws SQLException {
        Staff staff = staffRowMapper.mapRow(rs, row);
        Address address = addressRowMapper.mapRow(rs, row);
        return Post.builder()
                .id(ridConvertor.convert(rs.getString(getPrefix() + "id")))
                .code(rs.getString(getPrefix() + "code"))
                .email(rs.getString(getPrefix() + "email"))
                .phoneNumber(rs.getString(getPrefix() + "phone_number"))
                .createdAt(rs.getTimestamp(getPrefix() + "created_at"))
                .modifiedAt(rs.getTimestamp(getPrefix() + "modified_at"))
                .manager(staff)
                .address(address)
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
