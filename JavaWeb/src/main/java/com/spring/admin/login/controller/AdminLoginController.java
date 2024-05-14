package com.spring.admin.login.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.admin.login.service.AdminLoginService;
import com.spring.admin.login.vo.AdminLoginVO;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("adminLogin")
@RequestMapping("/admin/*")
@Slf4j

public class AdminLoginController {
	@Setter(onMethod_= @Autowired)
	private AdminLoginService adminLoginService;
	
	@PostMapping("/login")
	public String loginProcess(AdminLoginVO login, Model model, RedirectAttributes ras) {
		AdminLoginVO adminLogin = adminLoginService.loginProcess(login);
		
		String url ="";
		
		if(adminLogin != null) {
			 model.addAttribute("adminLogin", adminLogin);
			url = "/project/adminVolunteerList";
		} else {
			ras.addFlashAttribute("errorMsg", "로그인 실패");
			url = "/admin";
		}
		return "redirect: " + url;
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		log.info("admin 로그인 아웃 처리");
		sessionStatus.setComplete();
		return "redirect:/admin";
	}
	
}
