package StudentManagement;

import java.util.*;
public class Mainn {
	
	

	public static void main(String[] args)  {
		
		Scanner scan= new Scanner(System.in);
		
		
		
		
		StudentDAO std=new StudentDAO();
		
		
		String ch = null;
		
		do {
			
			System.out.println("Enter 1 to InsertStudent details");
			System.out.println("Enter 2 to ViewAll-StudentDetails ");
			System.out.println("Enter 3 to GetStudent by his id");
			System.out.println("Enter 4 to Update the Student name by there id");
			System.out.println("Enter 5 to delete the Student-detail by there id ");
			
			System.out.println();
			System.out.println("Enter your Choice ");
			int n=scan.nextInt();
			
		switch(n)
		{
		case 1: 
			
			
			
			System.out.println("Enter the Student-Id to insert");
			int id=scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Student-name to insert");
			String name=scan.nextLine();
			System.out.println("Enter the Student-age to insert");
			int age=scan.nextInt();
			
			std.insertStudent(id, name, age);
			
			break;
			
			
		case 2:
			
			List<Student> res=std.viewAllStudents();
			
			
			for(Student result:res)
			{
				System.out.println(result.id);
				System.out.println(result.name);
				System.out.println(result.age);
				System.out.println();
			}
			
			break;
			
		case 3:
			
			System.out.println("Enter the Student-id to retrive details");
			int id1=scan.nextInt();
			
			Student res1=std.getStudent(id1);
			
			System.out.println(res1.id);
			System.out.println(res1.name);
			System.out.println(res1.age);
			
			break;
			
			
		case 4:
			
			System.out.println("Enter the Student-id where to update ");
			int id2=scan.nextInt();
	        scan.nextLine();
		  
			System.out.println("Enter the Student-name");
			String name1=scan.nextLine();
			
			Student res2=std.updateStudent(name1,id2);
			
			if(res2==null)
			{
				System.out.println("Student not found or update failed");
			}else {
			System.out.println(res2.id);
			System.out.println(res2.name);
			System.out.println(res2.age);
			
			}
			
			break;
			
		case 5:
			
			System.out.println("Enter the Student-id to delete the details");
			int sid=scan.nextInt();
			
			List<Student> lst =std.deleteStudent(sid);
			
			if(lst==null)
			{
				System.out.println("Student wasn't deleted or wasn't found");
				
			}else {
			
			for(Student result:lst)
			{
				System.out.println(result.id);
				System.out.println(result.name);
				System.out.println(result.age);
			}
			}
			
			break;
		}
		

		System.out.println("Enter Y to continue or N to exit");
       
		ch=scan.next();		
		} while(ch.equalsIgnoreCase("Y"));
		
		
		System.out.println("Thank you for using Student Management System. Goodbye!");
	
		
		
	}

}
