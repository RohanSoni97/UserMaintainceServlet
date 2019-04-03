package Servlet.Common;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePasswordDisplayServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    try(PrintWriter out=resp.getWriter())
      {
                 HttpSession session=req.getSession(false);
          String user_name="";
          int id=0;
        if(session!=null)
          {
             user_name=(String) session.getAttribute("username");
             id=(int)session.getAttribute("userid");
          }
        else
        {
             resp.sendRedirect("/UMS2/Login.html");
        }
         
          out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"  <title>Add Users</title>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"    <link href=\"https://fonts.googleapis.com/css?family=Droid+Sans\" rel=\"stylesheet\">\n" +
"    <link rel=\"stylesheet\" href=\"css/dashboard.css\">\n" +
"	\n" +
"	\n" +
"	<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.0/css/all.css\" integrity=\"sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt\" crossorigin=\"anonymous\">\n" +
" \n" +
"	<link rel=\"stylesheet\" href=\"new.css\">\n" +
"	<script src=\"validation.js\"></script>\n" +
"	<script>\n" +
"        \n" +
"            \n" +
"            function validateLoginForm()\n" +
"	    {\n" +
"       \n" +
"                document.getElementById(\"txterror\").innerHTML=\"\"\n" +
"                var oldPassword = document.getElementById(\"OldPassword\").value;\n" +
"                var password = document.getElementById(\"psw\").value;\n" +
"				var confirmPassword=document.getElementById(\"confirmpsw\").value;\n" +
"       \n" +
"                \n" +
"                if(password!=confirmPassword)\n" +
"                {\n" +
"                    document.getElementById(\"txterror\").innerHTML=\"Password and confirm password must be same\";\n" +
"                    document.getElementById(\"psw\").focus();\n" +
"                    document.getElementById(\"confirmpsw\").focus();\n" +
"                    return false;\n" +
"                }\n" +
"				\n" +
"                return true;\n" +
"                \n" +
"            } \n" +
"        </script>\n" +
" \n" +
"</head>\n" +
"<style>\n" +
".container \n" +
"{\n" +
"    max-width: 720px;\n" +
"    position: relative;\n" +
"    margin-left: 600px;\n" +
"	margin-top:150px;\n" +
"}\n" +
"button.add {\n" +
"    position: relative;\n" +
"    margin-left: 25px;\n" +
"}\n" +
"</style>\n" +
"<body>\n" +
"\n" +
"				<aside class=\"side-nav\">\n" +
"			<div class=\"cross-toggle\" style=\"display:none;\">\n" +
"					<div class=\"bar1\"></div>\n" +
"					<div class=\"bar2\"></div>\n" +
"			</div>\n" +
"			<div class=\"heading\">\n" +
"					<img src=\"images/patient-profile.jpg\" alt=\"\" class=\"img-responsive img-circle\">\n" +
"					<div class=\"info\">\n" +
"					  <h3><a href=\"#\">"+user_name+"</a></h3>\n" +
"					</div>\n" +
"			</div>\n" +
"			<div class=\"search\">\n" +
"					<input type=\"text\" placeholder=\"Type here\"><i class=\"fa fa-search\"></i>\n" +
"			</div>\n" +
"	\n" +
"			<ul class=\"categories\">\n" +
"					<li><i class=\"fa fa-home fa-fw\" aria-hidden=\"true\"></i><a href=\"userdashboardservlet\" class=\"drop_hide\" data-id=\"contents\"> Dashboard</a></li>\n" +
"					<li><i class=\"fas fa-users\"></i><a href=\"manageprofiledisplayservlet\" class=\"drop_hide\"> Manage Profile</a></li>\n" +
"					<li><i class=\"fas fa-key\"></i><a href=\"changepassworddisplayservlet\" class=\"drop_hide\"> Change Password</a></li>\n" +


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
"		<form action=\"/UMS2/changepasswordservlet\" onsubmit=\"return validateLoginForm()\">\n" +
"				<div>\n" +
"                 <label id = \"txterror\"></label>\n" +
"                </div>\n" +
"				<div class=\"container\">\n" +
"					\n" +
"					<input type=\"hidden\" name=\"id\" id=\"id\" value="+id+"><br/><br/>\n" +
"					<input type=\"password\" placeholder=\"Old Password\" id=\"OldPassword\" name=\"OldPassword\"><br/><br/>\n" +
"					<input type=\"password\" placeholder=\"Password\" id=\"psw\" name=\"psw\"><br/><br/>\n" +
"					<input type=\"password\" placeholder=\"Confirm Password\" id=\"confirmpsw\" name=\"confirmpsw\"><br/><br/>\n" +
"					<button type=\"submit\" class=\"add\">Change Password</button>	   \n" +
"					\n" +
"				</div>\n" +
"		</form>\n" +
"</body>\n" +
"</html>");
      }   
    catch(Exception e)
      {
       System.out.println("Exception in ChangePasswordDisplayServlet"+e);
      }
    }
    
}
