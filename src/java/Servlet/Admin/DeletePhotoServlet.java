package Servlet.Admin;

import Services.ManageGalleryServices;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePhotoServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
     try
        {
        int id=Integer.parseInt(req.getParameter("id"));
        ServletContext ctx=getServletContext();
            String filepath=ctx.getInitParameter("UploadPath");
            String name=ManageGalleryServices.getName(id);
            File file=new File(filepath+name);
            file.delete();
        if(ManageGalleryServices.deleteUser(id))
        {
             resp.sendRedirect("/UMS2/managegallery");
        }
        }
     catch(Exception e)
        {
	System.out.println("Exception in DeletePhotoServlet"+e);
        }
    }
    
}
