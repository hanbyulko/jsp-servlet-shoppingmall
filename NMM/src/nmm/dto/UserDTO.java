package nmm.dto;

public class UserDTO extends PageCnt {
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String userBirth;
	private int userPhone;
	private String userAddr;
	private String userEmail;

	public UserDTO(int pageCnt, int userNo, String userId, String userPwd, String userName, String userBirth,
			int userPhone, String userAddr, String userEmail) {
		super(pageCnt);
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.userEmail = userEmail;
	}

	public UserDTO(int userNo, String userName, String userId, String userPwd, String userAddr, int userPhone,
			String userEmail, String userBirth) {
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userAddr = userAddr;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public UserDTO(int userNo, String userId, String userPwd) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public UserDTO(String userId, String userPwd, String userName, int userPhone, String userAddr,
			String userEmail) {
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userAddr = userAddr;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}


	public UserDTO(String userId, String userPwd, String userName, String userBirth, String userAddr,
			int userPhone, String userEmail) {

		this.userId= userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userAddr = userAddr;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public int getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public void setPageCnt(int pageCnt) { 
		super.setPageCnt(pageCnt);
	}
	
	public int getPageCnt() { 
		return super.getPageCnt();
	}

}