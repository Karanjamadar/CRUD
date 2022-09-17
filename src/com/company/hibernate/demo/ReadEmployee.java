package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {

//		create sessionfactory
		
		SessionFactory factory = new Configuration()
											  .configure("hibernate.cfg.xml")
											  .addAnnotatedClass(Employee.class)
											  .buildSessionFactory();
		
//		create session
		
		Session session = factory.getCurrentSession();
		
		try {
//			creating the employee object
			System.out.println("Creating a new Employee object");
			Employee tempEmployee = new Employee("Rick","Grimes","Microsoft");
			
//			Start the transaction
			session.beginTransaction();
			
//			save the employee object 
			session.save(tempEmployee);
		
			
//			commit the transaction
			session.getTransaction().commit();
	
//			new code for reading the records
//			find out employee's primary key
			
			System.out.println("The primary key is "+tempEmployee.getId());
			
//		   get a session and start the transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			retrieve the student based on the primary key
			System.out.println("Getting Employee with id"+tempEmployee.getId());
			Employee myEmployee = session.get(Employee.class,tempEmployee.getId());
			System.out.println("All the details of the Employees"+myEmployee);
			
//			commit the transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
			
		}
		
	}

}
