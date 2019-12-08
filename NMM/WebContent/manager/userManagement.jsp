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


}
</style>

 <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function () {
	function selectAll(){
		
	    $.ajax({
		type:"post",	
		url:"../selectServlet",
	    dataType: "json",
	    success: function(result){''
	    	var str="";
	    		$.each(result,function(index,item){
					str+="<tr>";
					str+="<td>"+(index+1)+"</td>";
					str+="<td>"+item.userId+"</td>";
					str+="<td>"+item.userPwd+"</td>";
					str+="<td>"+item.userEmail+"</td>";
					str+="<td><input type='submit' value='삭제' id='"+item.userId+"' name='"+item.userId+"'></td>";
					str+="</tr>";
				});
	    		str+="</table>";
	    		
				 $("#listTable tr:gt(0)").remove();
				$("#listTable").append(str);
				  $("a").css("textDecoration", "none");
	      } ,
	    error : function(err){
	  	  console.log(err+"=> 오류발생");
	    }
		});//ajax끝
		var ajaxing=false;
		
		  $(document).on("click","[value='삭제']" , function(){
			  if(ajaxing){
				  alert("이미 호출중");
				  return;
			  }
			  ajaxing=false;
			  
			  // 현재 버튼의 name의 value를 가져오기
			  $.ajax({
			   type: "post",
			   url : "../servlet?controller=managerUser&command=delete",
			   dataType : "text",// 0 or 1
			   data : {"name" : $(this).attr("id")}, //
			   success : function(result){//text
				 if(result>0){
					 ajaxing=false;
					 selectAll();
				 }else{
					 alert("삭제되지 않았습니다.");
				 }
			   } ,
			   error : function(err){
				   console.log(err+" 오류발생");
			   } 
			 })//ajax끝
		  });
		
	}
	  selectAll();
	  setInterval(selectAll, 10000);
})
</script>
<body>
   <div name="userManagement" >
<h1 class="table--title">회원 관리 </h1>
<form method='post' action="<%=application.getContextPath()%>/servlet?controller=managerUser&command=delete">
<table class="table" cellspacing="0">

   		      <h2> 고객 리스트 !  </h2>
<table  class="table" id="listTable" cellspacing="0"  >
			<tr bgcolor="pink">
	   <th>userNo</th>
	   <th>userID</th>
		<th>userName</th>
		<th>userAddr</th>
		<th>수정하기 삭제하기 기능</th>
			</tr>
</table>  
   </table>
    </form>
   </div>
   
</body>
</html>