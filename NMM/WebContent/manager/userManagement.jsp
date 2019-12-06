<%@page import="com.sun.corba.se.spi.orbutil.fsm.Guard.Result"%>
<%@page import="nmm.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script> 
      setTimeout(function(){
         location.reload();
      }, 10000);
</script> -->
</head>
<style>
 .a{border:solid red 5px}
 span{width:150px; color:red}
 input{border:solid gray 1px}
 table{width:100%}
 th,td{border:1px gray solid; text-align:center;padding:3px}
 h2{text-align:center}


.container {
  padding: 2em;
}

/* GENERAL BUTTON STYLING */
[type = button],
[type = button]::after {
  -webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
  -o-transition: all 0.3s;
	transition: all 0.3s;
}

[type = button] {
  background: none;
  border: 3px solid #2ecc71;
  border-radius: 5px;
  color:#2ecc71;
  display: block;
  font-size: 1em;
  font-weight: bold;
  margin: 1em auto;
  padding: 1em 3em;
  position: relative;
  text-transform: uppercase;
}
}
</style>

 <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function () {
	function selectAll(){
		
	    $.ajax({
		type:"get",	
		url:"../selectServlet",
	    dataType: "json",
	    success: function(result){''
	    	var str="";
	    		$.each(result,function(index,item){
					str+="<tr>";
					str+="<td>"+(index+1)+"</td>";
					str+="<td><a href='#'>"+item.userId+"</a></td>";
					str+="<td>"+item.userPwd+"</td>";
					str+="<td>"+item.userPhone+"</td>";
					str+="<td><input type='button' value='삭제' name='"+item.userId+"'delete'><input type='button' value='수정하기'></td>";
					str+="</tr>";
				});
	    		str+="</table>";
				// before after는 형제
				// append 는 하위
				// html은 덮어쓰기
				 $("#listTable tr:gt(0)").remove();
				$("#listTable").append(str);
				  $("a").css("textDecoration", "none");
					this.userNo = userNo;
					this.userId = userId;
					this.userPwd = userPwd;
					this.userName = userName;
					this.userBirth = userBirth;
					this.userPhone = userPhone;
					this.userAddr = userAddr;
					this.userEmail = userEmail;
	      } ,
	    error : function(err){
	  	  console.log(err+"=> 오류발생");
	    }
		});//ajax끝
	}
	  selectAll();
})
</script>
<body>
   
   <div name="userManagement" >
<h1 class="table--title">회원 관리 </h1>
<form method='post' action="<%=application.getContextPath()%>/manager/userManagementUpdate.jsp">
<table class="table" cellspacing="0">
      <tr>
         <th>회원 번호</th>
         <th>회원 ID</th>
         <th>회원 이름</th>
         <th>회원 비밀번호</th>
         <th>기능</th>

      </tr>
   		      <h2> 고객 리스트 !  </h2>
<table  class="table" id="listTable" cellspacing="0" >
			<tr bgcolor="pink">
			   <th>번호</th>
			   <th>아이디</th>
				<th>이름</th>
				<th>이메일</th>	
				<th>주소</th>
			</tr>
</table>    
      
      
      <tr>
            <td>userNo</td>
            <td><a href="#" class=openMask>userID</a></td>
            <td>userName </td>
            <td>userPassword</td>
            <td><input type="submit" value="수정하기"><input type="button" value= "삭제하기"></td>
            </tr>
   </table>

    </form>
   </div>
   
</body>
</html>