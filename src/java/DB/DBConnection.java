
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
    public static Connection connect()
    {
        Connection con=null;
        
        try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/usermaster","root","");
	
        }
        catch(Exception e)
	{
	System.out.println("Exception in DBConnection"+e.getMessage());
	}
	return con;
    }    
}
