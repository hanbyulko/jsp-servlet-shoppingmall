package nmm.dto;

public class ReviewDTO {
   private int reviewNo;
   private UserDTO userDTO;
   private ProductDTO productDTO;
   private String reviewTitle;
   private String reviewContent;
   private String reviewStar;
   private String reviewDate;
   private String userId;
   private int pageCnt;
public ReviewDTO(int reviewNo, UserDTO userDTO, ProductDTO productDTO, String reviewTitle, String reviewContent,
		String reviewStar, String reviewDate, String userId, int pageCnt) {
	super();
	this.reviewNo = reviewNo;
	this.userDTO = userDTO;
	this.productDTO = productDTO;
	this.reviewTitle = reviewTitle;
	this.reviewContent = reviewContent;
	this.reviewStar = reviewStar;
	this.reviewDate = reviewDate;
	this.userId = userId;
	this.pageCnt = pageCnt;
}
public ReviewDTO(int reviewNo, String reviewTitle, String reviewContent, String reviewStar) {
	this.reviewNo = reviewNo;
	this.reviewTitle = reviewTitle;
	this.reviewContent = reviewContent;
	this.reviewStar = reviewStar;
}
public ReviewDTO() {
}
public int getReviewNo() {
	return reviewNo;
}
public void setReviewNo(int reviewNo) {
	this.reviewNo = reviewNo;
}
public UserDTO getUserDTO() {
	return userDTO;
}
public void setUserDTO(UserDTO userDTO) {
	this.userDTO = userDTO;
}
public ProductDTO getProductDTO() {
	return productDTO;
}
public void setProductDTO(ProductDTO productDTO) {
	this.productDTO = productDTO;
}
public String getReviewTitle() {
	return reviewTitle;
}
public void setReviewTitle(String reviewTitle) {
	this.reviewTitle = reviewTitle;
}
public String getReviewContent() {
	return reviewContent;
}
public void setReviewContent(String reviewContent) {
	this.reviewContent = reviewContent;
}
public String getReviewStar() {
	return reviewStar;
}
public void setReviewStar(String reviewStar) {
	this.reviewStar = reviewStar;
}
public String getReviewDate() {
	return reviewDate;
}
public void setReviewDate(String reviewDate) {
	this.reviewDate = reviewDate;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public int getPageCnt() {
	return pageCnt;
}
public void setPageCnt(int pageCnt) {
	this.pageCnt = pageCnt;
}

   
}