package com.codeup.adlister.controllers;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        boolean validAttempt = false;

        if (validAttempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            String message = "";
//
//            boolean success = username.equals("admin") && password.equals("password");
//
//            if (success){
//                request.getSession().setAttribute("user", username);
//                request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
//            } else {
//                message ="Incorrect username or password. Please try again";
//                request.setAttribute("message", message);
//                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            }
//
//    }
    }
}

