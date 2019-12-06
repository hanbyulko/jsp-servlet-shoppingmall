package nmm.dto;

public class CartDTO extends PageCnt{
	private int cartNo;
	private UserDTO userDTO;
	private ProductDTO productDTO;
	private int cartQty;
	public CartDTO(int cartNo, UserDTO userDTO, ProductDTO productDTO, int cartQty) {
		super();
		this.cartNo = cartNo;
		this.userDTO = userDTO;
		this.productDTO = productDTO;
		this.cartQty = cartQty;
	}
	public CartDTO() {
		super();
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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
	public int getCartQty() {
		return cartQty;
	}
	public void setCartQty(int cartQty) {
		this.cartQty = cartQty;
	}
	
	public void setPageCnt(int pageCnt) { 
		super.setPageCnt(pageCnt);
	}
	

	public int getPageCnt() { 
		return super.getPageCnt();
	}
	
}
