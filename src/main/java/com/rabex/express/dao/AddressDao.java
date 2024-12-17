package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.Address;

public interface AddressDao extends Dao<Address> {
    boolean delete(RID id);
}
