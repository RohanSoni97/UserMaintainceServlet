package Servlet.Admin;

import Services.ManageGalleryServices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileStatusServlet extends HttpServlet 
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
       int id=Integer.parseInt(req.getParameter("id"));
       if(ManageGalleryServices.getStatus(id))
       {
           if(ManageGalleryServices.changeStatus(id, 0))
           {
               resp.sendRedirect("/UMS2/managegallery");
           }
           
       }
       else
       {
           if(ManageGalleryServices.changeStatus(id, 1))
           {
               resp.sendRedirect("/UMS2/managegallery");
           }
       }
       }   
     catch(Exception e)
     {
	System.out.println("Exception in  ProfileStatusServlet(int id)"+e);
     }
    }
     
}
