package Servlet.Common;
import Beans.UserBean;
import Services.LoginServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
      try(PrintWriter out=resp.getWriter())
      {
        String user_name=req.getParameter("txtemail");
        String pass=req.getParameter("psw");
        UserBean user=LoginServices.authenticateUser(user_name, pass);
        if(user!=null)
        {HttpSession session=req.getSession();
        session.setAttribute("username", user_name);
        session.setAttribute("userid",user.getUserid());
            if(user.isUserstatus())
            {   if(user.getUserType().equals("adminstartor"))
               resp.sendRedirect("/UMS2/admindashboardservlet?userid="+user.getUserid());
                else
                {
                resp.sendRedirect("/UMS2/userdashboardservlet?userid="+user.getUserid());
                }
            }
             else
        {
            out.println("<h2>User is blocked</h2>");
            RequestDispatcher rd=req.getRequestDispatcher("Login.html");
            rd.include(req, resp);
        }
        }
        else
        {
            out.println("<h2>inavlid user name password</h2>");
            RequestDispatcher rd=req.getRequestDispatcher("Login.html");
            rd.include(req, resp);
        }
       
      }
      catch(Exception e)
      {
          System.out.println("Exception in login servlet"+e);
      }
    }
    
}
