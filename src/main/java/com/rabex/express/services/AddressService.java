package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;

import java.util.List;

public interface AddressService {
    // Show all
    List<Address> getAllAddresses();

    // Tìm địa chỉ theo id
    Address getAddressById(RID id);

    // Thêm địa chỉ mới
    Address addAddress(Address address) throws IllegalArgumentException;
    // Cập nhật địa chỉ
    Address updateAddress(RID id, Address address) throws IllegalArgumentException;
    // Xoá địa chỉ
    boolean deleteAddress(RID id);
}
