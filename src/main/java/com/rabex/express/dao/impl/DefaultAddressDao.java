package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.AddressMapper;
import com.rabex.express.model.Address;
import jakarta.inject.Singleton;

@Singleton
public class DefaultAddressDao extends TemplateDao<Address> implements AddressDao {
    private static final String QUERY_SQL = "SELECT this.id as address_id, this.description as address_description, this.ward as address_ward, this.district as address_district, this.province as address_province, this.address_type as address_type, this.created_at as address_created_at, this.modified_at as address_modified_at FROM address this";
    private static final String INSERT_SQL = "INSERT INTO address(id, description, ward, district, province, address_type, created_at, modified_at) VALUES(?, ?, ? ,? ,? ,? ,? ,?)";

    private AddressMapper addressMapper;

    public DefaultAddressDao() {
    }


    @Override
    public boolean insert(Address address) {
        return insert(INSERT_SQL, address.getId(), address.getDescription(), address.getWard(), address.getDistrict(), address.getProvince(), address.getAddressType(), address.getCreatedAt(), address.getModifiedAt());
    }


    @Override
    public boolean update(RID id, Address address) {
        String updateAddress = "UPDATE address SET description = ?, ward = ?, district = ?, province = ?, address_type =?, modified_at = ? WHERE id = ?";
        // Update address
        return update(updateAddress,
                address.getDescription(),
                address.getWard(),
                address.getDistrict(),
                address.getProvince(),
                address.getAddressType(),
                address.getModifiedAt(),
                id
        );
    }

    @Override
    public boolean delete(RID id) {
        String deleteAddress = "DELETE FROM address WHERE id = ?";
        // Delete address
        return update(deleteAddress, id);
    }

    @Override
    protected RowMapper<Address> rowMapper() {
        if (addressMapper == null)
            addressMapper = new AddressMapper("address_");
        return addressMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM address";
    }

}
