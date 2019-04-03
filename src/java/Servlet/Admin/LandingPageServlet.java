package Servlet.Admin;

import Beans.GalleryBean;
import Services.ManageGalleryServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LandingPageServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    try(PrintWriter out=resp.getWriter())
        {
          ServletContext con=getServletContext();
          String filepath=con.getInitParameter("DownloadPath");
          String path=con.getInitParameter("GalleryPath");
          
          resp.setHeader("Cache-Control", "no-cache");
          resp.setHeader("Cache-Control", "no-store");
          resp.setDateHeader("Expires", 0);
          resp.setHeader("Pragma", "no-cache");
          List<String> allemployees=ManageGalleryServices.getNames();
          Iterator<String> itr=allemployees.iterator();
          out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <title>Myfirstpage</title>\n" +
"\n" +
"	\n" +
"	<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n" +
"	\n" +
"	<link rel=\"stylesheet\" href=\"css/user.css\">\n" +
"	<link rel=\"stylesheet\" href=\"new.css\">\n" +
"	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n" +
"	\n" +
"    <!-- CSS -->\n" +
"</head>\n" +
"<body>\n" +
"<header>\n" +
"<div class=\"container-fluid fixed-top\">\n" +
"		<div class=\"row\">\n" +
"				<div class=\"col-md-3 text-center\">\n" +
"					<a href=\"#\"><img src=\"images/images.jpg\" class=\"img-responsive logo\"/></a>\n" +
"				</div>\n" +
"			\n" +
"		\n" +
"		\n" +
"			<div class=\"col-md-9\">\n" +
"						<ul class=\"navigation\">\n" +
"							\n" +
"							<li><a href=\"User.html\">Home</a></li>\n" +
"							<li><a href=\"#aboutus\">AboutUs</a></li>\n" +
"							<li><a href=\"#contact\">ContactUs</a></li>\n" +
"							<li><a href=\"#users\">OurUsers</a></li>						\n" +
"							<li><a href=\"SignUp.html\">SignIn</a></li>\n" +
"							<li>\n" +
"							<a href=\"Login.html\" class=\"zgh-login\" style=\"display: inline-block;\">Login</a>\n" +
"							\n" +
"							</li>\n" +
"						</ul>\n" +
"			</div>\n" +
"				\n" +
"		</div>\n" +
"</div>\n" +
"		\n" +
"\n" +
"</header>\n" +
"\n" +
"<section id=\"screenshot\">\n" +
"	<div class=\"content-wrap animated\">\n" +
"		<div class=\"slide-wrap\">\n" +
"			<div class=\"col-md-12 text-center\">\n" +
"							<img src=\"images/users.png\"  \n" +
"							style=\"height: auto;\"\n" +
"							class=\"img\">\n" +
"			</div>\n" +
"			\n" +
"	</div>\n" +
"</section>\n" +
"<section id=\"1\">\n" +
"<div class=\"container\">\n" +
"		<div class=\"row\">\n" +
"			<div class=\"col-md-12 text-center\">\n" +
"				<h1>Customer-relationship management</h1>\n" +
"				<p>\n" +
"				Customer-relationship management (CRM) is an approach to manage a company's interaction with current and potential customers. It uses data analysis about customers' history with a company to improve business relationships with customers, specifically focusing on customer retention and ultimately driving sales growth.</p>\n" +
"				</p>\n" +
"			</div>\n" +
"		</div>\n" +
"	</div>\n" +
"</section>\n" +
"\n" +
"<section id=\"screenshot\">\n" +
"	<div class=\"content-wrap animated\">\n" +
"	<div class=\"row\">\n" +
"		\n" +
"			<div class=\"col-md-6 text\">\n" +
"							<img src=\"images/crm.png\"  \n" +
"							style=\"height: auto;\">\n" +
"			</div>\n" +
"			<div class=\"col-md-6 text\">\n" +
"			<h1>we understand your world</h1>\n" +
"			<div class=\"content-wrap animated\">\n" +
"			<p><img src=\"images/we.jpg\"/>\n" +
"			</div>\n" +
"			</div>\n" +
"			</div>\n" +
"			</div>\n" +
"	\n" +
"</section>\n" +
"<section id=\"aboutus\">\n" +
"	<div class=\"container\">\n" +
"		<div class=\"row\">\n" +
"			<div class=\"col-md-12 text-center\">\n" +
"				<h1>About us</h1>\n" +
"				<p>Browsing?\n" +
"						Please use the search box at the top of this page or the links to the right. Feel free to subscribe to our syndicated feeds.<a href=\"AboutUs.html\">Read more</a>\n" +
"							</p><button \n" +
"			</div>\n" +
"					</div>\n" +
"	</div>\n" +
"</section>\n" +
"<section id=\"users\">\n" +
"<div class= \"col-md-12 text-center\" id=\"3\"><pre>	    				                <h1 color=\"#fff\">	             Our Users				</h1>	</pre></div>");
          
          while(itr.hasNext())
               {
              String name=itr.next();
               out.println("<div class=\"col-md-4 text-center\">\n" +
"					<img src=\""+filepath+name+"\" alt=\"Uploading\" class=\"imi\"/>\n" +
"						<pre>Name:"+filepath+name+"\n" +
"Location:Chandigarh\n" +
"						</pre>\n" +
"</div>");
               }
          out.println("</div>					\n" +
"\n" +
"</section>\n" +
"<div id=\"demo\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
"\n" +
"  <!-- Indicators -->\n" +
"  <ul class=\"carousel-indicators\">\n" +
"    <li data-target=\"#demo\" data-slide-to=\"0\" class=\"active\"></li>\n" +
"    <li data-target=\"#demo\" data-slide-to=\"1\"></li>\n" +
"    <li data-target=\"#demo\" data-slide-to=\"2\"></li>\n" +
"  </ul>\n" +
"  \n" +
"  <!-- The slideshow -->\n" +
"  <div class=\"carousel-inner\">\n" +
"    <div class=\"carousel-item active\">\n" +
"      <img src=\"images/hanna.png\" alt=\"Los Angeles\" width=\"1100\" height=\"500\">\n" +
"    </div>\n" +
"    <div class=\"carousel-item\">\n" +
"      <img src=\"images/CRM-productivity.png\" alt=\"Chicago\" width=\"1100\" height=\"500\">\n" +
"    </div>\n" +
"    <div class=\"carousel-item\">\n" +
"      <img src=\"images/recruit-home-screen.png\" alt=\"New York\" width=\"1100\" height=\"500\">\n" +
"    </div>\n" +
"  </div>\n" +
"  \n" +
"  <!-- Left and right controls -->\n" +
"  <a class=\"carousel-control-prev\" href=\"#demo\" data-slide=\"prev\">\n" +
"    <span class=\"carousel-control-prev-icon\"></span>\n" +
"  </a>\n" +
"  <a class=\"carousel-control-next\" href=\"#demo\" data-slide=\"next\">\n" +
"    <span class=\"carousel-control-next-icon\"></span>\n" +
"  </a>\n" +
"</div>\n" +
"\n" +
"\n" +
"<footer class=\"foot\">\n" +
"	<div class=\"container\">\n" +
"		<div class=\"row\">\n" +
"			<div class=\"col-md-4\">\n" +
"				<h2>Company</h2>\n" +
"				<ul class=\"floor grid__list--fmenu\">\n" +
"					<li>About us</li>\n" +
"					<li>career</li>\n" +
"					\n" +
"				</ul>\n" +
"			</div>\n" +
"			<div class=\"col-md-4\">\n" +
"				<h2>Services</h2>\n" +
"				<ul  class=\"floor grid__list--fmenu\">\n" +
"					<li>CRM</li>\n" +
"					<li>ERP</li>\n" +
"					\n" +
"				</ul>\n" +
"			</div>\n" +
"			<div class=\"col-md-4\">\n" +
"				<h2>Products</h2>\n" +
"				<ul class=\"floor grid__list--fmenu\">\n" +
"					<li>Hana 4</li>\n" +
"					<li>Health Care</li>\n" +
"					\n" +
"				</ul>\n" +
"			</div>\n" +
"		</div>\n" +
"		</div>\n" +
"		<div id=\"contact\">\n" +
"		<div class=\"col-md-12 text-center\">\n" +
"		<h5>ContactUs At</h5>\n" +
"		</div>\n" +
"		<div class=\"col-md-12 text-center\">\n" +
"		\n" +
"		<img src=\"images/linkedin.png\" alt=\"Uploading\" class=\"imag\"/>\n" +
"		<img src=\"images/twitter.png\" alt=\"Uploading\" class=\"imag\"/>\n" +
"		<img src=\"images/download.png\" alt=\"Uploading\" class=\"imag\"/>\n" +
"		<img src=\"images/face.png\" alt=\"Uploading\" class=\"imag\"/>\n" +
"		<img src=\"images/insta.png\" alt=\"Uploading\" class=\"imag\"/>\n" +
"		</div>	\n" +
"		</div>\n" +
"		<div class=\"col-lg-12 col-md-12 col-xl-12 col-sm-12 text-center\">\n" +
"					<p class=\"text-center\">Subscribe to our mailing list</p>\n" +
"					<input type=\"text\" class=\"form-control\" placeholder=\"Email\" width=\"200px\">\n" +
"<br>\n" +
"					<a href=\"#\" class=\" text-white btn\" style=\" \">Subscribe</a>\n" +
"					<p class=\"text-center\" style=\"margin-top: 70px\">©2019 Copyright Users Pvt. Ltd.</p>\n" +
"					<a id=\"back2Top\" title=\"Back to top\" href=\"#\" style=\"display: inline;\"><i class=\"fas fa-arrow-circle-up\"></i></a>\n" +
"		\n" +
"		\n" +
"	</div>\n" +
"	\n" +
"\n" +
"</footer>		\n" +
"</body>\n" +
"</html>");
          
        }   
        catch(Exception e)
        {
            System.out.println("Exception in LandingPageServlet"+e);
        }
    }
    
}
