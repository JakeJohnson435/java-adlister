package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("name");
        String pageNumber = request.getParameter("page");

        if (!(userName == null)){
            response.getWriter().println("<h1>Hello, " + userName + "!</h1>");
        } else {
            response.getWriter().println("<h1>Hello, World!</h1>");
        }

        response.getWriter().println("You're on page " + pageNumber);
    }
}


