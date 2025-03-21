package com.javaee.controller;

import com.javaee.entity.Country;
import com.javaee.service.CountryService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet({"/", "/home", "/index"})
public class IndexController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;

    @Inject
    private CountryService countryService;

    public IndexController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        String search = request.getParameter("search") != null ? request.getParameter("search") : "";
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        try {
            int recordsPerPage = 5;
            int offset = (page - 1) * recordsPerPage;
            List<Country> countries = countryService.findAll(search, offset, recordsPerPage);
            int totalCountries = countryService.count();
            int totalPages = (int) Math.ceil((double) totalCountries / recordsPerPage);
            request.setAttribute("countries", countries);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("search", search);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        request.setAttribute("home", "Home Page");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/index.jsp");
        dispatcher.forward(request, response);
    }
}
