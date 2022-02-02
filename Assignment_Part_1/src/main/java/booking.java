
public class booking {
	protected String name;
	
	public booking(String name, String card, String cvCode, String date, String phone, String location) {
		super();
		this.name = name;
		this.card = card;
		this.cvCode = cvCode;
		this.date = date;
		this.phone = phone;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getCvCode() {
		return cvCode;
	}
	public void setCvCode(String cvCode) {
		this.cvCode = cvCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	 protected String card;
	 protected String cvCode;
	 protected String date;
	 protected String phone;
	 protected String location;
}
