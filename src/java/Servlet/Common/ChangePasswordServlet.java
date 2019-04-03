package Servlet.Common;

import Services.ProfileMaintainceService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePasswordServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
             HttpSession session=req.getSession(false);
          String user_name="";
          int id=0;
        if(session!=null)
          {
             user_name=(String) session.getAttribute("username");
             id=(int)session.getAttribute("userid");
          }
        else
        {
             resp.sendRedirect("/UMS2/Login.html");
        }
    
    String oldPassword=req.getParameter("OldPassword");
    String password=req.getParameter("psw");
    String matchPassword=ProfileMaintainceService.getPassword(id);
    if(matchPassword.equals(oldPassword))
    {
        if(ProfileMaintainceService.updatePassword(id, password))
        {
            if(ProfileMaintainceService.getUserType(id).equals("user"))
            {
                resp.sendRedirect("/UMS2/userdashboardservlet");
            }
            else
            {
               resp.sendRedirect("/UMS2/admindashboardservlet");
            }
        }
    }
    else
    {
        resp.sendRedirect("/UMS2/changepassworddisplayservlet");
    }
    }
    
}
