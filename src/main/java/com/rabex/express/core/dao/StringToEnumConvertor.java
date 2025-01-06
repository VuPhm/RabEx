package com.rabex.express.core.dao;

public class StringToEnumConvertor<T extends Enum<T>> implements Convertor<String, T > {

    private final Class<T> enumClass;

    public StringToEnumConvertor(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public T convert(String s) {
        return Enum.valueOf(enumClass, s.toUpperCase());
    }
}
