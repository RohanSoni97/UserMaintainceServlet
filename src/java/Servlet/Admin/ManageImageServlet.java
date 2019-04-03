package Servlet.Admin;
import Beans.GalleryBean;
import Services.ManageGalleryServices;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
public class ManageImageServlet extends HttpServlet 
{
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            ServletContext ctx=getServletContext();
            String filepath=ctx.getInitParameter("UploadPath");
            String imgname=request.getParameter("imgname");
            String imgtitle = request.getParameter("title");
            String imgdesc=request.getParameter("imgdesc");
            GalleryBean emp=new GalleryBean();
            emp.setName(imgname);
            emp.setTitle(imgtitle);
            emp.setDescription(imgdesc);
            emp.setImgstatus(false);
            if(ManageGalleryServices.addEmployee(emp))
            {
            Part imgdata= request.getPart("nm");
            File f1 = new File(filepath+imgname);
            InputStream is = imgdata.getInputStream();
            OutputStream os = new FileOutputStream(f1);
            byte b[] = new byte[is.available()];
            is.read(b);
            os.write(b);
            is.close();
            os.close();
            response.sendRedirect("/UMS2/managegallery");
            }
        }
         catch(Exception e)
           {
            System.out.println("ManageImageServlet exception ::"+e);
           }
    

    

}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       processRequest(req, resp); 
    }
}
