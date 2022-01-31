

public class Review {
	public Review(String reviewID, String userID, String rating, String review) {
		super();
		this.reviewID = reviewID;
		this.userID = userID;
		this.rating = rating;
		this.review = review;
	}
	public String getReviewID() {
		return reviewID;
	}
	public void setReviewID(String reviewID) {
		this.reviewID = reviewID;
	}
	protected String reviewID;
	protected String userID;

	public Review(String userID, String rating, String review) {
		super();
		this.userID = userID;
		this.rating = rating;
		this.review = review;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	protected String rating;
	protected String review;

}
