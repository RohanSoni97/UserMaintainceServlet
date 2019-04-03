package Services;

import Beans.GalleryBean;
import Beans.UserBean;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManageGalleryServices 
{
    public static List<GalleryBean> getAllEmployees()
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<GalleryBean> empSet=null;
		try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select imgid,Name,title,imgstatus from imagemaster");
				rs=pstmt.executeQuery();
				empSet=new ArrayList<GalleryBean>();
				while(rs.next())
				{
					GalleryBean emp=new GalleryBean();
					emp.setImgid(rs.getInt("imgid"));
					emp.setName(rs.getString("Name"));
                                        emp.setTitle(rs.getString("title"));
					emp.setImgstatus(rs.getBoolean("imgstatus"));
                                        
					empSet.add(emp);
				}
		}
		catch(Exception e)
		{
			System.out.println("Exception in ManageGalleryServices: getAllEmployees()"+e);
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
				System.out.println("Exception in ManageGalleryServices: finally getAllEmployees()"+e);
			}

		}
		
		return empSet; //read only
	}
    public static boolean addEmployee(GalleryBean emp)
 	{
	Connection con=null;
	PreparedStatement pstmt=null;
	try
	{
	con=DBConnection.connect();
	pstmt=con.prepareStatement("insert into imagemaster (Name,title,description,imgstatus) values(?,?,?,?);");
	
	pstmt.setString(1,emp.getName());
	pstmt.setString(2,emp.getTitle());
        pstmt.setString(3,emp.getDescription());
        pstmt.setBoolean(4,emp.isImgstatus());
       
	int result=pstmt.executeUpdate();
	return (result==1);
	}
	catch(Exception e)
		{
		System.out.println("Exception in ManageGalleryServices  addEmployee"+e);
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
                                System.out.println("Exception in ManageGalleryServices  finally addEmployee"+e);
                                }

		}
		return false;
	}
     public static boolean getStatus(int id)
   {
                Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
               
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select imgstatus from imagemaster where imgid=?");
				pstmt.setInt(1,id);
                                
                                rs=pstmt.executeQuery();
                                if(rs.next())
                               return(rs.getBoolean("imgstatus"));
                }
                	catch(Exception e)
		{
			System.out.println("Exception in  ManageGalleryServices getStatus(int id)"+e.getMessage());
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
                                System.out.println("Exception in ManageGalleryServices finally getStatus(int id)"+e);
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
				pstmt=con.prepareStatement("UPDATE imagemaster SET imgstatus=? WHERE imgid=?;");
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
                                pstmt=con.prepareStatement("delete from imagemaster where imgid=?;");
                                pstmt.setInt(1,id);
                                int result=pstmt.executeUpdate();
                                return (result==1);
                }
                catch(Exception e)
                 {
                        System.out.println("Exception in ManageGalleryServices deleteUser(int id)"+e);
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
                                System.out.println("Exception in ManageGalleryServices finally deleteUser(int id)"+e);
				}

		}
         return false;
     }
public static List<GalleryBean> getEmployees(int currentaccount)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<GalleryBean> empSet=null;
		try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("select imgid,Name,title from imagemaster where imgid=?");
				pstmt.setInt(1,currentaccount);
                                rs=pstmt.executeQuery();
				empSet=new ArrayList<GalleryBean>();
				if(rs.next())
				{
					GalleryBean emp=new GalleryBean();
                                        emp.setImgid(currentaccount);
                                        emp.setName(rs.getString("Name"));
					emp.setTitle(rs.getString("title"));
					
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

public static boolean updateEmployee(GalleryBean emp)
	{
		Connection con=null;
	PreparedStatement pstmt=null;
	try
	{
	con=DBConnection.connect();
	pstmt=con.prepareStatement("update imagemaster set Name=?,title=? where imgid=?");
	pstmt.setInt(3,emp.getImgid());
	pstmt.setString(1,emp.getName());
	pstmt.setString(2,emp.getTitle());
       
	int result=pstmt.executeUpdate();
	return (result==1);
	}
                catch(Exception e)
		{
		System.out.println("Exception in ManageGalleryServices  updateEmployee"+e);
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
		System.out.println("Exception in ManageGalleryServices finally updateEmployee"+e);
				}

		}
		return false;

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
				pstmt=con.prepareStatement("select Name from imagemaster where imgid=?");
				pstmt.setInt(1,id);
                                
                                rs=pstmt.executeQuery();
                                if(rs.next())
                                name=rs.getString("Name");
                }
                	catch(Exception e)
		{
			System.out.println("Exception in ManageGalleryServices getName(int id)"+e);
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
                                System.out.println("Exception in ManageGalleryServices finally updateEmployee getName(int id)"+e);
                                }
                }
                return name;
	
   }
public static List<String> getNames()
   {
                Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
                String name="";
                List<String> empSet=null;
                try
		{
				con=DBConnection.connect();
				pstmt=con.prepareStatement("SELECT Name FROM imagemaster LIMIT 3;");
				empSet=new ArrayList<String>();
                                
                                rs=pstmt.executeQuery();
                                while(rs.next())
                                {
                                name=rs.getString("Name");
                                
                                 empSet.add(name);
                                }
                               
                               
                }
                	catch(Exception e)
		{
			System.out.println("Exception in ManageGalleryServices getNames()"+e);
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
                                System.out.println("Exception in ManageGalleryServices finally updateEmployee getNames()"+e);
                                }
                }
                return empSet;
	
   }
}
