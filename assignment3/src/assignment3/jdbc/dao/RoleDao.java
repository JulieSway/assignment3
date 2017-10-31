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
import assignment3.jdbc.model.Role;
import assignment3.jdbc.model.Website;



public class RoleDao extends BaseDao{
	
 final String ASSIGN_WEBSITEROLE = "INSERT INTO WebsiteRole (web_role,web_developer,web) VALUES (?,?,?)";
 final String ASSIGN_PAGEROLE = "INSERT INTO PageRole (role,developer,page) VALUES (?,?,?)";
	
 
 
 
 
 public int assignPageRole(int developerId, int pageId, int roleId) {
	    int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		 PageDao pdao = PageDao.getInstance();
		 DeveloperDao ddao = DeveloperDao.getInstance();
		 Page page = pdao.findPageById(pageId);
		 Developer dev = ddao.findDeveloperById(developerId);
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(ASSIGN_PAGEROLE);
			Role[] roles = Role.values(); 
			ArrayList<String> temproles = new ArrayList<String>();
			 for(Role role : roles) {
				 temproles.add(role.name());
			 }
			statement.setString(1, temproles.get(roleId));
			statement.setInt(2, dev.getId());
			statement.setInt(3, page.getId());
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
 
 
 
 
 
 
 
 
 
 public int assignWebsiteRole(int developerId, int websiteId, int roleId) {
	    int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		 WebsiteDao wdao = WebsiteDao.getInstance();
		 DeveloperDao ddao = DeveloperDao.getInstance();
		 Website website = wdao.findWebsiteById(websiteId);
		 Developer dev = ddao.findDeveloperById(developerId);
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(ASSIGN_WEBSITEROLE);
			Role[] roles = Role.values(); 
			ArrayList<String> temproles = new ArrayList<String>();
			 for(Role role : roles) {
				 temproles.add(role.name());
			 }
			statement.setString(1, temproles.get(roleId));
			statement.setInt(2, dev.getId());
			statement.setInt(3, website.getId());
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




private static RoleDao instance;

	private RoleDao() {}
	public static RoleDao getInstance() {
		if(instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
 
 
 public static void main(String[] args) {
	 WebsiteDao wdao = WebsiteDao.getInstance();
	 RoleDao rdao = RoleDao.getInstance();
	 PageDao pdao = PageDao.getInstance();
	 DeveloperDao ddao = DeveloperDao.getInstance();
	 Developer did1 = ddao.findDeveloperByUsername("alice");
//	 Website wid1 = wdao.findWebsiteByName("Facebook");
//	 rdao.assignWebsiteRole(did1.getId(), wid1.getId(), 1);
	 
	 Page page1 = pdao.findPageByName("About");
	 rdao.assignPageRole(did1.getId(), page1.getId(), 3);
	 
}
}
