<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding=""UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script> 
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@6.1.11/index.global.min.js'></script>
    <script>
    document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, {
            headerToolbar: {
                left: 'prevYear,prev,next,nextYear today',
                center: 'title',
                right: 'customButton dayGridMonth,dayGridWeek,dayGridDay'
            },
            customButtons: {
                customButton: {
                    text: "일정 추가"
                }
            },
            initialDate: '2024-03-22',
            navLinks: false,
            editable: true,
            dayMaxEvents: true,
            events: {
                url: '/volunteer/volunteerList',
                method: 'GET',
                extraParams: {
                    custom_param1: 'value1',
                    custom_param2: 'value2'
                },
                success: function(data) {
                    console.log('Data loaded:', data);
                    calendar.removeAllEvents();
                    var events = [];
                    data.forEach(function(eventObj) {
                        var time = new Date(eventObj.volunteerTime);
                        var isoTimeString = time.toISOString();
                        events.push({
                            title: eventObj.volunteerTitle,
                            start: isoTimeString,
                            allDay: true,
                            extendedProps: {
                                volunteerId: eventObj.volunteerId
                            }
                        });
                    });
                    calendar.addEventSource(events);
                },
                failure: function() {
                    console.error('There was an error while fetching events.');
                },
                loading: function(isLoading) {
                    if (isLoading) {
                        console.log('Loading events...');
                    } else {
                        console.log('Events loaded.');
                    }
                }
            },
            eventClick: function(info) {
                var volunteerId = info.event.extendedProps.volunteerId;
                /*$.ajax({
                    url: '/volunteer/volunteerDetail',
                    method: 'POST',
                    data: {
                        volunteerId: volunteerId
                    },
                    success: function(response) {
                        console.log('Event detail:', response);
                    },
                    error: function(xhr, status, error) {
                        console.error('Error: ', error)
                    }
                });*/
                location.href = "/volunteer/adminVolunteerDetail?volunteerId="+volunteerId;
                info.jsEvent.preventDefault();
            }
        });

        calendar.render();

        calendarEl.querySelector('.fc-customButton-button').addEventListener('click', function() {
            location.href = "/volunteer/volunteerWriteForm";
        });
    });
    </script>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div
		class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
		<h1 class="h2">봉사공고</h1>
	</div>
	<div class="container">
		<!-- 여기에 페이지 구현하세요 -->
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center">
						<div class="calendar-container">
							<div id='calendar'></div>
						</div>
					</header>
				</div>
			</div>
		</div>	
	</div>
	
</main>
</div>
</div>
<script src="/resources/include/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="/resources/include/assets/js/color-modes.js"></script>
<script src="/resources/include/js/common.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@4.3.2/dist/chart.umd.js"
	integrity="sha384-eI7PSr3L1XLISH8JdDII5YN/njoSsxfbrkCTnJrzXt+ENP5MOVBxD+l6sEG4zoLp"
	crossorigin="anonymous"></script>
<script src="/resources/include/js/dashboard.js"></script>
</body>
</html>