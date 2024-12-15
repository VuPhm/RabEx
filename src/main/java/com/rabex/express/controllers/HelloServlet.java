package com.rabex.express.controllers;

import java.io.*;

import com.rabex.express.services.TestService;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Inject
    private TestService testService;




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + testService.sayHi() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}