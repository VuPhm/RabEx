package com.rabex.express.core.web;

import java.util.Map;

public interface BindingResult<T>{
    boolean hasError();
    Map<String, String> errors();
    T body();
}
