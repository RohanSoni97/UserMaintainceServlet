package Servlet.Common;

import Beans.UserBean;
import Services.UserMaintainceServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet
{

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        try
        {
        String user_name=req.getParameter("username");
        String name=req.getParameter("myname");
        String email=req.getParameter("txtemail");
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
             resp.sendRedirect("/UMS2/Login.html");
         }
        }
        catch(Exception e)
        {
        System.out.println("Exception in AddUserServlet"+e);
        }
    }
    
}
