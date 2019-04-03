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

public class EditServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out=resp.getWriter())
        {
         String user_id=req.getParameter("id");
        int id=Integer.parseInt(req.getParameter("id"));
        String Name="";
        String email="";
        String contact="";
        String address="";
        List<UserBean> emp=ProfileMaintainceService.getEmployees(id);
        Iterator<UserBean> itr=emp.iterator();
        UserBean ub = null;
        if(itr.hasNext())
        {
            ub = itr.next();
            Name=ub.getName();
            email=ub.getEmail();
            contact=ub.getContact();
            address=ub.getAddress();
        }
       out.println("<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <title>Dashboard</title>\n" +
"   <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Droid+Sans\" rel=\"stylesheet\">\n" +
"    <link rel=\"stylesheet\" href=\"css/patient.css\">\n" +
"	<link rel=\"stylesheet\" href=\"css/responsive.css\">\n" +
"	<link rel=\"stylesheet\" href=\"css/dashboard.css\">\n" +
"	<link rel=\"stylesheet\" href=\"css/jquery-ui.css\"/>\n" +
"	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\">\n" +
"	<style>\n" +
".container {\n" +
"    max-width: 720px;\n" +
"    position: relative;\n" +
"    margin-left: 500px;\n" +
"    margin-top: 100px;\n" +
"}\n" +
"button.add {\n" +
"    position: relative;\n" +
"    margin-left: 300px;\n" +
"}\n" +
"</style>\n" +
"\n" +
" </head>\n" +
"<body>\n" +
"	<aside class=\"side-nav\">\n" +
"			<div class=\"cross-toggle\" style=\"display:none;\">\n" +
"					<div class=\"bar1\"></div>\n" +
"					<div class=\"bar2\"></div>\n" +
"			</div>\n" +
"			<div class=\"heading\">\n" +
"					<img src=\"images/patient-profile.jpg\" alt=\"\" class=\"img-responsive img-circle\">\n" +
"					<div class=\"info\">\n" +
"					  <h3><a href=\"#\">"+Name+"</a></h3>\n" +
"					</div>\n" +
"			</div>\n" +
"			<div class=\"search\">\n" +
"					<input type=\"text\" placeholder=\"Type here\"><i class=\"fa fa-search\"></i>\n" +
"			</div>\n" +
"	\n" +
"			<ul class=\"categories\">\n" +
"					<li><i class=\"fa fa-home fa-fw\" aria-hidden=\"true\"></i><a href=\"admindashboardservlet?userid="+id+"\" class=\"drop_hide\" data-id=\"contents\"> Dashboard</a></li>\n" +
"					<li><i class=\"fas fa-user-tie\" aria-hidden=\"true\"></i><a href=\"manageuser?id="+id+"\" class=\"drop_hide\" data-id=\"contents\"> Manage Users</a></li>\n" +
"					<li><i class=\"fas fa-user-plus\"></i><a href=\"displayadduserservlet?id="+id+"\" class=\"drop_hide\"> Add Users</a></li>\n" +
"					<li><i class=\"fas fa-users\"></i><a href=\"manageprofiledisplayadminservlet?id="+id+"\" class=\"drop_hide\"> Manage Profile</a></li>\n" +
"					<li><i class=\"fas fa-key\"></i><a href=\"changepasswordadmindisplayservlet?id="+id+"\" class=\"drop_hide\"> Change Password</a></li>\n" +
"					<li><i class=\"\" ></i><a href=\"managegallery\" class=\"drop_hide\"> Manage Gallery</a></li>	\n" +

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
"		<form action=\"/UMS2/displayeditservlet\" onsubmit=\"return validateLoginForm()\">\n" +
"				<div class=\"container\">\n" +
               "					<input type=\"text\"  placeholder="+id+" value="+id+" id=\"user_id\" name=\"user_id\" ><br/><br/>\n" +
"					<input type=\"email\"  placeholder="+email+" value="+email+" id=\"email\" name=\"email\" ><br/><br/>\n" +
"					<input type=\"text\" placeholder="+contact+" value="+contact+" id=\"contact\" name=\"contact\" required><br/><br/>\n" +
"					<input type=\"text\" placeholder="+address+" value="+address+" id=\"address\" name=\"address\" required><br/><br/>\n" +
"					<button type=\"submit\" class=\"add\">Edit User</button>	   \n" +
"					\n" +
"				</div>\n" +
"			</form>\n" +
"			<script>\n" +
"        \n" +
"            \n" +
"            function validateLoginForm()\n" +
"			{\n" +
"       \n" +
"                document.getElementById(\"txterror\").innerHTML=\"\"\n" +
"                \n" +
"                var email= document.getElementById(\"email\").value;\n" +
"				var contact=document.getElementById(\"contact\").value;\n" +
"				var address=document.getElementById(\"confirmpsw\").value;\n" +
"                \n" +
"				\n" +
"                return true;\n" +
"                \n" +
"            } \n" +
"		        </script>\n" +
"\n" +
"\n" +
"\n" +
" </body>\n" +
"</html>");
        
            
       
        }
       catch(Exception e)
        {
	System.out.println("Exception in DeleteServlet"+e);
        }
    }
    
}
