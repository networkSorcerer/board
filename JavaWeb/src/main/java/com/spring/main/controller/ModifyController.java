package com.spring.main.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.spring.admin.login.vo.AdminLoginVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/project/*")
@Slf4j
public class ModifyController {
	
	@GetMapping("/volunteer")
	public String showCalendar() {
        return "/volunteer/volunteer";
    }
	
	@GetMapping("/adminVolunteerList")
	public String adminVolunteerList(@SessionAttribute(name = "adminLogin", required = false) AdminLoginVO adminLoginVO) {
		if(adminLoginVO == null) {
			return "/admin/adminLogin";
		} else {
			return "/admin/volunteer/adminVolunteerList";
		}
	}
}
	