package assignment3.jdbc.model;

public class YouTubeWidget extends Widget{
	private String url;
	private Boolean shareble;
	private Boolean expandable;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Boolean getShareble() {
		return shareble;
	}
	public void setShareble(Boolean shareble) {
		this.shareble = shareble;
	}
	public Boolean getExpandable() {
		return expandable;
	}
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	public YouTubeWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type, String url2, Boolean shareble, Boolean expandable) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
		url = url2;
		this.shareble = shareble;
		this.expandable = expandable;
	}
	public YouTubeWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
	}
	
	
	
}
