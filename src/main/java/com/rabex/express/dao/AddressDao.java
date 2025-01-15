package com.rabex.express.dao;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressDao {
    boolean delete(RID id);
    Optional<Address> findById(RID id);
    List<Address> findAll();
    boolean insert(Address address);

    boolean update(RID id, Address address);
}
