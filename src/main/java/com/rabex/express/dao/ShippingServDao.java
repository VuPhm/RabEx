package com.rabex.express.dao;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.ShippingServ;

import java.util.List;
import java.util.Optional;

public interface ShippingServDao {
    Optional<ShippingServ> findById(RID id);
    Optional<ShippingServ> findBySlug(String slug);
    List<ShippingServ> findByRequest(double weight, boolean isInProvince);
    List<ShippingServ> findByRequest(boolean inProvince);

    int countAll();

    List<ShippingServ> findAll();
}