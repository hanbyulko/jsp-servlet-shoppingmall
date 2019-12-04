<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<form method="post" action="../servlet?controller=user&command=upDate">
	 userId : <%
		if(session.getAttribute("userId")!=null){
			String i = (String)session.getAttribute("userId");
			out.print("<input type='text' id='userId' name='userId' value='"+i+"' readonly><br>");
		}
	%>
  PWD : <input type="password" id="userPwd" name="userPwd" /><br>
  userName : <input type="text" id="userName" name="userName" /><br>
  userPhone : <input type="text" id="userPhone" name="userPhone" /><br>
  userAddr : <input type="text" id="userAddr" name="userAddr" /><br>
  userEmail : <input type="text" id="userEmail" name="userEmail" /><br>
    
  <input type="submit" value="회원정보 수정" />
  
</form>

<form method="post" action="../servlet?controller=user&command=delete">
  <input type="submit" value="회원탈퇴" />
  <input type="text" id="userId" name="userId" style="visibility:hidden" value="<%=session.getAttribute("userId")%> "/>
</form>
</html>