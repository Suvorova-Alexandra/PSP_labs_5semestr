package app.servlets;

import app.DB.Users;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckinServlet extends Dispatcher {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("checkin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        //this.forward("/entrance.jsp", request, response);
        if (req.getParameter("checkin")!=null){
            Users user = null;
            try {
                user = new Users();
            } catch (NamingException e) {
                e.printStackTrace();
            }
            user.setLog(req.getParameter("log"));
            user.setPass(req.getParameter("pass"));
            user.setRole("user");
            ctx.setAttribute("user", user);
            if(user.findUser().equals("") && user.getLog()!="" && user.getPass()!=""){
                user.insert();
                this.forward("/success.jsp", req, response);
            }
            else{
                this.forward("/errorReg.jsp", req, response);
            }
        }
    }
}
