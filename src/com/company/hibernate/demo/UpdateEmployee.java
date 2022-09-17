package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {

//		create SessionFactory
		SessionFactory factory =new Configuration()
											  .configure("hibernate.cfg.xml")
											  .addAnnotatedClass(Employee.class)
											  .buildSessionFactory();											  
		
//		create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId =1;
//			get a new session and start the trandaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("Getting Employee with id"+employeeId);
			Employee myEmployee = session.get(Employee.class,employeeId);
			myEmployee.setFirstName("karaN");
			
//			commit the transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			update the Id of the selected employee 
			session.createQuery("update Employee set first_name='karaN' where id = 1")
										.executeUpdate();
//			commit the transaction 
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();
			}
		
	}

}
