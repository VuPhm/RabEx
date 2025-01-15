package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.dto.ShippingAddressForm;
import com.rabex.express.model.Customer;
import com.rabex.express.model.ShippingAddress;

public interface CustomerDao extends Dao<Customer> {
    boolean removeAddress(RID customerId, RID addressId, RID personInfoId);

    boolean addAddress(RID cId, ShippingAddress shippingAddress);

    boolean updateShippingAddress(RID addressId, RID personInfoId, ShippingAddressForm request);

    boolean updateDefaultAddressId(RID cId, RID id);
}
