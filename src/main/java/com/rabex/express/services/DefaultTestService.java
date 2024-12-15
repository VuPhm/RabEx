package com.rabex.express.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Scope;

public class DefaultTestService implements TestService{
    @Override
    public String sayHi() {
        return "HI";
    }
}
