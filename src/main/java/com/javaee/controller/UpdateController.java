package com.javaee.controller;

import com.javaee.dao.CountryDAO;
import com.javaee.dao.CountryDAOImpl;
import com.javaee.entity.Country;
import com.javaee.service.CountryService;
import com.javaee.service.CountryServiceImpl;
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

  private CountryService countryService;

  public UpdateController() {
  }

  @Override
  public void init() throws ServletException {
    CountryDAO countryDAO = new CountryDAOImpl();
    countryService = new CountryServiceImpl(countryDAO);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      int countryId = Integer.parseInt(request.getParameter("countryId"));
      Country country = countryService.findById(countryId);

      request.setAttribute("country", country);
      request.setAttribute("isUpdate", true);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    request.setAttribute("update", "Update Page");
    RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/create.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Country country = Country.builder().countryId(Integer.parseInt(request.getParameter("countryId")))
          .name(request.getParameter("name"))
          .continent(request.getParameter("continent"))
          .build();

      countryService.update(country);
    } catch (Exception exception) {
      exception.printStackTrace();
    }

    response.sendRedirect("/");
  }
}