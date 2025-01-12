package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.model.ShippingServ;

import java.util.List;
import java.util.Optional;

public interface ShippingServDao extends Dao<ShippingServ> {
    Optional<ShippingServ> findBySlug(String slug);
    List<ShippingServ> findByRequest(double weight, boolean isInProvince);
}