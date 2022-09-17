package com.company;


import java.sql.*;

public class testJdbc {

	public static void main(String[] args) {
		Connection con;
		Statement st;
		ResultSet rs;
		String querry = "insert into student values('','karan','jamadar','karan@gmail.com')";
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/karan","postgres","karan");
			System.out.println("conection created");
			st = con.createStatement();
			System.out.println("statement created");
			rs = st.executeQuery(querry);
			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			
			
		}

	}

}
