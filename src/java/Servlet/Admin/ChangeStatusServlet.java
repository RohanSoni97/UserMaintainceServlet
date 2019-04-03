package Servlet.Admin;

import Services.ProfileMaintainceService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeStatusServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    try(PrintWriter out=resp.getWriter())
    {
        resp.setHeader("Cache-Control", "no-cache");
          resp.setHeader("Cache-Control", "no-store");
          resp.setDateHeader("Expires", 0);
          resp.setHeader("Pragma", "no-cache");
     int id=Integer.parseInt(req.getParameter("id"));
    
     if(ProfileMaintainceService.getStatus(id))
     {
         if(ProfileMaintainceService.changeStatus(id, 0)){
             
             resp.sendRedirect("/UMS2/manageuser");
         }
     }
     else 
     {
         if(ProfileMaintainceService.changeStatus(id, 1)){
            
             resp.sendRedirect("/UMS2/manageuser");
         }
     }
    }
     catch(Exception e)
     {
	System.out.println("Exception in  ChangeStatusServlet(int id)"+e);
     }
    }
    
}
