package nmm.dto;

public class UserDTO {
   private int userNo;
   private String userId;
   private String userPwd;
   private String userName;
   public UserDTO(String userId, String userPwd) {
   super();
   this.userId = userId;
   this.userPwd = userPwd;
}
public UserDTO(int userNo, String userId, String userPwd) {
   super();
   this.userNo = userNo;
   this.userId = userId;
   this.userPwd = userPwd;
}
private String userBirth;
   private String userPhone;
   private String userAddr;
   private String userEmail;
public UserDTO(int userNo, String userId, String userPwd, String userName, String userBirth, String userPhone,
      String userAddr, String userEmail) {
   super();
   this.userNo = userNo;
   this.userId = userId;
   this.userPwd = userPwd;
   this.userName = userName;
   this.userBirth = userBirth;
   this.userPhone = userPhone;
   this.userAddr = userAddr;
   this.userEmail = userEmail;
}
public UserDTO(String userId, String userPwd, String userName, String userAddr, String userPhone,
      String userEmail, String userBirth) {
   this.userId=userId;
   this.userPwd = userPwd;
   this.userName = userName;
   this.userAddr = userAddr;
   this.userPhone = userPhone;
   this.userEmail = userEmail;
   this.userBirth = userBirth; 
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
public String getUserPhone() {
   return userPhone;
}
public void setUserPhone(String userPhone) {
   this.userPhone = userPhone;
}
public String getUserAddr() {
   return userAddr;
}
public void setUserAddr(String userAddr) {
   this.userAddr = userAddr;
}
@Override
public String toString() {
   return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
         + ", userBirth=" + userBirth + ", userPhone=" + userPhone + ", userAddr=" + userAddr + ", userEmail="
         + userEmail + "]";
}
public String getUserEmail() {
   return userEmail;
}
public void setUserEmail(String userEmail) {
   this.userEmail = userEmail;
}
 
}