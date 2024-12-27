package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.CustomerDao;
import com.rabex.express.model.Customer;
import com.rabex.express.services.CustomerService;
import jakarta.inject.Inject;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Inject
    private CustomerDao customerDao;
    @Inject
    private AddressDao addressDao;

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

    @Override
    public boolean delete(RID id) {
        return customerDao.deleteById(id);
    }

    @Override
    public boolean deleteAddress(RID addressId, RID customerId) {
        return false;
    }
}
