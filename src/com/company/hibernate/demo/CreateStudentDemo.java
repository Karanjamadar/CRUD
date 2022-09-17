package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.company.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
//		Create session factory 
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
//		Create session
		Session session = factory.getCurrentSession();	
		
		try {
			
//			create student object
			System.out.println("creating a new student object");
			
			Student tempStudent = new Student("Karan","Jamadar","Karan@gmail.com");
			
//			start the transaction
					session.beginTransaction();
			
//			save the student object
				System.out.println("saving the student");
			session.save(tempStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
			
		}
											

	}

}
