package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user.getUsername().isEmpty()) {
            response.sendRedirect("/login");
            return;
        }

        try {
            request.setAttribute("ads", DaoFactory.getAdsDao().searchById(user.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String message;
        try {
            if (DaoFactory.getAdsDao().searchById(user.getId()).isEmpty()){
                message = "You have no ads posted.";
                request.setAttribute("message", message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            request.setAttribute("ads", DaoFactory.getAdsDao().searchById(user.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
