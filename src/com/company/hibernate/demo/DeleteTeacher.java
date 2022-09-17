package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Teacher;

public class DeleteTeacher {
	
	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Teacher.class)
											.buildSessionFactory();
		
//		create session object
		Session session = factory.getCurrentSession();
		
		
		try {
			
//			get the session and start the transaction
			session= factory.getCurrentSession();
			session.beginTransaction();
			
//			create the querry 
			session.createQuery("Delete from Teacher where id = 4")
			.executeUpdate();
			
//			commit the transaction
			session.getTransaction().commit();
			
			
			
		} finally {
			factory.close();
		}
	}

}
