package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.CustomerDao;
import com.rabex.express.dao.PersonInfoDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.mapper.AddressMapper;
import com.rabex.express.dao.mapper.CustomerExtractor;
import com.rabex.express.dao.mapper.CustomerMapper;
import com.rabex.express.dao.mapper.PersonInfoMapper;
import com.rabex.express.dto.ShippingAddressForm;
import com.rabex.express.model.*;
import jakarta.inject.Inject;

import java.util.List;

public class DefaultCustomerDao extends TemplateDao<Customer> implements CustomerDao {
    @Inject
    private AddressDao addressDao;
    @Inject
    private PersonInfoDao personInfoDao;
    private static final String QUERY_SQL = "SELECT this.id as cus_id, this.default_address_id as cus_default_address, this.phone_number as cus_phone_number, this.full_name as cus_full_name, this.email as cus_email, this.company_name as cus_company, this.industry as cus_industry, this.channel as cus_channel, a.id as address_id, a.description as address_description, a.ward as address_ward, a.district as address_district, a.province as address_province, a.address_type as address_type, a.created_at as address_created_at, a.modified_at as address_modified_at, pi.id as person_id, pi.phone_number as person_phone_number, pi.full_name as person_full_name, pi.email as person_email FROM customers this LEFT JOIN shipping_address ac ON this.id = ac.customer_id LEFT JOIN address a ON ac.address_id = a.id LEFT JOIN person_info pi ON ac.person_info_id = pi.id";
    private static final String INSERT_SQL = "INSERT INTO customers(id, default_address_id, phone_number, full_name, email, company_name, industry, channel) VALUES(?, ?, ? ,? ,? ,? ,? , ?)";
    private CustomerMapper customerMapper;

    @Override
    protected String table() {
        return "customers";
    }

    @Override
    protected ResultSetExtractor<List<Customer>> extractor() {
        return new CustomerExtractor(rowMapper(), new AddressMapper("address_"), new PersonInfoMapper("person_"));
    }

    @Override
    public boolean insert(Customer customer) {
        return insert(INSERT_SQL, customer.getId(), customer.getDefaultAddressId(), customer.getPhoneNumber(), customer.getFullName(), customer.getEmail(), customer.getCompanyName(), customer.getIndustry(), customer.getChannel());
    }

    @Override
    public boolean update(RID id, Customer customer) {

        return false;
    }

    public boolean removeAddress(RID customerId, RID addressId, RID personInfoId) {
        String sql = "DELETE this FROM shipping_address this WHERE this.address_id = ? AND this.person_info_id = ? AND this.customer_id = ?";
        return update(sql, addressId, personInfoId, customerId);
    }

    public boolean addAddress(RID cId, ShippingAddress shippingAddress) {
        addressDao.insert(shippingAddress.getAddress());
        personInfoDao.insert((shippingAddress.getPersonInfo()));
        String sql = "INSERT INTO shipping_address(address_id, person_info_id, customer_id) VALUE (?, ?, ?)";
        return update(sql, shippingAddress.getAddress().getId(), shippingAddress.getPersonInfo().getId(), cId);
    }

    @Override
    public boolean updateShippingAddress(RID addressId, RID personInfoId, ShippingAddressForm request) {
        Address address = Address.builder()
                .description(request.getDescription())
                .ward(request.getWard())
                .district(request.getDistrict())
                .province(request.getProvince())
                .addressType(request.getAddressType() == null ? null : AddressType.valueOf(request.getAddressType().toUpperCase()))
                .build();
        PersonInfo personInfo = PersonInfo.builder()
                .id(RID.fast())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .build();
        boolean addressSuccess = addressDao.update(addressId, address);
        boolean infoSuccess = personInfoDao.update(personInfoId, personInfo);
        return addressSuccess && infoSuccess;
    }

    @Override
    public boolean updateDefaultAddressId(RID cId, RID rid) {
        String sql = "UPDATE customers SET default_address_id = ? WHERE id = ?";
        return update(sql, cId, rid);
    }


    @Override
    protected RowMapper<Customer> rowMapper() {
        if (customerMapper == null) customerMapper = new CustomerMapper("cus_");
        return customerMapper;
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    protected String countAllSql() {
        return "SELECT COUNT(*) FROM customers";
    }

}
