package Servlet.Admin;

import Beans.GalleryBean;
import Beans.UserBean;
import Services.ManageGalleryServices;
import Services.ProfileMaintainceService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditGalleryServlet  extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out=resp.getWriter())
        {
            int id=Integer.parseInt(req.getParameter("id"));
            
            String Name=req.getParameter("imgname");
            String title=req.getParameter("title");
            System.out.println(Name+" "+title);
            List<GalleryBean> usb=ManageGalleryServices.getEmployees(id);
            Iterator<GalleryBean> itr=usb.iterator();
            GalleryBean ub = null;
            if(itr.hasNext())
            {
                ub = itr.next();
                ub.setName(Name);
                ub.setTitle(title);
                ub.setImgid(id);
            }
            if(ManageGalleryServices.updateEmployee(ub))
            {
                resp.sendRedirect("/UMS2/managegallery");
            }
            
        }
        catch(Exception e)
        { 
	System.out.println("Exception in EditGalleryServlet"+e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp); 
    }
    
}
