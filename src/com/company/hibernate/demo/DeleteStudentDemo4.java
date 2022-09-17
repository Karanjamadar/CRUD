package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.company.hibernate.demo.entity.Student;

public class DeleteStudentDemo4 {

	public static void main(String[] args) {
//		Create session factory 
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
		
//		Create session
		Session session = factory.getCurrentSession();	
		
		try {
			int studentId = 1;
					
//			now get a new session and start a new transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve the student based on the id : primary key
			System.out.println("getting student with id:"+studentId);
			Student myStudent = session.get(Student.class,studentId);
			
		
//			Delete the student 
			System.out.println("Deleting from student ...");
			session.createQuery("Delete from Student where id = 8 ")
			.executeUpdate();
			
			
			
//			commit the transaction
			session.getTransaction().commit();
			
		
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
			
		}
											

	}

}
