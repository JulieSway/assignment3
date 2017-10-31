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
import assignment3.jdbc.model.Widget;


public class WidgetDao extends BaseDao {
	final String CREATE_WIDGET_FOR_PAGE = 
			"INSERT INTO Widget (name,width,height,text,oder,vedioURL,imgSrc,html,type,page) VALUES (?,?,?,?,?,?,?,?,?,?)";
	final String FIND_ALL_WIDGETS = "SELECT * FROM Widget";
	final String UPDATE_WIDGET = "UPDATE Widget SET id=?,name =?,width=?,height=?,text=?,oder=?,vedioURL=?,imgSrc=?,html=?,type=? WHERE id=?";
	final String DELETE_WIDGET = "DELETE FROM WIDGET WHERE id=?";
	final String FIND_WIDGETS_FOR_PAGE = "SELECT * FROM Widget wi WHERE wi.page=?";
	final String FIND_WIDGET_BY_ID =
			"SELECT * FROM Widget wi WHERE wi.id = ?";
	
	

	
	
	public int deleteWidget(int widgetId) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(DELETE_WIDGET);
			statement.setInt(1, widgetId);
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
	
	
	
	
	public int updateWidget(int widgetId, Widget widget) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(UPDATE_WIDGET);
		statement.setInt(1, widget.getId());
		statement.setString(2, widget.getName());
		statement.setInt(3, widget.getWidth());
		statement.setInt(4, widget.getHeight());
		statement.setString(5, widget.getText());
		statement.setInt(6, widget.getOrder());
		if(widget.getUrl()!=null && widget.getType()=="youtube") {
			statement.setString(7, widget.getUrl());
			statement.setString(8, null);
			statement.setString(9, null);
		} else if(widget.getUrl()!=null && widget.getType()=="image") {
			statement.setString(7, null);
			statement.setString(8, widget.getUrl());
			statement.setString(9, null);

		} else if(widget.getUrl()!=null && widget.getType()=="html") {
			statement.setString(7, null);
			statement.setString(8, null);
			statement.setString(9, widget.getUrl());

		}
		else{
			statement.setString(7, null);
			statement.setString(8, null);
			statement.setString(9, null);

		}
		statement.setString(10, widget.getType());
		statement.setInt(11, widgetId);
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
	
	
	
