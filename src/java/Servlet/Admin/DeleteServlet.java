package Servlet.Admin;
import Services.ProfileMaintainceService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DeleteServlet extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    try
    {
        int id=Integer.parseInt(req.getParameter("id"));
        if(ProfileMaintainceService.deleteUser(id))
        {
            resp.sendRedirect("/UMS2/manageuser");
        }
    }
    catch(Exception e)
    {
	System.out.println("Exception in DeleteServlet"+e);
    }

    }
    
}
