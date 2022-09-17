package com.company.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.company.hibernate.demo.entity.Teacher;

public class ReadTeacher {
	
	public static void main(String[] args) {
		
//		create sessoin factory
		SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Teacher.class)
											.buildSessionFactory();
		
//		create session object
		Session session = factory.getCurrentSession();
		
		try {
//			create teacher object
			System.out.println("creating teacher object");
			Teacher tempTeacher = new Teacher("Sakshi","ingale","sakshi@mail.com","Java");
			
//			begin the transaction
			session.beginTransaction();
//			save the teacher object
			session.save(tempTeacher);

//			get details via primary key
			System.out.println("primary key is : "+tempTeacher.getId());
			Teacher myTeacher = session.get(Teacher.class , tempTeacher.getId());
			System.out.println("All details of the teacher is : "+myTeacher);
			
//			commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
			factory.close();

		}
		
	}

}
