package com.rabex.express.core.dao;

import com.rabex.express.core.data.PageRequest;
import com.rabex.express.dao.RoleDao;
import com.rabex.express.dao.UserDao;
import com.rabex.express.dao.impl.DefaultRoleDao;
import com.rabex.express.dao.impl.DefaultUserDao;
import com.rabex.express.model.Role;
import com.rabex.express.model.enumm.RoleName;
import com.rabex.express.model.User;
import com.rabex.express.model.enumm.UserStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTemplateDao {
    UserDao userDao = new DefaultUserDao();
    RoleDao roleDao = new DefaultRoleDao();

    @Test
    void testFindAll(){
        User user = userDao.findById(RID.from("01JFAJM220CTEKNV2M65QW317M")).orElseThrow(() -> new IllegalArgumentException("Not found"));
        System.out.println(user);
    }

    @Test
    void testCountAll(){
        System.out.println(userDao.countAll());
    }

    @Test
    void testFinalAll(){
        System.out.println(userDao.findAll(PageRequest.of(1,10 , "role.name")));
    }

    @Test
    void  test(){
        Role role = roleDao.findByRoleName(RoleName.ADMIN).orElseThrow(() -> new IllegalArgumentException("Not found"));
        RID rid = RID.from("01JFAJM220CTEKNV2M65QW317N");
        User user = User.builder()
                .id(rid)
                .fullName("David")
                .hashPassword("")
                .roles(List.of(role))
                .email("nguyenvanhuynh@gmail.com")
                .status(UserStatus.ACTIVE)
                .build();

        System.out.println(user);
        userDao.insert(user);
    }

    @Test
    void testULID(){
        System.out.println(RID.fast());
        RID id = RID.from("01HJK9C4L5XR9UL9Q9BX4YP4V4");
    }
}
