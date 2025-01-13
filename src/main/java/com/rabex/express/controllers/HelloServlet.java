package com.rabex.express.controllers;

import java.io.*;
import java.util.Map;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.web.*;
import com.rabex.express.dto.RegisterRequest;
import com.rabex.express.services.TestService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/hello/*")
public class HelloServlet extends AbstractController {



    @Override
    protected void map(MappingBuilder builder) {
        builder.map(HttpMethod.GET, getIndex, "/{id}", "/home/{id}");;
    }



    private final RequestHandler getIndex = (handlerAction) -> {
        RID rid = handlerAction.getPathVariable("id", RID.class);
        BindingResult<RegisterRequest> bindingResult = handlerAction.bindingResult(RegisterRequest.class);
        if (bindingResult.hasError()){
            return new MvcActionResult("/users/form");
        }

        RegisterRequest request = bindingResult.body();

        MvcActionResult actionResult = new MvcActionResult("/WEB-INF/views/guest/contact.jsp");
        actionResult.add("id", rid);
        return actionResult;
    };
}