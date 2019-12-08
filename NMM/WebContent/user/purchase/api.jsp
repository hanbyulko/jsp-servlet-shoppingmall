<%@ page import="java.util.List" %>
<%@ page import="nmm.dto.UserDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--결제 완료되면 purchaseDB에 있는 status값 상태를 배송준비중에서 바꿔줘야될듯--%>
<%--<c:forEach var="pur" items="${list}">--%>

<%--        String name=${pur.userDTO.userName}--%>
<%--        ${pur.userDTO.userPhone}--%>
<%--        ${pur.userDTO.userEmail}--%>
<%--        ${pur.userDTO.userAddr}--%>
<%--</c:forEach>--%>

<%--<% UserDTO dto = new UserDTO();--%>
<%--    String name="";--%>
<%--    List<UserDTO> list = new ArrayList<UserDTO>();--%>
<%--    list = (List)request.getAttribute("list");--%>
<%--    for (int i = 0; i < list.size(); i++) {--%>
<%--        dto=list.get(i);--%>

<%--        name=dto.getUserName();--%>
<%--    }--%>

   <%	
   
   	String state = request.getParameter("state");
	
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    String productName=request.getParameter("productName");
//    int totalPrice = (int)request.getAttribute("totalPrice");
    
//    String name = "고한별";
//    String email = "wo2306@gmail.com";
//    String phone = "01093890570";
//    String address = "경기도 용인시 수지구 죽전동 푸른솔로 41";
    int totalPrice = 100;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
    <script>
    $(function(){
        var IMP = window.IMP; // 생략가능
        IMP.init('imp32416573'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '<%=productName%>',
            amount : <%=totalPrice%>,
            buyer_email : '<%=email%>',
            buyer_name : '<%=name%>',
            buyer_tel : '<%=phone%>',
            buyer_addr : '<%=address%>',
            buyer_postcode : '123-456',
            //m_redirect_url : 'http://www.naver.com'
        }, function(rsp) {
            if ( rsp.success ) { 	
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "/payments/complete", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid
                        //기타 필요한 데이터가 있으면 추가 전달
                    }
                }).done(function(data) {
                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
                    if ( everythings_fine ) {
                        msg = '결제가 완료되었습니다.';
                        msg += '\n고유ID : ' + rsp.imp_uid;
                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
                        msg += '\결제 금액 : ' + rsp.paid_amount;
                        msg += '카 드 승인번호 : ' + rsp.apply_num;
                        
                        alert(msg);
                    } else {
                        //[3] 아직 제대로 결제가 되지 않았습니다.
                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
                    	msg = '결제에 실패하였습니다. 메인 화면으로 돌아갑니다.';
                    	alert(msg);
                    	location.href="${pageContext.request.contextPath}/servlet?controller=product+review&command=productList";
                    }
                });
               	alert("결제 성공")
               	<%
               		if(state.equals("0")){
               			int productNo = Integer.parseInt(request.getParameter("productNo"));
               			int purchaseQty = Integer.parseInt(request.getParameter("purchaseQty"));
               	%>
               	
               			location.href="../../servletForAPI?productNo="+<%=productNo%>+"&purchaseQty="+<%=purchaseQty%>;
               			location.href="${pageContext.request.contextPath}/user/purchase/purchaseSuccess.jsp";
               	<%
               		}else if(state.equals("1")){
               			int cntNum = Integer.parseInt(request.getParameter("cntNum"));
               			System.out.println(cntNum);
               			for(int i = 0 ; i < cntNum; i++){
               				System.out.println(request.getParameter("productNo["+i+"]"));
               				System.out.println(request.getParameter("cartQty["+i+"]"));
               				%>
               				location.href="../../servletForAPI?productNo="+<%=request.getParameter("productNo["+i+"]")%>+"&purchaseQty="+<%=request.getParameter("cartQty["+i+"]")%>;
               				<%
               			}
               			%>
               			location.href="${pageContext.request.contextPath}/user/purchase/purchaseSuccess.jsp";
               			<%
               		}
               	
                %>	
                
                //성공시 이동할 페이지
<<<<<<< HEAD
                location.href='<%=request.getContextPath()%>user/purchase/purchaseSuccess';
=======
                //location.href="${pageContext.request.contextPath}/servlet?controller=product+review&command=productList";
                
>>>>>>> 1cb320f5d40eb03a8fec3e1485103c997643314a
            } else {
                msg = '결제에 실패하였습니다. 메인 화면으로 돌아갑니다.';
                //실패시 이동할 페이지
                location.href="${pageContext.request.contextPath}/servlet?controller=product+review&command=productList";
                alert(msg);
            }
        });
        
    });
    </script>
 
</body>
</html>
