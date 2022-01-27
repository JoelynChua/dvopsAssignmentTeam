
public class Listing {
	 public Listing(String listingId, String listingName, String listingPrice, String listingCountry,
			String listingRemarks, String listingImage, String userId) {
		super();
		this.listingId = listingId;
		this.listingName = listingName;
		this.listingPrice = listingPrice;
		this.listingCountry = listingCountry;
		this.listingRemarks = listingRemarks;
		this.listingImage = listingImage;
		this.userId = userId;
	}
	protected String listingId;
	 protected String listingName;
	 protected String listingPrice;
	 protected String listingCountry;
	 protected String listingRemarks;
	 protected String listingImage;
	 protected String userId;
	public String getListingId() {
		return listingId;
	}
	public void setListingId(String listingId) {
		this.listingId = listingId;
	}
	public String getListingName() {
		return listingName;
	}
	public void setListingName(String listingName) {
		this.listingName = listingName;
	}
	public String getListingPrice() {
		return listingPrice;
	}
	public void setListingPrice(String listingPrice) {
		this.listingPrice = listingPrice;
	}
	public String getListingCountry() {
		return listingCountry;
	}
	public void setListingCountry(String listingCountry) {
		this.listingCountry = listingCountry;
	}
	public String getListingRemarks() {
		return listingRemarks;
	}
	public void setListingRemarks(String listingRemarks) {
		this.listingRemarks = listingRemarks;
	}
	public String getListingImage() {
		return listingImage;
	}
	public void setListingImage(String listingImage) {
		this.listingImage = listingImage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