	public Widget findWidgetById(int widgetId) {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_WIDGET_BY_ID);
		statement.setInt(1, widgetId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			int width = result.getInt("width");
			int height = result.getInt("height");
			String text = result.getString("text");
			int order = result.getInt("oder");
			String url = "";
			if(result.getString("vedioURL")!=null) {
				url = result.getString("vedioURL");
			} else if(result.getString("imgSrc")!=null) {
				url = result.getString("imgSrc");
			} else  {
				url = result.getString("html");
			}
			String type = result.getString("type");
			
			
			Widget widget = new Widget(id, name, width,height,text,order,url,type);
			widgets.add(widget);
		}
		statement.close();
		connection.close();
		return widgets.get(0);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return widgets.get(0);
	}
	
	
	
	
	
	
	
	
	public ArrayList<Widget> findWidgetsForPage(int pageId) {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_WIDGETS_FOR_PAGE);
		statement.setInt(1, pageId);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			int width = result.getInt("width");
			int height = result.getInt("height");
			String text = result.getString("text");
			int order = result.getInt("oder");
			String url = "";
			if(result.getString("vedioURL")!=null) {
				url = result.getString("vedioURL");
			} else if(result.getString("imgSrc")!=null) {
				url = result.getString("imgSrc");
			} else  {
				url = result.getString("html");
			}
			String type = result.getString("type");
			
			
			Widget widget = new Widget(id, name, width,height,text,order,url,type);
			widgets.add(widget);
		}
		statement.close();
		connection.close();
		return widgets;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return widgets;
	}
	
	
	
	
	
	
	
	
	public ArrayList<Widget> findAllWidgets() {
		ArrayList<Widget> widgets = new ArrayList<Widget>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(FIND_ALL_WIDGETS);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			int width = result.getInt("width");
			int height = result.getInt("height");
			String text = result.getString("text");
			int order = result.getInt("oder");
			String url = "";
			if(result.getString("vedioURL")!=null) {
				url = result.getString("vedioURL");
			} else if(result.getString("imgSrc")!=null) {
				url = result.getString("imgSrc");
			} else  {
				url = result.getString("html");
			}
			String type = result.getString("type");
			
			
			Widget widget = new Widget(id, name, width,height,text,order,url,type);
			widgets.add(widget);
		}
		statement.close();
		connection.close();
		return widgets;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return widgets;
	}
	
	
	
	public int createWidgetForPage(int pageId, Widget widget) {
		int result = -1;
		Connection connection = null;
		PreparedStatement statement = null;
		try {
		Class.forName(JDBC_DRIVER);
		PageDao pdao = PageDao.getInstance();
		Page page = pdao.findPageById(pageId);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.prepareStatement(CREATE_WIDGET_FOR_PAGE);
		statement.setString(1, widget.getName());
		statement.setInt(2, widget.getWidth());
		statement.setInt(3, widget.getHeight());
		statement.setString(4, widget.getText());
		statement.setInt(5, widget.getOrder());
		if(widget.getType() == "youtube") {
		 statement.setString(6, widget.getUrl());
		 statement.setString(7, null);
		 statement.setString(8, null);
		} else if(widget.getType() == "image") {
		 statement.setString(6, null);
		 statement.setString(7, widget.getUrl());
		 statement.setString(8, null);
		} else if(widget.getType() == "html") {
			 statement.setString(6, null);
			 statement.setString(7, null);
			 statement.setString(8, widget.getUrl());
			} else {
				 statement.setString(6, null);
				 statement.setString(7, null);
				 statement.setString(8, null);
			}
		statement.setString(9, widget.getType());
		statement.setInt(10, page.getId());
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
	
	private static WidgetDao instance;

	private WidgetDao() {}
	public static WidgetDao getInstance() {
		if(instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		
		PageDao pdao = PageDao.getInstance();
		WidgetDao wdao = WidgetDao.getInstance();
//		Page page = pdao.findPageByName("Home");
//		Widget wi = new Widget(1,"head123",0,0,"Welcome",0,"","heading");
//		wdao.createWidgetForPage(page.getId(),wi);
//		Page page1 = pdao.findPageByName("About");
//		Widget wi1 = new Widget(1,"post234",0,0,"<p>Lorem</p>",0,"","html");
//		wdao.createWidgetForPage(page1.getId(),wi1);
//		Page page2 = pdao.findPageByName("Contact");
//		Widget wi2 = new Widget(1,"head345",0,0,"Hi",1,"","heading");
//		wdao.createWidgetForPage(page2.getId(),wi2);
//		Page page3 = pdao.findPageByName("Contact");
//		Widget wi3 = new Widget(1,"intro456",0,0,"<h1>Hi</h1>",2,"","html");
//		wdao.createWidgetForPage(page3.getId(),wi3);
//		Page page4 = pdao.findPageByName("Contact");
//		Widget wi4 = new Widget(1,"image345",50,100,"",3,"/img/567.png","image");
//		wdao.createWidgetForPage(page4.getId(),wi4);
//		Page page5 = pdao.findPageByName("Preferences");
//		Widget wi5 = new Widget(1,"video456",400,300,"",0,"https://youtu.be/h67VX51QXiQ","youtube");
//		wdao.createWidgetForPage(page5.getId(),wi5);
//		

//		

//		Widget newhead= new Widget(1,"newHead123", 1,2,"new",1,"","heading");
//		wdao.updateWidget(1, newhead);
		ArrayList<Widget> widgets = wdao.findAllWidgets();
		System.out.println(widgets);
		Page pa = pdao.findPageByName("Home");
		ArrayList<Widget> widgetsd = wdao.findWidgetsForPage(pa.getId());
		System.out.println(widgetsd);
		Widget widget = wdao.findWidgetById(wdao.findAllWidgets().get(2).getId());
		System.out.println(widget);
		wdao.deleteWidget(1);
//		
	}

}
