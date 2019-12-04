package nmm.dto;

public class ManagerUserDTO {
	private int mgtUserNo;
	private String mgtUserId;
	private String mgtUserPwd;
	public ManagerUserDTO(int mgtUserNo, String mgtUserId, String mgtUserPwd) {
		super();
		this.mgtUserNo = mgtUserNo;
		this.mgtUserId = mgtUserId;
		this.mgtUserPwd = mgtUserPwd;
	}
	public ManagerUserDTO() {
		super();
	}
	public ManagerUserDTO(String mgtUserId, String mgtUserPwd) {
		this.mgtUserId = mgtUserId;
		this.mgtUserPwd = mgtUserPwd;
	}
	public int getMgtUserNo() {
		return mgtUserNo;
	}
	public void setMgtUserNo(int mgtUserNo) {
		this.mgtUserNo = mgtUserNo;
	}
	public String getMgtUserId() {
		return mgtUserId;
	}
	public void setMgtUserId(String mgtUserId) {
		this.mgtUserId = mgtUserId;
	}
	public String getMgtUserPwd() {
		return mgtUserPwd;
	}
	public void setMgtUserPwd(String mgtUserPwd) {
		this.mgtUserPwd = mgtUserPwd;
	}

	
	
}
