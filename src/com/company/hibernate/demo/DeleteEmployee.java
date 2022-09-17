package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration()	
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Employee.class)
												.buildSessionFactory();
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			
//			get a new session and start the transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
				
//			Delete the employee 
			session.createQuery("Delete from Employee where id = 2")
			.executeUpdate();
			
//			commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
				factory.close();
				}
	}

}
