package com.rabex.express.core.web;

import java.util.Map;

public interface Validator<T> {
    Map<String, String> validate(T t);

    Class<T> validatedClass();
}
