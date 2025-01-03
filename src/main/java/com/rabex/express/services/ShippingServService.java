package com.rabex.express.services;

import com.rabex.express.model.ShippingServ;

import java.util.List;

public interface ShippingServService {
    int countAll();
    List<ShippingServ> findAll();
    ShippingServ findBySlug(String slug);
}
