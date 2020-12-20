package app.servlets;

import app.DB.Users;
import app.entities.TestRes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BookServlet extends Dispatcher {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("book.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        if (req.getParameter("send")!=null){
            HttpSession session = req.getSession();
            Users users = (Users) session.getAttribute("us");
            try {
                if(users != null){
                    String[] res = new String[3];
                    res[0] = users.getLog();
                    res[1]=req.getParameter("name");
                    res[2]=req.getParameter("title");
                    TestRes testRes = new TestRes();
                    testRes.setRes(res);
                }
            }
            finally { }

        }
    }
}
