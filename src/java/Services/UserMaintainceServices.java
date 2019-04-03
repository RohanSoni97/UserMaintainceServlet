
package Services;

import Beans.UserBean;
import DB.DBConnection;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.*;


public class UserMaintainceServices {
public static List<UserBean> getAllEmployees()
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<UserBean> empSet=null;
		try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select userid,username,usertype,name,email,contact,address,userstatus from usermaster");
				rs=pstmt.executeQuery();
				empSet=new ArrayList<UserBean>();
				while(rs.next())
				{
					UserBean emp=new UserBean();
					emp.setUserid(rs.getInt("userid"));
					emp.setUsername(rs.getString("username"));
					emp.setUserType(rs.getString("usertype"));
                                        emp.setName(rs.getString("name"));
                                        emp.setEmail(rs.getString("email"));
                                        emp.setContact(rs.getString("contact"));
                                        emp.setAddress(rs.getString("address"));
                                        emp.setUserstatus(rs.getBoolean("userstatus"));
					empSet.add(emp);
				}
		}
		catch(Exception e)
		{
			System.out.println("Exception in  getAllEmployees()"+e);
		}
		finally		
		{
			try
			{
				pstmt.close();
				con.close();
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception in finally getAllEmployees()"+e);
			}

		}
		
		return empSet; //read only
	}
    public static boolean addEmployee(UserBean emp)
 	{
	Connection con=null;
	PreparedStatement pstmt=null;
	try
	{
	con=DBConnection.connect();
	pstmt=con.prepareStatement("insert into usermaster (username,password,usertype,name,email,contact,address,userstatus) values(?,?,?,?,?,?,?,?);");
	
	pstmt.setString(1,emp.getUsername());
	pstmt.setString(2,emp.getPassword());
        pstmt.setString(3,emp.getUserType());
        pstmt.setString(4,emp.getName());
        pstmt.setString(5,emp.getEmail());
        pstmt.setString(6,emp.getContact());
        pstmt.setString(7,emp.getAddress());
        pstmt.setBoolean(8,emp.isUserstatus());
	int result=pstmt.executeUpdate();
	return (result==1);
	}
	catch(Exception e)
		{
		System.out.println("Exception in addEmployee"+e);
		}
		finally
		{
			try
			{
				pstmt.close();
				con.close();
			}
				catch(Exception e)
			{
		System.out.println("Exception in finally addEmployee"+e);
				}

		}
		return false;
	}
    public static UserBean searchById(int id)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		UserBean emp=null;
		try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select userid,email,contact,address from usermaster where userid=?");
				pstmt.setInt(1,id);
				rs=pstmt.executeQuery();
			
					
					
					if(rs.next())
                                            {
            
                                    UserBean usb=new UserBean();
                                    usb.setUserid(rs.getInt("userid"));
                                    usb.setEmail(rs.getString("email"));
                                    usb.setContact(rs.getString("contact"));
                                    usb.setAddress(rs.getString("address"));
                                    return usb;
            
                                            }
 
                }
				
		
		catch(Exception e)
		{
			System.out.println("Exception in  searchById(int id)"+e);
		}
		finally		
		{
			try
			{
				pstmt.close();
				con.close();
				rs.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception in finally searchById(int id)"+e);
			}
			
		}
                return null;
	}
    public static boolean updateEmployee(UserBean emp)
	{
		Connection con=null;
	PreparedStatement pstmt=null;
	try
	{
	con=DBConnection.connect();
	pstmt=con.prepareStatement("update usermaster set email=?,contact=?,address=? where userid=?");
	pstmt.setInt(4,emp.getUserid());
	pstmt.setString(1,emp.getEmail());
	pstmt.setString(2,emp.getContact());
        pstmt.setString(3,emp.getAddress());
	int result=pstmt.executeUpdate();
	return (result==1);
	}
	catch(Exception e)
		{
		System.out.println("Exception in updateEmployee"+e);
		}
		finally
		{
			try
			{
				pstmt.close();
				con.close();
			}
				catch(Exception e)
			{
		System.out.println("Exception in finally updateEmployee"+e);
				}

		}
		return false;

	}
    
}
