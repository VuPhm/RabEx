package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.ShippingServ;

import java.util.Optional;

public interface ShippingServDao extends Dao<ShippingServ> {
    Optional<ShippingServ> findBySlug(String slug);
}