package assignment3.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import assignment3.jdbc.model.Developer;
import assignment3.jdbc.model.Page;
import assignment3.jdbc.model.Website;


public class WebsiteDao extends BaseDao {
	final String CREATE_WEBSITE_FOR_DEVELOPER = 
			"INSERT INTO Website (name,description,created,updated,visits,developer) VALUES (?,?,current_date(),current_date(),?,?)";
	final String FIND_ALL_WEBSITES = "SELECT * FROM Website";
	final String FIND_WEBSITE_ID = "SELECT * FROM Website WHERE id=?";
	final String UPDATE_WEBSITE = "UPDATE Website SET id=?,name =?, description=?, created=?, updated=? ,visits=? WHERE id=?";
	final String DELETE_WEBSITE = "DELETE FROM Website WHERE id=?";
	final String FIND_WEBSITES_FOR_DEVELOPER = "SELECT * FROM Website w WHERE w.developer=?";
	final String FIND_WEBSITE_BY_ID =
			"SELECT * FROM Website w WHERE w.id = ?";
	final String FIND_WEBSITE_BY_NAME =
			"SELECT * FROM Website w WHERE w.name = ?";
	
	final String FIND_DEVELOPER = "SELECT w.developer as did FROM Website w WHERE w.id = ?";

	
	
	public Website findWebsiteByName(String websiteName) {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_WEBSITE_BY_NAME);
		statement.setString(1, websiteName);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int visits = result.getInt("visits");
			Website website = new Website(id, name, description,created,updated,visits);
			websites.add(website);
		}
		statement.close();
		connection.close();
		return websites.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return websites.get(0);
	}
	
	
	
	
	
	
	
	public int deleteWebsite(int websiteId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(DELETE_WEBSITE);
			statement.setInt(1, websiteId);
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
	
	
	
	
	public int updateWebsite(int websiteId, Website website) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(UPDATE_WEBSITE);
		statement.setInt(1, website.getId());
		statement.setString(2, website.getName());
		statement.setString(3, website.getDescription());
		statement.setDate(4, website.getCreated());
		statement.setDate(5, website.getUpdated());
		statement.setInt(6, website.getVisits());
		statement.setInt(7, websiteId);
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
	
	
	
	public Website findWebsiteById(int websiteId) {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_WEBSITE_BY_ID);
		statement.setInt(1, websiteId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int visits = result.getInt("visits");
			Website website = new Website(id, name, description,created,updated,visits);
			websites.add(website);
		}
		statement.close();
		connection.close();
		return websites.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return websites.get(0);
	}
	
	
	
	
	
	
	
	
	public ArrayList<Website> findWebsitesForDeveloper(int developerId) {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_WEBSITES_FOR_DEVELOPER);
		statement.setInt(1, developerId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int visits = result.getInt("visits");
			Website website = new Website(id, name, description,created,updated,visits);
			websites.add(website);
		}
		statement.close();
		connection.close();
		return websites;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return websites;
	}
	
	
	
	
	
	
	
	
	public ArrayList<Website> findAllWebsites() {
		ArrayList<Website> websites = new ArrayList<Website>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_ALL_WEBSITES);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int visits = result.getInt("visits");
			Website website = new Website(id, name, description,created,updated,visits);
			websites.add(website);
		}
		statement.close();
		connection.close();
		return websites;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return websites;
	}
	
	
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		DeveloperDao ddao = DeveloperDao.getInstance();
		Developer dev = ddao.findDeveloperById(developerId);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(CREATE_WEBSITE_FOR_DEVELOPER);
		statement.setString(1, website.getName());
		statement.setString(2, website.getDescription());
		statement.setInt(3, website.getVisits());
		statement.setInt(4, dev.getId());
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
	
	private static WebsiteDao instance;

	private WebsiteDao() {}
	public static WebsiteDao getInstance() {
		if(instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		DeveloperDao ddao = DeveloperDao.getInstance();
		WebsiteDao wdao = WebsiteDao.getInstance();
//		Developer dev = ddao.findDeveloperByUsername("alice");
//		Website fb = new Website("Facebook", "an online social media and social networking service",null,null,1234234);
//		wdao.createWebsiteForDeveloper(dev.getId(),fb);
//		Developer dev1 = ddao.findDeveloperByUsername("bob");
//		Website tw = new Website("Twitter", "an online news and social networking service",null,null,1234234);
//		wdao.createWebsiteForDeveloper(dev1.getId(),tw);
//		Developer dev2 = ddao.findDeveloperByUsername("charlie");
//		Website wi = new Website("Wikipedia", "a free online encyclopedia",null,null,3456654);
//		wdao.createWebsiteForDeveloper(dev2.getId(),wi);
//		Developer dev3 = ddao.findDeveloperByUsername("alice");
//		Website cnn = new Website("CNN", "an American basic cable and satellite television news channel",null,null,6543345);
//		wdao.createWebsiteForDeveloper(dev3.getId(),cnn);
//		Developer dev4 = ddao.findDeveloperByUsername("bob");
//		Website ce = new Website("CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",null,null,5433455);
//		wdao.createWebsiteForDeveloper(dev4.getId(),ce);
//		Developer dev5 = ddao.findDeveloperByUsername("charlie");
//		Website gi = new Website("Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics",null,null,4322345);
//		wdao.createWebsiteForDeveloper(dev5.getId(),gi);
//		
//		System.out.println(ddao.findDeveloperById(123));
		Website newTwitter = new Website(2,"Twitter", "Our source of truth",null,null,1234234);
		wdao.updateWebsite(23, newTwitter);
		ArrayList<Website> websites = wdao.findAllWebsites();
		System.out.println(websites);
		Developer dev6 = ddao.findDeveloperByUsername("alice");
		ArrayList<Website> websitesd = wdao.findWebsitesForDeveloper(dev6.getId());
		System.out.println(websitesd);
		Website website = wdao.findWebsiteById(wdao.findAllWebsites().get(1).getId());
		System.out.println(website);
//		wdao.deleteWebsite(2);
		
	}

}
