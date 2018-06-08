package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("search");
        request.setAttribute("searchTerm", searchTerm);
        String message = "";

        try {
            if (DaoFactory.getAdsDao().search(searchTerm).isEmpty()){
                message = "No results found.";
                request.setAttribute("message", message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            request.setAttribute("ads", DaoFactory.getAdsDao().search(searchTerm));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/ads/searchresults.jsp").forward(request, response);
    }
}
