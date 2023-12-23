package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entites.Student;


public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("my database started");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		/*
		 * Student student=new Student(1,"Nirmal","ctc"); int r =
		 * studentDao.insert(student); 
		 * System.out.println("done"+r);
		 */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        
        boolean go=true;
        while (go) {
        	System.out.println("Press 1 for add new student : ");
            System.out.println("Press 2 for display details all student : ");
            System.out.println("Press 3 for display details single student : ");
            System.out.println("Press 4 for delete student details : ");
            System.out.println("Press 5 for update student : ");
            System.out.println("Press 6 for exit : ");
            
            try {
            	
            	int input = Integer.parseInt(br.readLine());
            	
            	switch (input) {
				case 1:
					//for add new student
					//taking input from user
					System.out.println("Enter your id :");
					int sId=Integer.parseInt(br.readLine());
					
					System.out.println("Enter your name :");
					String userName=br.readLine();
					
					System.out.println("Enter your city :");
					String userCity=br.readLine();
					
					//creating student object
					Student student = new Student();
					student.setStudentId(sId);
					student.setStudentName(userName);
					student.setStudentCity(userCity);
					//setting student obj to db by calling insert() from dao
					int result = studentDao.insert(student);
					System.out.println(" Id no : "+result+ " is added to DB ");
					System.out.println("******************************");
					System.out.println();
					break;

				case 2:
					//for display all student details
					System.out.println("*********************************");
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("Student id : "+st.getStudentId());
						System.out.println("Student name : "+st.getStudentName());
						System.out.println("Student city : "+st.getStudentCity());
						System.out.println("---------------------------------------------");
						System.out.println("***********************************");
					}
					
					break;
				case 3:
					//for display single student details
					System.out.println("***********************************");
					System.out.println("Enter your id : ");
					Integer sid = Integer.parseInt(br.readLine());
					Student student2 = studentDao.getStudent(sid);
					System.out.println("Student detais : ");
					System.out.println("id : "+student2.getStudentId());
					System.out.println("name : "+student2.getStudentName());
					System.out.println("city : "+student2.getStudentCity());
					System.out.println("---------------------------------------------");
					System.out.println("***********************************");
					break;
				case 4:
					//for delete dtudent details
					System.out.println("***********************************");
					System.out.println("Enter your id : ");
					Integer s2id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(s2id);;
					System.out.println("Student delails deleted...");
					break;
				case 5:
					//for update student details
					System.out.println("Enter your id :");
					int sId1=Integer.parseInt(br.readLine());
					
					System.out.println("Enter your name :");
					String userName1=br.readLine();
					
					System.out.println("Enter your city :");
					String userCity1=br.readLine();
					
					//creating student object
					Student student3 = new Student();
					student3.setStudentId(sId1);
					student3.setStudentName(userName1);
					student3.setStudentCity(userCity1);
					//setting student obj to db by calling insert() from dao
					studentDao.updateStudent(student3);;
					System.out.println(" Id no : "+sId1+ " is updated to DB ");
					System.out.println("******************************");
					System.out.println();
					break;
				case 6:
					//for exit
					go=false;
					break;
				}
            	 
            	
				
			} catch (Exception e) {
				System.out.println("Invalid input data please try again !");
				System.out.println(e.getMessage());
			}
           
		}
        System.out.println("Thanks for using my application...");
        System.out.println("Visit again....");
    }
    
}
