package com.rabex.express.core.dao;

import com.rabex.express.model.RoleName;
import com.rabex.express.model.UserStatus;

public class StringToEnumConvertor<T extends Enum<T>> implements Convertor<String, T > {

    private Class<T> enumClass;

    public StringToEnumConvertor(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public T convert(String s) {
        return Enum.valueOf(enumClass, s.toUpperCase());
    }
}
