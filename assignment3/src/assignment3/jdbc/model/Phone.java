package assignment3.jdbc.model;

public class Phone {
	private int id;
	public Phone(String phone, Boolean primary) {
		super();
		this.phone = phone;
		this.primary = primary;
	}
	public Phone() {
		super();
	}
	public Phone(int id, String phone, Boolean primary) {
		super();
		this.id = id;
		this.phone = phone;
		this.primary = primary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getPrimary() {
		return primary;
	}
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}
	private String phone;
	private Boolean primary;
}
