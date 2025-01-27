package com.rabex.express.dao;

import com.rabex.express.core.dao.Dao;
import com.rabex.express.core.dao.RID;
import com.rabex.express.model.SurchargeTier;

import java.util.List;

public interface SurchargeTierDao extends Dao<SurchargeTier> {
    List<SurchargeTier> findByServiceId(String sid);

}
