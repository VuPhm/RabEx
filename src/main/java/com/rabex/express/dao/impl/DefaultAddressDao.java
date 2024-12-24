package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.AddressMapper;
import com.rabex.express.model.Address;

public class DefaultAddressDao extends TemplateDao<Address> implements AddressDao {
    private static final String QUERY_SQL = "SELECT this.id as address_id, this.description as address_des, this.ward as address_ward, this.district as address_dis, this.province as address_pro, this.created_at as address_created_at, this.updated_at as address_updated_at from address this";
    private AddressMapper addressMapper;

    @Override
    public boolean insert(Address address) {
        String insertAddress = "INSERT INTO address(id, description, ward, district, province, created_at ,updated_at) VALUES (?,?,?,?,?,?,?)";
        // Insert new address
        boolean success = insert(insertAddress, address.getId(), address.getDescription(), address.getWard(), address.getDistrict(), address.getDistrict(), address.getCreatedAt(), address.getModifiedAt());
        return success;
    }

    @Override
    public boolean update(RID id, Address address) {
        String updateAddress = "UPDATE address SET description = ?, ward = ?, district = ?, province = ?, updated_at = ? WHERE id = ?";
        // Update address
        return update(updateAddress,
                address.getDescription(),
                address.getWard(),
                address.getDistrict(),
                address.getProvince(),
                address.getModifiedAt()
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
