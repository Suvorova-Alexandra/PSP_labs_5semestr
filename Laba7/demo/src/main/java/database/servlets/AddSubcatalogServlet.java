package database.servlets;

import database.Subcatalog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddSubcatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddSubCatalog.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subcatalog subcat=new Subcatalog();
        subcat.setTitle(req.getParameter("title"));
        subcat.setIdCatalog(Integer.parseInt(req.getParameter("parent")));
        subcat.insert();
    }
}
