package assignment3.jdbc.model;

public class Widget {
private int id;
public Widget(String name, int width, int height, String cssClass, String cssStyle, String text, int order, String url,
		String type) {
	super();
	this.name = name;
	this.width = width;
	this.height = height;
	this.cssClass = cssClass;
	this.cssStyle = cssStyle;
	this.text = text;
	this.order = order;
	this.url = url;
	this.type = type;
}
public Widget() {
	super();
}
public Widget(int id, String name, int width, int height, String text, int order,
		String url, String type) {
	super();
	this.id = id;
	this.name = name;
	this.width = width;
	this.height = height;
	this.text = text;
	this.order = order;
	this.url = url;
	this.type = type;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public String getCssClass() {
	return cssClass;
}
public void setCssClass(String cssClass) {
	this.cssClass = cssClass;
}
public String getCssStyle() {
	return cssStyle;
}
public void setCssStyle(String cssStyle) {
	this.cssStyle = cssStyle;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getOrder() {
	return order;
}
public void setOrder(int order) {
	this.order = order;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
private String name;
private int width;
private int height;
private String cssClass;
private String cssStyle;
private String text;
private int order;
private String url;
private String type;

public  String toString() {
	return name + "-" + width + "-" + height + "-" + text+ "-" + order  + url+ "-" + type;
}
}
