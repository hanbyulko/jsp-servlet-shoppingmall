package nmm.dto;

public class ManagerUserDTO {
	private int mgtUserNo;
	private String mgtUserId;
	private String mgtUserPwd;
	public ManagerUserDTO(int mgtUserNo, String mgtUserPwd, String mgtUserId) {
		super();
		this.mgtUserNo = mgtUserNo;
		this.mgtUserId = mgtUserId;
		this.mgtUserPwd = mgtUserPwd;
	}
	public ManagerUserDTO() {
		super();
	}
	public ManagerUserDTO(String mgtUserPwd, String mgtUserId) {
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
	@Override
	public String toString() {
		return "ManagerUserDTO [mgtUserNo=" + mgtUserNo + ", mgtUserId=" + mgtUserId + ", mgtUserPwd=" + mgtUserPwd
				+ "]";
	}

	
	
}
