package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
//		create session factory
		SessionFactory  factory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Employee.class)
												.buildSessionFactory();	
//		create session
		Session session =factory.getCurrentSession();
		
		try {
//			create Employee object
			
			System.out.println("Creating a new Employee object");			
			Employee tempEmployee = new Employee("Karan","Jamadar","Google");
			
//			start the transaction
			session.beginTransaction();
			
//			save the Employee object 
			System.out.println("saving the Employee");
			session.save(tempEmployee);
			
//			commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done ! ....");
			
			
			
		} finally {
			factory.close();

		}
	}
}
