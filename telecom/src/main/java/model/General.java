package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class General {

	public static void main(String[] args) {
		Abonent abonent_01 = new Abonent(0, "abonent_01", 1, 0, 0, 0);
		Abonent abonent_02 = new Abonent(0, "abonent_02", 2, 0, 0, 0);

		Date currentdate = new Date();
//
		Payment payment_01 = new Payment(1001, abonent_01, 13.12f, currentdate);
		Payment payment_02 = new Payment(1001, abonent_02, 1248.23f, currentdate);
		Payment payment_03 = new Payment(1001, abonent_02, 734.01f, currentdate);

		//for git
		Connection myConnection = null;
		final String login = "root";
		final String password = "kiev2014";
		String databaseURL = "jdbc:mysql://localhost/telecom?" + "user=" + login + "&password=" + password
				+ "&useSSL=false";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			myConnection = DriverManager.getConnection(databaseURL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*Dao payment_Dao_01 = new Dao(myConnection);

		Payment payment_1001 = payment_Dao_01.get(1001);
		Payment payment_1002 = payment_Dao_01.get(1002);
		Payment payment_1003 = payment_Dao_01.get(1003);

		System.out.println("payment 1001= " + payment_1001 + "\npayment 1002= " + payment_1002 + "\npayment 1003= "
				+ payment_1003);*/

	}

}
