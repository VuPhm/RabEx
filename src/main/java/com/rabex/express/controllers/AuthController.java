package com.rabex.express.controllers;

import com.rabex.express.core.web.AbstractController;
import com.rabex.express.core.web.MvcActionResult;
import com.rabex.express.core.web.RequestHandler;
import com.rabex.express.dto.RegisterRequest;
import com.rabex.express.services.AuthService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.rabex.express.core.web.WebUtils.*;

@WebServlet(value = "/auth/*")
public class AuthController extends AbstractController{

    private AuthService authService;

    @Override
    protected void map(MappingBuilder builder) {

    }


    final RequestHandler loginPage = (action) -> {



        return new MvcActionResult("");
    };




    final RequestHandler registerPage = (action) -> {



        return new MvcActionResult("");
    };


    final RequestHandler handlerRegister = (action) -> {



        return new MvcActionResult("");
    };

    final RequestHandler handleAuthenticate = (action) -> {



        return new MvcActionResult("");
    };
}