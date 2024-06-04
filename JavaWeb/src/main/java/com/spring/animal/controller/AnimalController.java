package com.spring.animal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	@PostMapping("/animalInsert")
	public String animalInsert(AnimalVO avo) throws Exception{
		animalService.animalInsert(avo);
		return "redirect:/animal/animalList";
	}
	
	@GetMapping(value="/writeForm")
	public String writeForm() {
		return "project/animal/writeForm";
	}
	
	@GetMapping(value="/updateForm")
	public String updateForm(@ModelAttribute AnimalVO avo, Model model) {
		log.info("updateForm 호출 성공");
		log.info("animalId="+avo.getAnimalId());
		AnimalVO updateData = animalService.updateForm(avo);
		model.addAttribute("updateData",updateData);
		return "project/animal/updateForm";
	}
	
	
	@PostMapping("/animalUpdate")
	public String animalUpdate(@ModelAttribute AnimalVO avo) throws Exception {
		log.info("animalUpdate 호출 성공");
		int result = 0;
			String url ="";
			result = animalService.animalUpdate(avo);
			
			if(result ==1 ) {
				url  = "/animal/animalDetail?animalId="+avo.getAnimalId();
			} else {
				url="/animal/updateForm?animalId=" +avo.getAnimalId();
			}
			return "redirect:" + url;
	}
	
	@PostMapping(value="/animalDelete")
	public String animalDelete(@ModelAttribute AnimalVO avo) throws Exception{
		log.info("animalDelete 호출 성공 ");
		animalService.animalDelete(avo);
		return "redirect:/animal/animalList";
	}
	
	@ResponseBody
	@PostMapping(value="/pwdConfirm", produces = "text/plain; charset=UTF-8")
	public String pwdConfirm(AnimalVO avo) {
		log.info("pwdConfirm 호출 성공 ");
		int result = animalService.pwdConfirm(avo);
			String value="";
			if(result==1) {
				value="일치";
			}else {
				value="불일치";
			}
			log.info("result =" +result);
			return value;
	}
	
	
}
