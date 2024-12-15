package com.rabex.express.core.dao;

import com.rabex.express.core.data.Sort;
import org.junit.jupiter.api.Test;

class SortToSqlConvertorTest {
    @Test
    void test(){
        Sort sort = Sort.by("name", "age");
        System.out.println(new SortToSqlConvertor().convert(sort));
    }
}