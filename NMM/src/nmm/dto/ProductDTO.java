package nmm.dto;

public class ProductDTO extends PageCnt {
	private int productNo;
	private String productCategory;
	private int productStock;
	private String productName;
	private String productColor;
	private String productSize;
	private int productPrice;
	private String productResiDate;
	public ProductDTO(int pageCnt, int productNo, String productCategory, int productStock, String productName,
			String productColor, String productSize, int productPrice, String productResiDate) {
		super(pageCnt);
		this.productNo = productNo;
		this.productCategory = productCategory;
		this.productStock = productStock;
		this.productName = productName;
		this.productColor = productColor;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.productResiDate = productResiDate;
	}
	
	public ProductDTO() {
		
	}
	public void setPageCnt(int pageCnt) { 
		super.setPageCnt(pageCnt);
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getProductSize() {
		return productSize;
	}
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductResiDate() {
		return productResiDate;
	}
	public void setProductResiDate(String productResiDate) {
		this.productResiDate = productResiDate;
	}
	
	public int getPageCnt() { 
		return super.getPageCnt();
	}

	
} 
