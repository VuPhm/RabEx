package com.rabex.express.core.dao;

public class StringToRidConvertor implements Convertor<String,RID>{
    @Override
    public RID convert(String s) {
        if (s == null)
            return null;
        return RID.from(s);
    }
}
