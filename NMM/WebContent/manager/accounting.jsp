<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
	<title>
    Assigning Axis Example - HTML5 jQuery Chart Plugin by jqChart
</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.jqChart.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/le-frog/styles.css" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.jqChart.min.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
     
    <c:set value="${fn:length(list)}" var="size"/>
    <script lang="javascript" type="text/javascript">
   /*  String mgtDate;
	int mgtLoginNo;
	int mgtProfit; */
        $(document).ready(function () {
            $('#jqChart').jqChart({
                title: { text: '이번달 이용자 수 및 매출액' },
                animation: { duration: 1 },
                axes: [
                    {
                        name: 'y1',
                        location: 'left'
                    },
                    {
                        name: 'y2',
                        location: 'right',
                        strokeStyle: '#FCB441',
                        majorGridLines: { strokeStyle: '#FCB441' },
                        majorTickMarks: { strokeStyle: '#FCB441' }
                    }
                ],
                series: [
                    {
                    	title : "이용자 수",
                        type: 'column',
                        axisY: 'y1',
                        data: [
                        	<c:forEach items="${list}" var="list" varStatus="state">
                        	<c:choose>
                        	  <c:when test="${state.count==size}">
                        	 	 [${list.mgtDate} ,${list.mgtLoginNo} ]
                        	  </c:when>
                        	  <c:otherwise>
                        	    [${list.mgtDate} ,${list.mgtLoginNo} ],
                        	  </c:otherwise>
                        	</c:choose>
                          </c:forEach>
                        	]
                        	
                    },
                    {
                    	title : "매출액",
                        type: 'line',
                        axisY: 'y2',
                        data: [
                        	['2019-12-01', 8000000], ['2019-12-02', 6000000], ['2019-12-03', 10000000],
                        	['2019-12-04', 7000000], ['2019-12-05', 11000000]
                        	]
                    }
                ]
            });
        });
        
        $.ajax({
        	
        });
    </script>

</head>
<body>


<c:forEach items="${list}" var="list" varStatus="stae">
	${list.mgtDate}<br>
	${list.mgtLoginNo}<br>
	${list.mgtProfit}<br>
</c:forEach>
    <div>
        <div id="jqChart" style="width: 1000px; height: 600px;">
        </div>
    </div>

</body>
</html>
