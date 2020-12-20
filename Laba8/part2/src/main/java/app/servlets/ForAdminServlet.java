package app.servlets;

import app.DB.Users;
import app.entities.TestRes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ForAdminServlet extends Dispatcher {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestRes testRes = new TestRes();
        req.setAttribute("results", testRes.getRes());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("forAdmin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        TestRes testRes = new TestRes();
        ArrayList<String[]> resList = testRes.getRes();
        String[] pass = new String[2];
        response.setContentType("text/html; charset=UTF8");
        req.setCharacterEncoding("cp1251");
        PrintWriter out = response.getWriter();
        for(int i = 0; i< resList.size(); i++){
            if(req.getParameter("re"+i)!=null && req.getParameter("pass"+i)!=null){
                pass[0] = resList.get(i)[0];
                String[] parameter=req.getParameterValues("re"+i);
                pass[1] = parameter[0]  ;
                testRes.setPass(pass);
            }
        }
    }
}