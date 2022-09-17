package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.company.hibernate.demo.entity.Student;

import java.util.*;

public class QueryStudentDemo2 {

	public static void main(String[] args) {
//		Create session factory 
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
//		Create session
		Session session = factory.getCurrentSession();	
		
		try {
			

//			start the transaction
					session.beginTransaction();
			
					
//					query the students 
					List<Student> theStudents = session.createQuery("from Student").getResultList();					
//					display the students
					displayStudent(theStudents);
					
//					Query students last name : "Jamadar"
					theStudents =session.createQuery("from Student s where s.lastName='Jamadar'").getResultList(); 
//					display the students
					System.out.println("\n\nthe students who hava last name Jamadar");
					displayStudent(theStudents);
					
//					Query students last name : 'Jamadar' OR first name 'sakshi'
						theStudents =session.createQuery("from Student s where s.lastName='Jamadar' OR s.firstName = 'sakshi'" ).getResultList(); 
//						display the students
						System.out.println("\n\nthe students who hava last name Jamadar");
						displayStudent(theStudents);
						

//						Query students emailaddressess : 
						theStudents =session.createQuery("from Student s where "
								+ "s.email LIKE '%gmail.com'" ).getResultList(); 
//						display the students
						System.out.println("\n\nthe students who have email ends with gmail.com");
						displayStudent(theStudents);
					
					
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
			
		}
											

	}

	private static void displayStudent(List<Student> theStudents) {
		for (Student theStudent : theStudents) {
			System.out.println(theStudent);
		}
	}

}
