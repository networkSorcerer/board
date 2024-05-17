<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/admin.jspf"%>
<main>
	<div class="container">
		<div class="container"><h3>동물 리스트</h3></div>
	</div>
	<form id="detailForm">
		<input type="hidden" id="animalId" name="animalId"/>
	</form>
	
	<div id="animalSearch">
            <form id="f_search" name="f_search">
                 <input type="hidden" name="pageNum" id="pageNum" value="${pageMaker.cvo.pageNum}">
                   <input type="hidden" name="amount" id="amount" value="${pageMaker.cvo.amount}">
                <div class="row g-2 align-items-center">
                    <label for="search">검색조건</label>
                </div>
                <div class="col-auto">
                    <select id="search" name="search" class="form-select form-select-sm">
                        
                        <option value="animal_id">동물 ID</option>
                        <option value="animal_name">이름</option>
                        <option value="animal_species">분류</option>
                        <option value="animal_temp">임시 보호 유무</option>
                    </select>
                </div>
                <div class="col-auto">
                    <input type="text" name="keyword" id="keyword" placeholder="검색어를 입력하세요" class="form-control form-control-sm" />
                </div>
                <div class="col-auto">
                    <button type="button" id="searchData" class="btn btn-success btn-sm">검색</button>
                    <button type="button" id="animalListBtn" class="btn btn-success btn-sm">전체 목록</button>
                </div>
            </form>
        </div>
		
		 <div id="animalSearch" class="text-right"></div>
        
        <div id="animalList">
            <table summary="게시판 리스트" class="table table-striped">
                <thead>
                    <tr class="text-center">
                        <th class="col-md-1">동물 ID</th>
                        <th class="col-md-1">사진</th>
                        <th class="col-md-1">이름</th>
                        <th class="col-md-1">분류</th>
                        <th class="col-md-1">무게</th>
                        <th class="col-md-1">중성화 유무</th>
                        <th class="col-md-1">성별</th>
                        <th class="col-md-1">임시보호</th>
                        <th class="col-md-2">작성일</th>
                        <th class="col-md-1">조회수</th>
                    </tr>
                </thead>
                <tbody id="list">
                    <c:choose>
                        <c:when test="${not empty animalList}">
                            <c:forEach var="animal" items="${animalList}" varStatus="status">
                                <tr class="text-center id" data-num="${animal.animalId}">
                                    
                                    <td class="id">${animal.animalId}</td>
                                    <td>
                                        <img src="<c:if test='${not empty animal.animalFile}'>/resources/images/storage/animal/${animal.animalFile}</c:if>
                                         <c:if test='${empty animal.animalFile}'>/resources/images/common/noanimal.jpg</c:if>"
                                       class="card-img-top l"  alt="Animal Image">
                                    </td>
                                    <td class="goDetail text-start">
                                        ${animal.animalName}
                                    </td>
                                    <td class="species">${animal.animalSpecies}</td>
                                    <td class="kg">${animal.animalKg}</td>
                                    <td class="status">${animal.animalStatus}</td>
                                    <td class="gender">${animal.animalGender}</td>
                                    <td class="temp0">${animal.animalTemp}</td>
                                    <td class="regist">${animal.animalRegist}</td>
                                    <td class="readcnt">${animal.readcnt}</td>
                                  </tr>  
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="10" class="text-center">등록된 게시물이 존재하지 않습니다</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>		
		<div class="text-end">
			<button type="button" id="insertFormBtn" class="btn btn-success btn-sm">새로 등록 하기</button>
		</div>	
	</div>
	
    <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <c:if test="${pageMaker.prev}">
                    <li class="page-item disabled">
                        <a class="page-link">Previous</a>
                    </li>
                </c:if>
                <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                    <li class="page-item ${pageMaker.cvo.pageNum == num ? 'active':''}">
                        <a href="${num}" class="page-link" href="#">${num}</a>
                    </li>
                </c:forEach>
                <c:if test="${pageMaker.next}">
                    <li class="page-item">
                        <a href="${pageMaker.endPage + 1}" class="page-link" href="#">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>

	</div>
	
	<script src="/resources/include/js/animal/animalList.js"></script>
	<script>
		$(function(){
			/* 검색 후 검색 대상과 검색 단어 출력 */
			let word="<c:out value='${animalVO.keyword}' />";
			let value="";
			if(word!=""){
				$("#keyword").val("<c:out value='${animalVO.keyword}' />");
				$("#search").val("<c:out value='${animalVO.search}' />");
			
				if($("#search").val()!='animal_status'){
					//:contains()는 특정 텍스트를 포함한 요소반환 	
					if($("#search").val()=='animal_name') value = "#list tr td.goDetail";
					else if($("#search").val()=='animal_id') value="#list tr td.id";
					else if($("#search").val()=='animal_species')value="#list tr td.species"
					else if($("#search").val()=='animal_temp')value="#list tr td.temp"
					console.log($(value+":contains('"+word+"')").html());
					//$("#list tr td.goDetail:contains('노력')").html()  => <span class='required'>노력</span>에 대한 명언
			    	$(value+":contains('"+word+"')").each(function () {
						let regex = new RegExp(word,'gi');
						$(this).html($(this).html().replace(regex,"<span class='required'>"+word+"</span>"));
			    	});
				}
			}
		});	
	</script>
	<script src="/resources/include/js/common.js"></script>
</main>
</body>
</html>