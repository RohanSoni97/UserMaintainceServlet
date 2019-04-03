package Servlet.Common;

import Services.ProfileMaintainceService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserDashboardServlet extends HttpServlet
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
          
       HttpSession session=req.getSession(false);
          String username="";
        if(session!=null)
          {
             username=(String) session.getAttribute("username");
             
          }
        else
        {
             resp.sendRedirect("/UMS2/Login.html");
        }
      // int id=Integer.parseInt(req.getParameter("userid"));
       
       out.println("<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <title>Dashboard</title>\n" +
"    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Droid+Sans\" rel=\"stylesheet\">\n" +
"    <link rel=\"stylesheet\" href=\"css/dashboard.css\">\n" +
"	\n" +
"	\n" +
"	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\">\n" +
" \n" +
" </head>\n" +
" <body>\n" +
"	<aside class=\"side-nav\">\n" +
"			<div class=\"cross-toggle\" style=\"display:none;\">\n" +
"					<div class=\"bar1\"></div>\n" +
"					<div class=\"bar2\"></div>\n" +
"			</div>\n" +
"			<div class=\"heading\">\n" +
"					<img src=\"images/patient-profile.jpg\" alt=\"\" class=\"img-responsive img-circle\">\n" +
"					<div class=\"info\">\n" +
"					  <h3><a href=\"#\">"+username+"</a></h3>\n" +
"					</div>\n" +
"			</div>\n" +
"			<div class=\"search\">\n" +
"					<input type=\"text\" placeholder=\"Type here\"><i class=\"fa fa-search\"></i>\n" +
"			</div>\n" +
"	\n" +
"			<ul class=\"categories\">\n" +
"					<li><i class=\"fa fa-home fa-fw\" aria-hidden=\"true\"></i><a href=\"userdashboardservlet\" class=\"drop_hide\" data-id=\"contents\"> Dashboard</a></li>\n" +
"					\n" +
"\n" +
"					<li><i class=\"fas fa-users\"></i><a href=\"manageprofiledisplayservlet\" class=\"drop_hide\"> Manage Profile</a></li>\n" +
"					<li><i class=\"fas fa-key\"></i><a href=\"changepassworddisplayservlet\" class=\"drop_hide\"> Change Password</a></li>\n" +
"\n" +
"					<li><i class=\"fa fa-question\" aria-hidden=\"true\"></i><a href=\"faq.html\" class=\"drop_hide\"> FAQ</a></li>\n" +
"			</ul>		\n" +
"	</aside>\n" +
"		<div class=\"container-fluid\">\n" +
"			<div class=\"col-md-12\">\n" +
"						<ul class=\"navigation\">\n" +
"							<li><a href=\"logoutservlet\" class=\"zgh-login\" style=\"display: inline-block;\">LogOut</a><li/>\n" +
"						</ul>\n" +
"			</div>	\n" +
"		</div>\n" +
"	<section class=\"statistics\">\n" +
"        <div class=\"container-fluid\">\n" +
"		<div class=\"row list_header\">\n" +
"		   \n" +
"			<div class=\"col-md-12 header-title\">\n" +
"                       \n" +
"					<h1 class=\"text-center\" style=\"font-size:27px;\">Welcome To Zoho</h1>\n" +
"                        \n" +
"               </div>\n" +
"		  </div>\n" +
"		  </div>\n" +
"	</section>	  \n" +
"      \n" +
"\n" +
" </body>\n" +
"</html>");
      }
     catch(Exception e)
      {
          System.out.println("Exception in UserDashboardServlet"+e);
      }
    }
    
}
