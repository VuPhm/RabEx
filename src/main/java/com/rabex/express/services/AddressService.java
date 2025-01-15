package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    // Show all
    List<Address> getAllAddresses();

    int countAll();
    // Tìm địa chỉ theo id
    Optional<Address> getAddressById(RID id);

    // Thêm địa chỉ mới
    boolean addAddress(Address address) throws IllegalArgumentException;
    // Cập nhật địa chỉ
    boolean updateAddress(RID id, Address address) throws IllegalArgumentException;
    // Xoá địa chỉ
    boolean deleteAddress(RID id);
}
