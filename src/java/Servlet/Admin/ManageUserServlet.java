package Servlet.Admin;

import Beans.UserBean;
import Services.ProfileMaintainceService;
import Services.UserMaintainceServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManageUserServlet extends HttpServlet 
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
       
          List<UserBean> allemployees=UserMaintainceServices.getAllEmployees();
          
		Iterator<UserBean> itr=allemployees.iterator();
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
"					  <h3><a href=\"#\">"+user_name+"</a></h3>\n" +
"					</div>\n" +
"			</div>\n" +
"			<div class=\"search\">\n" +
"					<input type=\"text\" placeholder=\"Type here\"><i class=\"fa fa-search\"></i>\n" +
"			</div>\n" +
"	\n" +
"			<ul class=\"categories\">\n" +
"					<li><i class=\"fa fa-home fa-fw\" aria-hidden=\"true\"></i><a href=\"admindashboardservlet\" class=\"drop_hide\" data-id=\"contents\"> Dashboard</a></li>\n" +
"					<li><i class=\"fas fa-user-tie\" aria-hidden=\"true\"></i><a href=\"manageuser\" class=\"drop_hide\" data-id=\"contents\"> Manage Users</a></li>\n" +
"					<li><i class=\"fas fa-user-plus\"></i><a href=\"displayadduserservlet?id="+id+"\" class=\"drop_hide\"> Add Users</a></li>\n" +
"					<li><i class=\"fas fa-users\"></i><a href=\"manageprofiledisplayadminservlet?id="+id+"\" class=\"drop_hide\"> Manage Profile</a></li>\n" +
"					<li><i class=\"fas fa-key\"></i><a href=\"changepassworddisplayservlet?id="+id+"\" class=\"drop_hide\"> Change Password</a></li>\n" +
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
"\n" +
"<section id=\"medical-record\">\n" +
"	    <div class=\"container-fluid\">\n" +
"		 <div class=\"row list_header\">\n" +
"		   \n" +
"			<div class=\"col-md-12 header-title text-center\">\n" +
"                         \n" +
"                        <div class=\"header-icon\">\n" +
"                        <i class=\"fa fa-file-text\" aria-hidden=\"true\"></i> \n" +
"                    </div>\n" +
"					<h1>Users Record</h1>\n" +
"                       \n" +
"            </div>\n" +
"		  </div>\n" +
"		 \n" +
"		  <div class=\"row\">\n" +
"		      <div class=\"col-md-12 col-sm-12 col-xs-12 list-top-head show-record\">\n" +
"			      <div class=\"panel-body\">\n" +
"			       \n" +
"			    <div class=\"table-responsive\">\n" +
"				    <table class=\"table table-bordered\">\n" +
"					  <tr>\n" +
"                            <th>UId</th>\n" +
"                            <th> Name</th>\n" +
"                            <th>User Type</th>\n" +
"                            <th>Email</th>\n" +
"							<th>Contact</th>\n" +
"							<th>UserStatus</th>\n" +
"                            <th>File</th>\n" +
"                            <th>Action</th>\n" +
"                        </tr>");
                            while(itr.hasNext())
                            {
                               UserBean ub = itr.next();
                               id=ub.getUserid();
                               session.setAttribute("id",ub.getUserid());
                               out.println(" <tr>\n" +"<td>"+ub.getUserid()+"</td>"); 
                               out.println("<td>"+ub.getName()+"</td>");
                               out.println("<td>"+ub.getUserType()+"</td>");
                               out.println("<td>"+ub.getEmail()+"</td>");
                               out.println("<td>"+ub.getContact()+"</td>");
                               if(ub.isUserstatus()){
                                   
                            out.println("<td><a href=\"changestatus?id="+id+"\" class=\"btn btn-primary\"><i class=\"fas fa-exchange-alt\" aria-hidden=\"true\"></i></a>+"+"Active");
                               }
                               else{
                                      
                               out.println("<td><a href=\"changestatus?id="+id+"\" class=\"btn btn-primary\"><i class=\"fas fa-exchange-alt\" aria-hidden=\"true\"></i></a>+"+"InActive");
                               }
                               out.println("<td><a href=\"#\" class=\"btn btn-primary view-file\">View</a></td> \n" +
"						  <td><a href=\"editservlet?id="+id+"\" class=\"btn btn-primary\"><i class=\"fa fa-pencil-square-o\" aria-hidden=\"true\"></i>\n" +
"						     </a><a href=\"deleteservlet?id="+id+"\" class=\"btn btn-primary\"><i class=\"fa fa-trash\" aria-hidden=\"true\"></i></a>\n" +
"						  </td>\n" +
"						</tr>");
                            }
                 out.println("					</table>\n" +
"				</div>\n" +
"			 </div>\n" +
"		</div>\n" +
"       </div>\n" +
"	</div>\n" +
"  </section>\n" +
" </body>\n" +
"<html>");
      }
        catch(Exception e)
		{
			System.out.println("Exception in  ManageUserServlet(int id)"+e);
		}
    }
    
}
