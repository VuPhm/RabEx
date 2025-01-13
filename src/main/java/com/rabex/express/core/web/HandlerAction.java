package com.rabex.express.core.web;

import java.io.IOException;
import java.io.OutputStream;

public interface HandlerAction {

    <T>T getPathVariable(String name, Class<T> clazz);
    <T>T getParam(String name, Class<T> clazz, T defaultValue);
    OutputStream getOutputStream() throws IOException;
    <T>BindingResult<T> bindingResult(Class<T> clazz);
    <T>BindingResult<T> bindingResult(Class<T> clazz, Validator<T> validator);
}
