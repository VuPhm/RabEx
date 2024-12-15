package com.rabex.express.core.dao;



import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;

import java.util.List;

public interface Dao<Model, Request> {

    List<Model> findAll();
    Page<Model> findAll(Pageable pageable);
    int countAll();
    Long insert(Request request);
    Model findById(RID id);
    boolean update(RID id, Request request);
}
