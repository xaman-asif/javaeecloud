package com.javaee.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet("/details")
public class DetailsController extends HttpServlet {
  @Serial
  private static final long serialVersionUID = 1L;

  public DetailsController() {
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("details", "Details Page");

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/details.jsp");
    requestDispatcher.forward(request, response);
  }
}
