package com.spring.volunteer.controller;

import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.admin.login.vo.AdminLoginVO;
import com.spring.volunteer.service.VolunteerService;
import com.spring.volunteer.vo.VolunteerVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/volunteer/*")
@Controller
public class VolunteerController {
	@Autowired
	private VolunteerService service;
	
	@ResponseBody
	@GetMapping(value="/volunteerList", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO) {
		List<VolunteerVO> volunteerList=null;
		volunteerList = service.volunteerList(volunteerVO);
		return volunteerList;
	}
	

	@GetMapping("/volunteerDetail")
	public String volunteerDetail(VolunteerVO volunteerVO, Model model) {
		VolunteerVO volunteerDetail = null;
		volunteerDetail = service.volunteerDetail(volunteerVO);
		model.addAttribute("detail", volunteerDetail);
		return "/volunteer/volunteerDetail";
	}
	
	@ResponseBody
	@GetMapping(value="/adminVolunteerList", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<VolunteerVO> adminvolunteerList(VolunteerVO volunteerVO) {
		List<VolunteerVO>volunteerList = null;
		volunteerList = service.volunteerList(volunteerVO);
		return volunteerList;
	}
	
	@GetMapping("/volunteerWriteForm")
	public String volunteerWriteForm(VolunteerVO volunteerVO) {
		return "/admin/volunteer/volunteerWriteForm";	
	}
	
	@PostMapping("/volunteerInsert")
	public String volunteerInsert(VolunteerVO volunteerVO, RedirectAttributes ras) throws Exception {
		int result = 0;
		String url = "";
		
		result = service.volunteerInsert(volunteerVO);
		if(result == 1) {
			url ="/project/adminVolunteerList";
		} else {
			ras.addFlashAttribute("errorMsg", "입력에 문제가 있어 다시 진행해 주세요 ");
			url = "/volunteer/volunteerWriteForm";
		}
		return "redirect:" + url;
	}
	
	@GetMapping("/adminVolunteerDetail")
	public String adminVolunteerDetail(VolunteerVO volunteerVO, Model model) {
		VolunteerVO adminVolunteerDetail = null;
		adminVolunteerDetail = service.volunteerDetail(volunteerVO);
		model.addAttribute("detail",adminVolunteerDetail);
		return "/admin/volunteer/adminVolunteerDetail";
	}
	
	@GetMapping("/volunteerUpdateForm")
	public String volunteerUpdateForm(VolunteerVO volunteerVO, Model model ) {
		VolunteerVO volunteerUpdateForm = null;
		volunteerUpdateForm = service.volunteerUpdateForm(volunteerVO);
		model.addAttribute("updateList", volunteerUpdateForm);
		return "/admin/volunteer/volunteerUpdateForm";
	}
	
	@PostMapping("/volunteerUpdate")
	public String volunteerUpdate(VolunteerVO volunteerVO )throws Exception {
		int result=0;
		String url = "";
		
		result = service.volunteerUpdate(volunteerVO);
		int num = volunteerVO.getVolunteerId();
		if(result == 1) {
			url = "/volunteer/adminVolunteerDetail?volunteerId=" +num;
		}
		return "redirect:" + url;
	}
	
	@GetMapping("/volunteerDelete")
	public String volunteerDelete(VolunteerVO volunteerVO) throws Exception {
		int result = 0;
		String url ="";
		result = service.volunteerDelete(volunteerVO);
		if(result == 1) {
			url ="/project/adminVolunteerList";
		}
		return "redirect:" + url;
	}
	
}
