package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.CustomerDao;
import com.rabex.express.model.Customer;
import com.rabex.express.services.CustomerService;
import jakarta.inject.Inject;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Inject
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public int countAll() {
        return customerDao.countAll();
    }

    @Override
    public Customer findById(RID id) {
        return customerDao.findById(id).orElse(null);
    }
}
