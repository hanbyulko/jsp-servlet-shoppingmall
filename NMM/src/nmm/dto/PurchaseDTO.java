package nmm.dto;

public class PurchaseDTO extends PageCnt{
	private int orderNo;
	private UserDTO userDTO;
	private ProductDTO productDTO;
	private int purchaseQty;
	private String purchaseDate;
	private String purchaseStatus;
	public PurchaseDTO(int orderNo, UserDTO userDTO, ProductDTO productDTO, int purchaseQty, String purchaseDate,
			String purchaseStatus) {
		super();
		this.orderNo = orderNo;
		this.userDTO = userDTO;
		this.productDTO = productDTO;
		this.purchaseQty = purchaseQty;
		this.purchaseDate = purchaseDate;
		this.purchaseStatus = purchaseStatus;
	}
	
	public PurchaseDTO(int orderNo, ProductDTO productDTO, int purchaseQty, String purchaseDate,
			String purchaseStatus) {
		super();
		this.orderNo = orderNo;
		this.productDTO = productDTO;
		this.purchaseQty = purchaseQty;
		this.purchaseDate = purchaseDate;
		this.purchaseStatus = purchaseStatus;
	}


	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
	public int getPurchaseQty() {
		return purchaseQty;
	}
	public void setPurchaseQty(int purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public PurchaseDTO() {
		super();
	}
	
	public void setPageCnt(int pageCnt) { 
		super.setPageCnt(pageCnt);
	}
	public int getPageCnt() { 
		return super.getPageCnt();
	}

}
