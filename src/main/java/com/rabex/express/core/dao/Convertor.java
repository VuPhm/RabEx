package com.rabex.express.core.dao;

public interface Convertor<S, T> {
    T convert(S s);
}
