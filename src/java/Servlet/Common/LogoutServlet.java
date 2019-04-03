package Servlet.Common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    HttpSession session=req.getSession(false);
          if(session!=null)
          {
              session.invalidate();
          }
          resp.setHeader("Cache-Control", "no-cache");
          resp.setHeader("Cache-Control", "no-store");
          resp.setDateHeader("Expires", 0);
          resp.setHeader("Pragma", "no-cache");
          resp.sendRedirect("./Login.html");
    }
    
}