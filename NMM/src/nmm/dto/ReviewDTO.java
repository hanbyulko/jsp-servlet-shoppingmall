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
   
   public ReviewDTO(int reviewNo, UserDTO userDTO, ProductDTO productDTO, String reviewTitle, String reviewContent,
         String reviewStar, String reviewDate) {
      super();
      this.reviewNo = reviewNo;
      this.userDTO = userDTO;
      this.productDTO = productDTO;
      this.reviewTitle = reviewTitle;
      this.reviewContent = reviewContent;
      this.reviewStar = reviewStar;
      this.reviewDate = reviewDate;
   }

   
   public ReviewDTO(ProductDTO productDTO, String reviewTitle, String reviewContent, String reviewStar,
         String reviewDate) {
      super();
      this.productDTO = productDTO;
      this.reviewTitle = reviewTitle;
      this.reviewContent = reviewContent;
      this.reviewStar = reviewStar;
      this.reviewDate = reviewDate;
   }
   

   public ReviewDTO( ProductDTO productDTO, int reviewNo, String reviewTitle, String reviewContent, String reviewStar,
         String reviewDate) {
      super();
      this.reviewNo = reviewNo;
      this.productDTO = productDTO;
      this.reviewTitle = reviewTitle;
      this.reviewContent = reviewContent;
      this.reviewStar = reviewStar;
      this.reviewDate = reviewDate;
   }


   public ReviewDTO(String userId, int reviewNo,  String reviewTitle, String reviewContent,
         String reviewStar, String reviewDate) {
      super();
      this.userId = this.userDTO.getUserId();
      this.reviewNo = reviewNo;
      this.reviewTitle = reviewTitle;
      this.reviewContent = reviewContent;
      this.reviewStar = reviewStar;
      this.reviewDate = reviewDate;
   }
   
   public ReviewDTO(int reviewNo,  String reviewTitle, String reviewContent,
         String reviewStar) {
      super();
      this.reviewNo = reviewNo;
      this.reviewTitle = reviewTitle;
      this.reviewContent = reviewContent;
      this.reviewStar = reviewStar;
   }
   
   public ReviewDTO() {
      super();
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


   @Override
   public String toString() {
      return "ReviewDTO [reviewNo=" + reviewNo + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent
            + ", reviewStar=" + reviewStar + ", reviewDate=" + reviewDate + "]";
   }
}