package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.dao.CustomerDao;
import com.rabex.express.dto.ShippingAddressForm;
import com.rabex.express.model.*;
import com.rabex.express.model.enumm.AddressType;
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
    public boolean updateShippingAddress(RID aId, RID pId, ShippingAddressForm request) {
        return customerDao.updateShippingAddress(aId, pId, request);
    }

    @Override
    public boolean addAddress(RID cId, ShippingAddressForm request) {
        //address format province/district/ward dung split de cat ra
        String[] paths = request.getAddress().split("/");

        if (paths.length != 3)
            return false;
        Address address = Address.builder()
                .id(RID.fast())
                .description(request.getDescription())
                .ward(paths[2].trim())
                .district(paths[1].trim())
                .province(paths[0].trim())
                .addressType(AddressType.valueOf(request.getAddressType()))
                .build();
        PersonInfo personInfo = PersonInfo.builder()
                .id(RID.fast())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .build();
        ShippingAddress shippingAddress = new ShippingAddress(address, personInfo);
        boolean success = customerDao.addAddress(cId, shippingAddress);
        if (success && Boolean.TRUE.equals(request.getAddressDefault())) {
            // Cập nhật default_address_id
            return customerDao.updateDefaultAddressId(cId, shippingAddress.getAddress().getId());
        }
        return success;
    }

    @Override
    public boolean removeAddress(RID customerId, RID addressId, RID personInfoId) {
        return customerDao.removeAddress(customerId,addressId,personInfoId);
    }


}
