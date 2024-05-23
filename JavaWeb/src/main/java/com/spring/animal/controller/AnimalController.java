package com.spring.animal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.animal.service.AnimalService;
import com.spring.animal.vo.AnimalVO;
import com.spring.common.vo.PageDTO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/animal/*")
@Slf4j
public class AnimalController {
	@Setter(onMethod_=@Autowired)
	private AnimalService animalService;
	
	@GetMapping("/animalList")
	public String animalList(@ModelAttribute AnimalVO avo, Model model) {
		log.info("animalList 호출 성공");
		List<AnimalVO> animalList = animalService.animalList(avo);
		model.addAttribute("animalList",animalList);
		
		int total = animalService.animalListCnt(avo);
		model.addAttribute("pageMaker", new PageDTO(avo, total));
		
		return "project/animal/animalList";
	}
	
	@GetMapping("/animalDetail")
	public String animalDetail( @ModelAttribute AnimalVO avo, Model model) {
		AnimalVO detail = animalService.animalDetail(avo);
		model.addAttribute("detail",detail);
		
		return "project/animal/animalDetail";
		
	}
	
	
	@GetMapping("/animalInsert")
	public String animalInsert(AnimalVO avo) throws Exception{
		animalService.animalInsert(avo);
		return "redirect:/animal/animalList";
	}
}
