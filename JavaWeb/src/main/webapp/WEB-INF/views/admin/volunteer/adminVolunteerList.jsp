<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding=""UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script> 
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarE1 = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarE1, {
			headerToolbar: {
				
			}
		})
	})
	
</script>
</body>
</html>