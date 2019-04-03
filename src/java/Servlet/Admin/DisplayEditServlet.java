package Servlet.Admin;

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

public class DisplayEditServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try(PrintWriter out=resp.getWriter())
        {
            int user_id=Integer.parseInt(req.getParameter("user_id"));
            String email=req.getParameter("email");
            String contact=req.getParameter("contact");
            String address=req.getParameter("address");
           List<UserBean> usb=ProfileMaintainceService.getEmployees(user_id);
           Iterator<UserBean> itr=usb.iterator();
        UserBean ub = null;
        if(itr.hasNext())
        {
            ub = itr.next();
            ub.setEmail(email);
            ub.setContact(contact);
            ub.setAddress(address);
            ub.setUserid(user_id);
        }
        if(ProfileMaintainceService.updateEmployee(ub))
        {
            resp.sendRedirect("/UMS2/manageuser?id="+user_id);
        }
        }
        catch(Exception e)
        {
            System.out.println("Exception in DisplayEditServlet"+e);
        }
    }
    
}
