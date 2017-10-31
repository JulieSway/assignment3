package assignment3.jdbc.model;

public class ImageWidget extends Widget{
	private String src;

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public ImageWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type, String src) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
		this.src = src;
	}

	public ImageWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
	}
	

}
