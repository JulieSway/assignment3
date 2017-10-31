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


public class PageDao extends BaseDao {
	final String CREATE_PAGE_FOR_WEBSITE = 
			"INSERT INTO Page (title,description,created,updated,views,website) VALUES (?,?,current_date(),current_date(),?,?)";
	final String FIND_ALL_PAGES = "SELECT * FROM Page";
	final String UPDATE_PAGE = "UPDATE Page SET id=?, title =?, description=?, created=?, updated=? ,views=? WHERE id=?";
	final String DELETE_PAGE = "DELETE FROM Page WHERE id=?";
	final String FIND_PAGES_FOR_WEBSITE = "SELECT * FROM Page p WHERE p.website=?";
	final String FIND_PAGE_BY_ID =
			"SELECT * FROM Page p WHERE p.id = ?";
	
	final String FIND_PAGE_BY_NAME =
			"SELECT * FROM Page p WHERE p.title = ?";

	
	
	
	public Page findPageByName(String pageName) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_PAGE_BY_NAME);
		statement.setString(1, pageName);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int views = result.getInt("views");
			Page page = new Page(id, title, description,created,updated,views);
			pages.add(page);
		}
		statement.close();
		connection.close();
		return pages.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return pages.get(0);
	}
	
	
	
	
	
	public int deletePage(int pageId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(DELETE_PAGE);
			statement.setInt(1, pageId);
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
	
	
	
	
	public int updatePage(int pageId, Page page) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(UPDATE_PAGE);
		statement.setInt(1, page.getId());
		statement.setString(2, page.getTitle());
		statement.setString(3, page.getDescription());
		statement.setDate(4, page.getCreated());
		statement.setDate(5, page.getUpdated());
		statement.setInt(6, page.getViews());
		statement.setInt(7, pageId);
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
	
	
	
	public Page findPageById(int pageId) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_PAGE_BY_ID);
		statement.setInt(1, pageId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int views = result.getInt("views");
			Page page = new Page(id, title, description,created,updated,views);
			pages.add(page);
		}
		statement.close();
		connection.close();
		return pages.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return pages.get(0);
	}
	
	
	
	
	
	
	
	
	public ArrayList<Page> findPagesForWebsite(int websiteId) {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_PAGES_FOR_WEBSITE);
		statement.setInt(1, websiteId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int views = result.getInt("views");
			Page page = new Page(id, title, description,created,updated,views);
			pages.add(page);
		}
		statement.close();
		connection.close();
		return pages;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return pages;
	}
	
	
	
	
	
	
	
	
	public ArrayList<Page> findAllPages() {
		ArrayList<Page> pages = new ArrayList<Page>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_ALL_PAGES);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("description");
			Date created = result.getDate("created");
			Date updated = result.getDate("updated");
			int views = result.getInt("views");
			Page page = new Page(id, title, description,created,updated,views);
			pages.add(page);
		}
		statement.close();
		connection.close();
		return pages;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return pages;
	}
	
	
	
	public int createPageForWebsite(int websiteId, Page page) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		WebsiteDao wdao = WebsiteDao.getInstance();
		Website web = wdao.findWebsiteById(websiteId);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(CREATE_PAGE_FOR_WEBSITE);
		statement.setString(1, page.getTitle());
		statement.setString(2, page.getDescription());
		statement.setInt(3, page.getViews());
		statement.setInt(4, web.getId());
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
	
	private static PageDao instance;

	private PageDao() {}
	public static PageDao getInstance() {
		if(instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		
		WebsiteDao wdao = WebsiteDao.getInstance();
		PageDao pdao = PageDao.getInstance();
//		Website website = wdao.findWebsiteByName("CNET");
//		Page hm = new Page(1,"Home", "Landing page",null,null,123434);
//		pdao.createPageForWebsite(website.getId(),hm);
//		Website website1 = wdao.findWebsiteByName("Gizmodo");
//		Page hm1 = new Page(1,"About", "Website description",null,null,234545);
//		pdao.createPageForWebsite(website1.getId(),hm1);
//		Website website2 = wdao.findWebsiteByName("Wikipedia");
//		Page hm2 = new Page(2,"Contact", "Addresses, phones, and contact info",null,null,345656);
//		pdao.createPageForWebsite(website2.getId(),hm2);
//		Website website3 = wdao.findWebsiteByName("CNN");
//		Page hm3 = new Page(2,"Preferences", "Where users can configure their preferences",null,null,456776);
//		pdao.createPageForWebsite(website3.getId(),hm3);
//		Website website4 = wdao.findWebsiteByName("CNET");
//		Page hm4 = new Page(1,"Profile", "Users can configure their personal information",null,null,567878);
//		pdao.createPageForWebsite(website4.getId(),hm4);

//		

//		Page newHome = new Page(1,"newHome", "Landing page new",null,null,400000);
//		pdao.updatePage(7, newHome);
		ArrayList<Page> pages = pdao.findAllPages();
		System.out.println(pages);
		Website web6 = wdao.findWebsiteByName("CNN");
		ArrayList<Page> pagesd = pdao.findPagesForWebsite(web6.getId());
		System.out.println(pagesd);
		Page page = pdao.findPageById(pdao.findAllPages().get(2).getId());
		System.out.println(page);
//		pdao.deletePage(1);
		
	}

}
