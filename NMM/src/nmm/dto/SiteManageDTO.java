package nmm.dto;

public class SiteManageDTO {
	String mgtDate;
	int mgtLoginNo;
	int mgtProfit;
	
	public SiteManageDTO() {}

	public SiteManageDTO(String mgtDate, int mgtLoginNo, int mgtProfit) {
		super();
		this.mgtDate = mgtDate;
		this.mgtLoginNo = mgtLoginNo;
		this.mgtProfit = mgtProfit;
	}

	public String getMgtDate() {
		return mgtDate;
	}

	public void setMgtDate(String mgtDate) {
		this.mgtDate = mgtDate;
	}

	public int getMgtLoginNo() {
		return mgtLoginNo;
	}

	public void setMgtLoginNo(int mgtLoginNo) {
		this.mgtLoginNo = mgtLoginNo;
	}

	public int getMgtProfit() {
		return mgtProfit;
	}

	public void setMgtProfit(int mgtProfit) {
		this.mgtProfit = mgtProfit;
	}
	
	
	
}
