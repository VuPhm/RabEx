package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;
import com.rabex.express.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    int countAll();
    // Tìm địa chỉ theo id
    Customer findById(RID id);
    boolean delete(RID id);
    boolean deleteAddress(RID addressId, RID customerId);
}
