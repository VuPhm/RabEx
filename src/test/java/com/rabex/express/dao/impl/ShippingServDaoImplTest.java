package com.rabex.express.dao.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingServDaoImplTest {

    @Test
    void findByRequest() {
        System.out.println(new ShippingServDaoImpl().findByRequest(250.01, false));;
    }
}