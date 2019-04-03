package Servlet.Admin;

import Beans.UserBean;
import Services.UserMaintainceServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    try(PrintWriter out=resp.getWriter())
        {
            resp.setHeader("Cache-Control", "no-cache");
          resp.setHeader("Cache-Control", "no-store");
          resp.setDateHeader("Expires", 0);
          resp.setHeader("Pragma", "no-cache");
         String user_name=req.getParameter("uname");
         String name=req.getParameter("Name");
         String email=req.getParameter("email");
         String contact=req.getParameter("contact");
         String address=req.getParameter("address");
         String password="root";
         String user_type="user";
         int userStatus=0;
         UserBean ub=new UserBean();
         ub.setUsername(user_name);
         ub.setPassword(password);
         ub.setUserType(user_type);
         ub.setName(name);
         ub.setEmail(email);
         ub.setContact(contact);
         ub.setAddress(address);
         if(UserMaintainceServices.addEmployee(ub))
         {
             resp.sendRedirect("/UMS2/manageuser?id="+1);
         }
        }   
    catch(Exception e)
    {
     System.out.println("Exception in AddUserServlet"+e);
    }
    }
    
}
