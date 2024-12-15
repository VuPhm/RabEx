package com.rabex.express.core.dao;

public class RidToStringConvertor implements Convertor<RID, String>{
    @Override
    public String convert(RID rid) {
        return rid.toLowerCase();
    }
}
