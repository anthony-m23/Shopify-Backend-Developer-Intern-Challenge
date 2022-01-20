package com.CompanyInventory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet to update item in db
public class UpdateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String destPage = "home.jsp";

        String name = request.getParameter("name");
        String SKU = request.getParameter("SKU");
        String cost = request.getParameter("cost");

        DBManager manager = new DBManager();

        manager.update(cost, name, SKU);

        RequestDispatcher rq = request.getRequestDispatcher(destPage);
        rq.forward(request, response);
    }
}
