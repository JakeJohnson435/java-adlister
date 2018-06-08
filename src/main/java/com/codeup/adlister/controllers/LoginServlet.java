package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("username", user.getUsername());
            request.getSession().setAttribute("id", user.getId());
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
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

