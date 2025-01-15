package com.rabex.express.dao.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoImplTest {

    @Test
    void findByCode() {
        OrderDaoImpl dao = new OrderDaoImpl();
        System.out.println(dao.findByCode("RBX938275948379"));
    }
}