/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Beans.UserBean;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProfileMaintainceService 
{
 public static List<UserBean> getEmployees(int currentaccount)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<UserBean> empSet=null;
		try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select userid,username,usertype,name,email,contact,address,userstatus from usermaster where userid=?");
				pstmt.setInt(1,currentaccount);
                                rs=pstmt.executeQuery();
				empSet=new ArrayList<UserBean>();
				if(rs.next())
				{
					UserBean emp=new UserBean();
					emp.setUserid(rs.getInt("userid"));
					emp.setUsername(rs.getString("username"));
					//emp.setUserType(rs.getString("usertype"));
                                        emp.setName(rs.getString("name"));
                                        emp.setEmail(rs.getString("email"));
                                        emp.setContact(rs.getString("contact"));
                                        emp.setAddress(rs.getString("address"));
                                       // emp.setUserstatus(rs.getBoolean("userstatus"));
					empSet.add(emp);
				}
		}
		catch(Exception e)
		{
			System.out.println("Exception in  getEmployees()"+e);
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
				System.out.println("Exception in finally getEmployees()"+e);
			}

		}
		
		return empSet; 
	}
 public static String getName(int id)
   {
                Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
                String name="";
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select name from usermaster where userid=?");
				pstmt.setInt(1,id);
                                
                                rs=pstmt.executeQuery();
                                if(rs.next())
                                name=rs.getString("name");
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
			}
				catch(Exception e)
                                {
                                System.out.println("Exception in finally updateEmployee"+e);
                                }
                }
                return name;
	
   }
 public static String getPassword(int id)
   {
                Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
                String password="";
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select password from usermaster where userid=?");
				pstmt.setInt(1,id);
                                
                                rs=pstmt.executeQuery();
                                if(rs.next())
                                password=rs.getString("password");
                }
                	catch(Exception e)
		{
			System.out.println("Exception in  getPassword(int id)"+e);
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
                                System.out.println("Exception in finally getPassword(int id)"+e);
                                }
                }
                return password;
	
   }
 public static String getUserType(int id)
   {
                Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
               
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select usertype from usermaster where userid=?");
				pstmt.setInt(1,id);
                                
                                rs=pstmt.executeQuery();
                                if(rs.next())
                               return(rs.getString("usertype"));
                }
                	catch(Exception e)
		{
			System.out.println("Exception in  getStatus(int id)"+e.getMessage());
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
                                System.out.println("Exception in finally getStatus(int id)"+e);
                                }
                }
                return "";
	
   }

 public static boolean getStatus(int id)
   {
                Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
               
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select userstatus from usermaster where userid=?");
				pstmt.setInt(1,id);
                                
                                rs=pstmt.executeQuery();
                                if(rs.next())
                               return(rs.getBoolean("userstatus"));
                }
                	catch(Exception e)
		{
			System.out.println("Exception in  getStatus(int id)"+e.getMessage());
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
                                System.out.println("Exception in finally getStatus(int id)"+e);
                                }
                }
                return false;
	
   }
   public static boolean changeStatus(int id,int status)
   {
       Connection con=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("UPDATE usermaster SET userstatus=? WHERE userid=?;");
				pstmt.setInt(2,id);
                                pstmt.setInt(1,status);
                                int result=pstmt.executeUpdate();
                                return (result==1);
                }
                catch(Exception e)
                {
                    System.out.println("Exception in  changeStatus(int id,int status)"+e);
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
                                System.out.println("Exception in finally changeStatus(int id,int status)"+e);
				}

		}
       return false;
   }
     public static boolean deleteUser(int id)
     {
       Connection con=null;
       PreparedStatement pstmt=null;
       ResultSet rs=null;
                try
		{
				con=DBConnection.connect();
                                pstmt=con.prepareStatement("delete from usermaster where userid=?;");
                                pstmt.setInt(1,id);
                                int result=pstmt.executeUpdate();
                                return (result==1);
                }
                catch(Exception e)
                 {
                        System.out.println("Exception in deleteUser(int id)"+e);
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
                                System.out.println("Exception in finally deleteUser(int id)"+e);
				}

		}
         return false;
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
      public static boolean updateUserProfile(UserBean emp)
	{
	Connection con=null;
	PreparedStatement pstmt=null;
	try
	{
	con=DBConnection.connect();
	pstmt=con.prepareStatement("update usermaster set username=?,name=?,email=?,contact=?,address=? where userid=?");
	pstmt.setInt(6,emp.getUserid());
        pstmt.setString(1,emp.getUsername());
	pstmt.setString(2,emp.getName());
        pstmt.setString(3,emp.getEmail());
	pstmt.setString(4,emp.getContact());
        pstmt.setString(5,emp.getAddress());
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
     public static boolean updatePassword(int id,String password)
	{
		Connection con=null;
	PreparedStatement pstmt=null;
        try
	{
         con=DBConnection.connect();
         pstmt=con.prepareStatement("update usermaster set password=? where userid=?;");
         pstmt.setInt(2,id);
         pstmt.setString(1, password);
         int result=pstmt.executeUpdate();
         return (result==1);
        }
        catch(Exception e)
	{
	System.out.println("Exception in updatePassword(int id)"+e);
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
                        System.out.println("Exception in finally updatePassword(int id)"+e);
			}

		}
        return false;
        }
}
