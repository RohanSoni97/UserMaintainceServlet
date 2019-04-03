package Servlet.Common;

import Beans.UserBean;
import Services.ProfileMaintainceService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManageProfileServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
     try
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
       
        String username=req.getParameter("uname");
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String contact=req.getParameter("contact");
        String address=req.getParameter("address");
        List<UserBean> usb=ProfileMaintainceService.getEmployees(id);
        Iterator<UserBean> itr=usb.iterator();
        UserBean ub = null;
        if(itr.hasNext())
        {
            ub = itr.next();
            ub.setUserid(id);
            ub.setUsername(username);
            ub.setEmail(email);
            ub.setContact(contact);
            ub.setAddress(address);
            
        }
         if(ProfileMaintainceService.updateUserProfile(ub))
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
     catch(Exception e)
      {
       System.out.println("Exception in ManageProfileServlet"+e);
      }
    }
    
}
