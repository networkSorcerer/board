<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
	#banner-container {
    position: fixed;
    top: 0;
    left: -300px; /* 배너가 열렸을 때의 위치 */
    width: 300px;
    height: 100%;
    background-color: #f0f0f0;
    transition: left 0.3s ease;
    z-index: 9999;
}

#banner-content {
    padding: 20px;
}
#toggle-btn {
    position: fixed;
    top: 100px;
    left: 0;
    width: 50px; /* 버튼의 너비 조절 */
    height: 90px; /* 버튼의 높이 조절 */
    background-color: #007bff;
    color: #fff;
    border: none;
    cursor: pointer;
    z-index: 10000; /* 다른 요소 위에 표시되도록 z-index 설정 */
    padding: 10px; /* 텍스트 내용과 버튼의 여백 조절 */
    box-sizing: border-box; /* padding이 width와 height에 포함되도록 설정 */
    line-height: 1.5; /* 텍스트 줄 간격 설정 */
    border-top-right-radius: 25px;
    border-bottom-right-radius: 25px;
}

#toggle-btn:hover {
    background-color: #0056b3;
}
#banner-content img {
    max-width: 100%; /* 이미지의 최대 너비는 부모 요소인 #banner-content의 너비에 맞추어집니다. */
    max-height: 100%; /* 이미지의 최대 높이도 부모 요소에 맞추어집니다. */
}	
</style>
<body>

<div id="banner-container">
    <div id="banner-content">
    	</br>
    	</br>
        <button class="button" type="button">현재 날씨는?</button><br /><br />
        <img src="/resources/images/walk.jpg">
		<dl>
			<dt>기온</dt>
			<dd class="temperature"></dd> <!-- 수정: class 속성 적용 -->
			<dt>위치</dt>
			<dd class="place"></dd> <!-- 수정: class 속성 적용 -->
			<dt>설명</dt>
			<dd class="description"></dd>
		</dl>
		<img class="icon"/>
        
       
    </div>
</div>
	 <button id="toggle-btn">같이<br>산책<br>가요</button>
	<script src="/resources/weather/weather.js"></script>
</body>
</html>
