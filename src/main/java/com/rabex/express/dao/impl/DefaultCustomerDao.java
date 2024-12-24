package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.CustomerDao;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.model.Customer;

public class DefaultCustomerDao extends TemplateDao<Customer> implements CustomerDao {
    private static final String QUERY_SQL = "SELECT this.id as cus_id" +
            "this.default_address_id as cus_default_address" +
            "this.phone_number as as cus_phone" +
            "this.full_name as cus_full_name" +
            "this.email as cus_email" +
            "this.company_name as cus_company" +
            "this.quantity_order as cus_quantity_order" +
            "this.industry as cus_industry" +
            "this.channel as cus_channel";

    private CustomerMapper customerMapper;
    @Override
    public boolean insert(Customer request) {
        return false;
    }

    @Override
    public boolean update(RID id, Customer request) {
        return false;
    }

    @Override
    protected RowMapper<Customer> rowMapper() {
        return null;
    }

    @Override
    protected String querySql() {
        return null;
    }
}
