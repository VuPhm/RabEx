package com.rabex.express.core.dao;

import com.rabex.express.dao.DefaultUserDAO;
import com.rabex.express.model.Role;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestInsertUser {
    @Test
    void test(){
        DefaultUserDAO userDao = new DefaultUserDAO();
        userDao.insertRelationShip(RID.fast(), List.of(new Role(RID.fast()),new Role(RID.fast())));

    }
}
