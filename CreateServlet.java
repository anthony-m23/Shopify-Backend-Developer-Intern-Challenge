package com.CompanyInventory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Servlet adds new Items to inventory
public class CreateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String destPage = "home.jsp";

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String SKU = request.getParameter("SKU");
        String cost = request.getParameter("cost");
        String type = request.getParameter("type");
        String locationName = request.getParameter("locationName");

        DBManager manager = new DBManager();

        manager.insert(name, address, SKU, cost, type); // calls db and adds to it
        manager.locationInsert(locationName, address);

        RequestDispatcher rq = request.getRequestDispatcher(destPage);
        rq.forward(request, response);
    }
}
