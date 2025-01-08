package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.ResultSetExtractor;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.CustomerDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultCustomerDaoTest {
    @Test
    void test(){
        CustomerDao customerDao = new DefaultCustomerDao();
        System.out.println(customerDao.findAll());
    }

}