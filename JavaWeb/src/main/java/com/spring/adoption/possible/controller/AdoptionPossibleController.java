package com.spring.adoption.possible.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.adoption.possible.service.AdoptionPossibleService;
import com.spring.adoption.possible.vo.AdoptionPossibleVO;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/ap/*")
@Slf4j
public class AdoptionPossibleController {
	@Setter(onMethod_=@Autowired)
	private AdoptionPossibleService adoptionPossibleService;
	
	@GetMapping("/apList")
	public String apList(@ModelAttribute AdoptionPossibleVO apvo, Model model) {
		log.info("apList 호출 성공");
		
		List<AdoptionPossibleVO>apList = adoptionPossibleService.apList(apvo);
		 model.addAttribute("apList", apList);
		
		return "project/adoptionPossible/adoptionView";
	}
	
	@GetMapping("/apDetail")
	public String apDetail(@ModelAttribute AdoptionPossibleVO apvo, Model model) {
		log.info("adoptionPossible 호출 성공");
		
		AdoptionPossibleVO detail = adoptionPossibleService.apDetail(apvo);
		model.addAttribute("detail", detail);
		
		return "project/adoptionPossible/adoptionPossibleDetail";
	}
}
