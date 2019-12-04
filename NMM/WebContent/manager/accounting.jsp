<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>
    Assigning Axis Example - HTML5 jQuery Chart Plugin by jqChart
</title>
	<link rel="stylesheet" type="text/css" href="../css/jquery.jqChart.css" />
	<link rel="stylesheet" type="text/css" href="../themes/le-frog/styles.css" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="../js/jquery-3.4.1.min.js" type="text/javascript"></script>
	<script src="../js/jquery.jqChart.min.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script lang="javascript" type="text/javascript">
   
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
                        	['2019-12-01', 150 ], ['2019-12-02', 100], ['2019-12-03', 200]
                        	]
                    },
                    {
                    	title : "매출액",
                        type: 'line',
                        axisY: 'y2',
                        data: [
                        	['2019-12-01', 8000000], ['2019-12-02', 6000000], ['2019-12-03', 10000000]
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
<jsp:include page="../view/top.jsp"/>
<jsp:include page="leftButton.jsp"/>

    <div>
        <div id="jqChart" style="width: 1000px; height: 600px;">
        </div>
    </div>
<jsp:include page="../view/footer.jsp"/>
</body>
</html>
