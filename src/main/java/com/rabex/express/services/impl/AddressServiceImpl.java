package com.rabex.express.services.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.AddressDao;
import com.rabex.express.model.Address;
import com.rabex.express.services.AddressService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class AddressServiceImpl implements AddressService {
    @Inject
    private AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public AddressServiceImpl() {

    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressDao.findAll();
    }

    @Override
    public int countAll() {
        return addressDao.countAll();
    }

    @Override
    public Address getAddressById(RID id) {
         return addressDao.findById(id).orElse(null);
    }

    @Override
    public boolean addAddress(Address address) throws IllegalArgumentException {
        return addressDao.insert(address);
    }

    @Override
    public boolean updateAddress(RID id, Address address) throws IllegalArgumentException {
        return addressDao.update(id, address);
    }

    @Override
    public boolean deleteAddress(RID id) {
        return addressDao.delete(id);
    }
}
