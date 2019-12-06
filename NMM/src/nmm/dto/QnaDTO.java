package nmm.dto;

public class QnaDTO extends PageCnt{
	private int qnaNo; 
	private UserDTO userDTO;
	private ProductDTO productDTO; 
	private String qnaTitle;
	private String qnaContent; 
	private String qnaDate;
	private String qnaResponseState; //답변상태
	private String qnaResponseContent; //답변내용
	
	
	public QnaDTO(int pageCnt, int qnaNo, UserDTO userDTO, ProductDTO productDTO, String qnaTitle, String qnaContent,
			String qnaDate, String qnaResponseState, String qnaResponseContent) {
		super(pageCnt);
		this.qnaNo = qnaNo;
		this.userDTO = userDTO;
		this.productDTO = productDTO;
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaResponseState = qnaResponseState;
		this.qnaResponseContent = qnaResponseContent;
	}
	public QnaDTO() {
	}
	public QnaDTO(String qnaTitle, String qnaContent) {
		this.qnaTitle= qnaTitle;
		this.qnaContent = qnaContent;
	}
	public QnaDTO(int qnaNo, String qnaTitle, String qnaContent) {
		this.qnaNo = qnaNo;
		this.qnaTitle =qnaTitle;
		this.qnaContent = qnaContent;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getQnaResponseState() {
		return qnaResponseState;
	}
	public void setQnaResponseState(String qnaResponseState) {
		this.qnaResponseState = qnaResponseState;
	}
	public String getQnaResponseContent() {
		return qnaResponseContent;
	}
	public void setQnaResponseContent(String qnaResponseContent) {
		this.qnaResponseContent = qnaResponseContent;
	}
	
	public void setPageCnt(int pageCnt) { 
		super.setPageCnt(pageCnt);
	}
	
	public int getPageCnt() { 
		return super.getPageCnt();
	}

}
