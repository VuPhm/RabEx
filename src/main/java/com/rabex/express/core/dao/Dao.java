package com.rabex.express.core.dao;



import com.rabex.express.core.data.Page;
import com.rabex.express.core.data.Pageable;

import java.util.List;

public interface Dao<Model> {

    List<Model> findAll();
    Page<Model> findAll(Pageable pageable);
    int countAll();
    boolean insert(Model request);
    Model findById(RID id);
    boolean update(RID id, Model request);
}
