package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Teacher;

public class UpdateTeacher {

	public static void main(String[] args) {

//		create session factory
		SessionFactory factory = new Configuration()
												.configure("hibernate.cfg.xml")	
												.addAnnotatedClass(Teacher.class)
												.buildSessionFactory();
		
//		create session object
		Session session = factory.getCurrentSession();
		
		try {
			int teacherId = 2;
//			get the session and begin the transaction 
			session= factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("geting the Teacher with primary key "+ teacherId);
			Teacher myTeacher = session.get(Teacher.class, teacherId);
//			myTeacher.setFirstName("SakShi");
			
//			update table with querry
			session.createQuery("update Teacher set first_name = 'KaraN' where id = 1" )
			.executeUpdate();
			
//			commit the transaction
			session.getTransaction().commit();
			
			
			
		} finally {
			factory.close();
		}
	}

}
