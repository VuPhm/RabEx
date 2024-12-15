package com.rabex.express.services.impl;

import com.rabex.express.services.TestService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Scope;

public class DefaultTestService implements TestService {
    @Override
    public String sayHi() {
        return "HI";
    }
}
