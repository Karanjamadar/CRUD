package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Teacher;

public class CreateTeacher {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Teacher.class)
												.buildSessionFactory();
		
//		create session object
		Session session = factory.getCurrentSession();
		
		try {
//			create new teacher object
			System.out.println("creating new Teacher object");
			Teacher tempTeacher = new Teacher("karan1","jamadar1","karan.b.jamadar@gmail.com1","Computer Science2s");
			
			
//			start the transaction
			session.beginTransaction();
			
//			Saving the teacher object
			System.out.println("saving the teacher object");
			session.save(tempTeacher);

//			commit the transaction
			session.getTransaction().commit();
			
			
			
		} finally {
			factory.close();
		}
	}

}
