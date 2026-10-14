package StudentManagement;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
	
  public void insertStudent(int n,String m,int o)
  {
	  
	  String sql="Insert into students values(?,?,?)";
	  
	  try

	  {
		  
	
		 try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Hitman");
				  PreparedStatement ps=con.prepareStatement(sql)) { 
			 
			  con.setAutoCommit(false);
			  ps.setInt(1, n);
			  ps.setString(2, m);
			  ps.setInt(3, o);
			  
			  
//            if we are adding the multiple student after this call
//			  ps.addBatch();
//            ps.setInt(1, 0);
//			  ps.setString(2, 0);
//			  ps.setInt(3, 0);
//			  ps.addBtch()
//			  ps.executeBatch();  it return the integer array store it in the result and execute only by one in for-each loop....
           
			  
			  
			  System.out.println(ps.executeUpdate());	
			  
			
			  
			 con.commit();
			  
		 }
		  
	  }catch(SQLException e1)
	  {
		  e1.printStackTrace();
	  }
  }
	
  
  
  public List<Student> viewAllStudents()
  {
	  String sql="Select * from students";
	  
	  try
	  {
		  try( Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","groot","Hitman");
				  Statement stm=con.createStatement();
		  ResultSet res=stm.executeQuery(sql);) {
			  
			  List<Student> lt=new ArrayList<>();
			  while(res.next())
			  {
				  Student s=new Student(res.getInt("id"),res.getString("name"),res.getInt("age"));
				  
				  lt.add(s);
				  
			  }
			  
			  return lt;
			  
			}
		  
		  
	  }catch(SQLException e1)
	  {
		  e1.printStackTrace();
		  return null;
		  
	  }
	
	  
  }
  
  
  
  public Student getStudent(int n)
  
  {
	  String sql="Select * from students where id=?";
	  
	  try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","groot","Hitman");
				  PreparedStatement ps=con.prepareStatement(sql))
	  {
		  ps.setInt(1, n);
		  
		  try( ResultSet res=ps.executeQuery()){
			  
		 
		  
		 while (res.next())
		  {
			  Student s1=new Student(res.getInt("id"),res.getString("name"),res.getInt("age"));
			  
			  return s1;
		  }
		  
		  return null;
		  
	 }
	  }
	  catch(SQLException e1)
	  {
		  e1.printStackTrace();
		  return null;
		  
	  
	  }
	  
	  
  }
  
  
  
  public  Student updateStudent(String n,int m)

  {
	  String sql="Update students set name=? where id=?";
	  
	  try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","groot","Hitman");
			  PreparedStatement ps=con.prepareStatement(sql))
	  {
	      ps.setString(1, n);
	      System.out.println("Name received: " + n);
		  
	      ps.setInt(2,m);
	      
		  int res=ps.executeUpdate();
		  System.out.println("Rows affected"+res);
		  
		  if(res==1)
		  {
			 Student rst= getStudent(m);
			 System.out.println("Name from DB:"+rst.name);
			  return rst;
			  
		  }else
		  {
			  return null;
			  
		  }
		  
		       
	}
	  catch(SQLException e)
	  {
		  e.printStackTrace();
		  return null;
		  
	  }
	  
	  
  }
  
  
  
  public List<Student> deleteStudent(int n)
  {
	  String sql="Delete from students where id=?";
	  
	  try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","groot","Hitman");
			  PreparedStatement ps=con.prepareStatement(sql))
	  {
		  
		  ps.setInt(1, n);
		  
		  int res1=ps.executeUpdate();
		  
		 if(res1==1)
		 {
			System.out.println("Number of Studnet details deleted"+ res1); 
			 
			 List<Student>rst=viewAllStudents();
			 
			 return rst;
		 }else
		 {
			 return null;
		 }
		  
		 
		 
		  
		  
		  
	  }catch(SQLException e)
	  {
		  e.printStackTrace();
		  return null;
	  }
	  
  }
}
