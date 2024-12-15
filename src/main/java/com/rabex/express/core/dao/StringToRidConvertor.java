package com.rabex.express.core.dao;

public class StringToRidConvertor implements Convertor<String,RID>{
    @Override
    public RID convert(String s) {
        return RID.from(s);
    }
}
