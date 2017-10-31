package assignment3.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BaseDao {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/hw2_cui_jie_fall_2017";
	final String USER = "root";
	final String PASS = "";
	Connection conn = null;
	PreparedStatement pstmt = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
