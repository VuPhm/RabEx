package com.rabex.express.core.web;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MvcActionResult implements ActionResult {
    private Map<String, Object> models;
    private String view;

    public MvcActionResult(String view) {
        this.view = view;
        this.models = new LinkedHashMap<>();
    }

    public Map<String, Object> getModels() {
        return Collections.unmodifiableMap(models);
    }

    public String getView() {
        return view;
    }

    public void add(String name, Object model) {
        models.put(name, model);
    }

    public void remove(String name){
        models.remove(name);
    }
}
