package com.rabex.express.core.dao;

import com.rabex.express.core.data.Sort;
import com.rabex.express.core.utils.CaseUtils;

import java.util.StringJoiner;


public class SortToSqlConvertor implements Convertor<Sort, String> {

    private String label;

    @Override
    public String convert(Sort sort) {
        System.out.println(sort);
        if (sort.isUnsorted())
            return "";
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (var order: sort){
            stringJoiner.add(CaseUtils.toSnakeCaseWithDots(order.getProperty()) + " " +order.getDirection());

        }

        return "ORDER BY " + stringJoiner;
    }
}
