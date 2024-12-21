package com.rabex.express.core.utils;

import java.util.Collection;

public class Common {
    public static boolean notEmpty(Object object){
        if (object == null) return false;
        if (object instanceof Object[] arr)
            return arr.length != 0;
        if (object instanceof Collection<?> collection)
            return !collection.isEmpty();
        if (object instanceof String string)
            return !string.isEmpty();
        if (object instanceof Number number)
            return !number.equals(0);
        return true;
    }

    public static boolean isEmpty(Object o){
        return !notEmpty(o);
    }

    public static void main(String[] args) {
        System.out.println(notEmpty(0));
    }
}