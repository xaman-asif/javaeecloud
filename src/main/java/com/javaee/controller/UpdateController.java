package com.javaee.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    public UpdateController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("update","Update Page");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/update.jsp");
        dispatcher.forward(request, response);
    }
}
