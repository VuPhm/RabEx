package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.ShippingAddressForm;
import com.rabex.express.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    int countAll();

    // Tìm địa chỉ theo id
    Customer findById(RID id);

    boolean delete(RID id);
    boolean updateShippingAddress(RID aId, RID pId, ShippingAddressForm request);

    boolean addAddress(RID cId, ShippingAddressForm shippingAddress);

    boolean removeAddress(RID customerId, RID addressId, RID personInfoId);
}
