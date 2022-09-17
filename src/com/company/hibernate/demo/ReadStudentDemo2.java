package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.company.hibernate.demo.entity.Student;

public class ReadStudentDemo2 {

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
			
			Student tempStudent = new Student("Rick","grimes","Rick@gmail.com");
			
//			start the transaction
					session.beginTransaction();
			
//			save the student object
				System.out.println("saving the student");
				System.out.println(tempStudent);
			session.save(tempStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			
			
//			new code for read
			
//			find out student's primary key
			System.out.println("the primary key : "+tempStudent.getId());
			
//			now get a new session and start a new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve the student based on the id : primary key
			System.out.println("getting student with id:"+tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete:  "+myStudent);
			
//			commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
			
		}
											

	}

}
