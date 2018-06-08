package com.codeup.adlister.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/math.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        int answer=0;
        String operator = request.getParameter("operator");
        request.setAttribute("x", x);
        request.setAttribute("y", y);
        request.setAttribute("operator", operator);


        if (operator.equals("Add")) {
            request.setAttribute("operand", "+");
            answer = Integer.parseInt(x) + Integer.parseInt(y);
        }

        if (operator.equals("Multiply")){
            request.setAttribute("operand", "*");
            answer = Integer.parseInt(x) * Integer.parseInt(y);
        }
        request.setAttribute("answer", answer);
        request.getRequestDispatcher("/WEB-INF/answer.jsp").forward(request, response);
    }
}
