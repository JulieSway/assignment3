package assignment3.jdbc.model;

public class HtmlWidget extends Widget{
	private String html;

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public HtmlWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type, String html) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
		this.html = html;
	}

	public HtmlWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
	}
	
}

