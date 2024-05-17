package com.spring.animal.service;

import java.util.List;

import com.spring.animal.vo.AnimalVO;

public interface AnimalService {
	public List<AnimalVO> animalList(AnimalVO avo);
	
	public int animalListCnt(AnimalVO avo);
	public AnimalVO animalDetail(AnimalVO avo);
	public int pwdConfirm(AnimalVO avo);
	public AnimalVO updateForm(AnimalVO avo);
	
	public int animalInsert(AnimalVO avo) throws Exception;
	public int animalUpdate(AnimalVO avo) throws Exception;
	public int animalDelete(AnimalVO avo) throws Exception;
	
	public List<AnimalVO> mainani(AnimalVO avo);
}
