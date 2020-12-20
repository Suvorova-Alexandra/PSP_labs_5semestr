package database.servlets;

import database.File;
import database.Subcatalog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddFile.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file=new File();
        file.setTitle(req.getParameter("title"));
        file.setIdCatalog(Integer.parseInt(req.getParameter("parent")));
        file.setMemory(Float.parseFloat(req.getParameter("memory")));
        file.insert();
    }
}
