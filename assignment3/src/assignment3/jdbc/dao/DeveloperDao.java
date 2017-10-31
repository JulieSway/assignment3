package assignment3.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import assignment3.jdbc.model.Developer;
import assignment3.jdbc.model.Website;





public class DeveloperDao extends BaseDao {
	
	final String CREATE_PERSON = 
 "INSERT INTO Person (firstName,lastName,userName,password,email,dob) VALUES (?,?,?,?,?,?)";
	final String CREATE_DEVELOPER = 
"INSERT INTO Developer (person,developerKey) VALUES (?,?)";
	final String FIND_PERSON_ID = 
			"SELECT * FROM PERSON WHERE username=?";
	final String FIND_ALL_DEVELOPERS =
			"SELECT * FROM Developer d JOIN Person p on d.person = p.id";
	final String FIND_DEVELOPER_BY_ID =
			"SELECT * FROM Developer d JOIN Person p on d.person = p.id AND p.id = ?";
	final String FIND_DEVELOPER_BY_Username =
			"SELECT * FROM Developer d JOIN Person p WHERE d.person = p.id AND p.userName = ?";
	final String FIND_DEVELOPER_BY_Credentials =
			"SELECT * FROM Developer d JOIN Person p WHERE d.person = p.id AND p.userName = ? AND p.password = ?";
	
	final String UPDATE_PERSON =
			"UPDATE Person SET id =?, firstName=?, lastName=?, userName=?, password=?,email=?,dob=? WHERE id=?";
	
