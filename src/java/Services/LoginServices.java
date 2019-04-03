package Services;

import Beans.UserBean;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServices 
{
public static UserBean authenticateUser(String username,String Password)
    {
        Connection con=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;

        try
        {
        con=DBConnection.connect();
        stmt=con.prepareStatement("select userid,usertype,password,userstatus from usermaster where username=?");
        
        stmt.setString(1,username);
        rs=stmt.executeQuery();
        if(rs.next())
        {
            if(Password.equals(rs.getString("password")))
            {
                UserBean usb=new UserBean();
                usb.setUserid(rs.getInt("userid"));
                usb.setUserType(rs.getString("usertype"));
                usb.setUserstatus(rs.getBoolean("userstatus"));
                return usb;
            }
        }
        }
        catch(Exception e)
	{
	System.out.println("Exception in LoginServices"+e.getMessage());
	}
        finally
	{
	try
	{
	stmt.close();
	con.close();
	rs.close();
        }
	catch(Exception e)
	{
	System.out.println("Exception in LoginServices finally"+e.getMessage());
	}
	}
	
        return null;
    }    
}
