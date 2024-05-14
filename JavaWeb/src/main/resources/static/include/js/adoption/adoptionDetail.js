let buttonCheck = 0;
$(function(){
	$("#pwdChk").css("visibility", "hidden");
	
	let btnInit = function(){
		$("#message").removeClass("text-danger");
		$("#message").addClass("text-primary");
		$("message").text("작성시 입력한 비밀번호를 입력해주세요");
	}
	$("#updateFormBtn").on("click", ()=>{
		$("#f_data").attr({
			"method":"get",
			"action":"/adoption/updateForm"
		});
		$("f_data").submit();
	});
	
	$("#DeleteBtn").on("click", () => {
		$("#f_data").attr({
			"method":"post",
			"action":"/adoption/adoptionDelete"
		});
		$("f_data").submit();
		$("#pwdChk").css("visibility", "visible");
		btnInit();
		buttonCheck = "deleteButton";
	});
	
	
})