	final String UPDATE_DEVELOPER =
			"UPDATE DEVELOPER SET person =?, developerKey=? WHERE person=?";
	final String DELETE_PERSON =
			"DELETE FROM Person WHERE id=?";
	
	
	
	
	
	
	public int deleteDeveloper(int developerId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(DELETE_PERSON);
			statement.setInt(1, developerId);
			result = statement.executeUpdate();
			statement.close();
			connection.close();
			return result;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
			
	}
	
	
	
	
	
	
	
	
	public int updateDeveloper(int developerId, Developer developer) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(UPDATE_PERSON);
		statement.setInt(1, developer.getId());
		statement.setString(2, developer.getFirstName());
		statement.setString(3, developer.getLastName());
		statement.setString(4, developer.getUsername());
		statement.setString(5, developer.getPassword());
		statement.setString(6, developer.getEmail());
		statement.setDate(7, developer.getDob());
		statement.setInt(8, developerId);
		result = statement.executeUpdate();
		statement.close();
		statement = connection.prepareStatement(FIND_PERSON_ID);
		statement.setString(1, developer.getUsername());
		ResultSet persons = statement.executeQuery();
		int personid = 0;
		while(persons.next()) {
			personid = persons.getInt("id");
		}
		statement.close();
		statement = connection.prepareStatement(UPDATE_DEVELOPER);
		statement.setInt(1, personid);
		statement.setString(2, developer.getDeveloperKey());
		statement.setInt(3, developerId);
		result = statement.executeUpdate();
		statement.close();
		connection.close();
		return result;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return result;
	}
	
	
	
	public Developer findDeveloperByCredentials(String username, String password) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_DEVELOPER_BY_Credentials);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String first = result.getString("firstName");
			String last = result.getString("lastName");
			String user = result.getString("userName");
			String pass = result.getString("password");
			String email = result.getString("email");
			Date dob = result.getDate("dob");
			String key = result.getString("developerKey");
			Developer dev = new Developer(id, first,last, user, pass, email,dob, key);
			developers.add(dev);
		}
		statement.close();
		connection.close();
		return developers.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return developers.get(0);
	}
	
	
	
	
	
	public Developer findDeveloperByUsername(String username) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_DEVELOPER_BY_Username);
		statement.setString(1, username);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String first = result.getString("firstName");
			String last = result.getString("lastName");
			String user = result.getString("userName");
			String pass = result.getString("password");
			String email = result.getString("email");
			Date dob = result.getDate("dob");
			String key = result.getString("developerKey");
			Developer dev = new Developer(id, first,last, user, pass, email,dob, key);
			developers.add(dev);
		}
		statement.close();
		connection.close();
		return developers.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return developers.get(0);
	}
	
	
	
	public Developer findDeveloperById(int developerId) {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_DEVELOPER_BY_ID);
		statement.setInt(1, developerId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String first = result.getString("firstName");
			String last = result.getString("lastName");
			String user = result.getString("userName");
			String pass = result.getString("password");
			String email = result.getString("email");
			Date dob = result.getDate("dob");
			String key = result.getString("developerKey");
			Developer dev = new Developer(id, first,last, user, pass, email,dob,key);
			developers.add(dev);
		}
		statement.close();
		connection.close();
		return developers.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return developers.get(0);
	}
	
	
	
	
	
	public ArrayList<Developer>  findAllDevelopers() {
		ArrayList<Developer> developers = new ArrayList<Developer>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_ALL_DEVELOPERS);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String first = result.getString("firstName");
			String last = result.getString("lastName");
			String user = result.getString("userName");
			String pass = result.getString("password");
			String email = result.getString("email");
			Date dob = result.getDate("dob");
			String key = result.getString("developerKey");
			Developer dev = new Developer(id, first,last, user, pass, email,dob, key);
			developers.add(dev);
		}
		statement.close();
		connection.close();
		return developers;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return developers;
	}
	
	
	
	
	
	
	
	public int createDeveloper(Developer developer) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(CREATE_PERSON);
		
		statement.setString(1, developer.getFirstName());
		statement.setString(2, developer.getLastName());
		statement.setString(3, developer.getUsername());
		statement.setString(4, developer.getPassword());
		statement.setString(5, developer.getEmail());
		statement.setDate(6, developer.getDob());
		result = statement.executeUpdate();
		statement.close();
		statement = connection.prepareStatement(FIND_PERSON_ID);
		statement.setString(1, developer.getUsername());
		ResultSet persons = statement.executeQuery();
		int personid = 0;
		while(persons.next()) {
			personid = persons.getInt("id");
		}
		statement.close();
		statement = connection.prepareStatement(CREATE_DEVELOPER);
		
		statement.setInt(1, personid);
		statement.setString(2, developer.getDeveloperKey());
		result = statement.executeUpdate();
		statement.close();
		connection.close();
		return result;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return result;
	}
	
	private static DeveloperDao instance;

	private DeveloperDao() {}
	public static DeveloperDao getInstance() {
		if(instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		DeveloperDao ddao = DeveloperDao.getInstance();
//		Developer  alice = 
//				new Developer(1, "Alice", "Wonder","alice","alice","alice@wonder.com",null,"4321rewq");
//		Developer  bob = 
//				new Developer(2, "Bob", "Marley","bob","bob","bob@marley.com",null,"5432trew");
//		Developer  charlie = 
//				new Developer(3, "Charles", "Garcia","charlie","charlie","chuch@garcia.com",null,"6543ytre");
//		Developer  dan = 
//				new Developer(4, "Dan", "Martin","dan","dan","dan@martin.com",null,"7654fda");
//		Developer  ed = 
//				new Developer(5, "Ed", "Karaz","ed","ed","ed@kar.com",null,"5678dfgh");
//		ddao.createDeveloper(alice);
//		ddao.createDeveloper(bob);
//		ddao.createDeveloper(charlie);
//		ddao.createDeveloper(dan);
//		ddao.createDeveloper(ed);
//		ArrayList<Developer> devs = ddao.findAllDevelopers();
//		Developer dev = ddao. findDeveloperById(24);
//		Developer dev1 = ddao. findDeveloperByUsername("alice");
//		Developer dev2 = ddao. findDeveloperByCredentials("bob","bob");
//		Developer newdev = new Developer(2, "Edie","M","ed1","ed2","e@m",null,"5678dfgh");
//		System.out.println(devs);
//		System.out.println(dev);
//		System.out.println(dev1);
//		System.out.println(dev2);
//		ddao.updateDeveloper(28, newdev);
		ddao.deleteDeveloper(2);

	}
}
