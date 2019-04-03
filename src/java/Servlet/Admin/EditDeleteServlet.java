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
public class EditDeleteServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    try(PrintWriter out=resp.getWriter())
        {
            int id=Integer.parseInt(req.getParameter("id"));
            System.out.println(id);
            String Name="";
            String title="";
            
            List<GalleryBean> emp=ManageGalleryServices.getEmployees(id);
            Iterator<GalleryBean> itr=emp.iterator();
            GalleryBean ub = null;
            if(itr.hasNext())
            {
            ub = itr.next();
            Name=ub.getName();
            title=ub.getTitle();
            }
            out.println("<html>\n" +
"    <head>\n" +
"        \n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <section class=\"form\">\n" +
"	<div class=\"container-fluid\">\n" +
"		<div class=\"row\">\n" +
"		\n" +
"                    <form action=\"./editgalleryservlet\">\n" +
"				<p class=\"loginform1\">\n" +
"				  <input type=\"hidden\" name=\"id\" id=\"id\" value="+id+"><br/><br/>\n" +
"Imagename         <input type=\"text\" name=\"imgname\" id=\"imgname\" value="+Name+"><br/><br/>\n" +
"Imagetitle        <input type=\"text\" name=\"title\" id=\"title\" value="+title+"><br/><br/>\n" +

"Browse            <input type=\"file\" name =\"nm\" id=\"nm\"><br/><br/>\n" +
"                  <button type=\"submit\"  value=\"upload\">submit</button>\n" +
"                      \n" +
"</p>\n" +
"</form>\n" +
"			\n" +
"		</div>\n" +
"	</div>\n" +
"</section>\n" +
"    </body>\n" +
"</html>");
        }
    
    catch(Exception e)
        {
            System.out.println("EditDeleteServlet"+e);
        }
    }    
 }
    

