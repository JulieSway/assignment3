package assignment3.jdbc.model;

public class HeadingWidget extends Widget {
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public HeadingWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type, int size) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
		this.size = size;
	}

	public HeadingWidget(String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			String url, String type) {
		super(name, width, height, cssClass, cssStyle, text, order, url, type);
	}
	

	
}
