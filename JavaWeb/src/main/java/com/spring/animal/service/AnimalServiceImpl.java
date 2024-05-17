package com.spring.animal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.animal.dao.AnimalDAO;
import com.spring.animal.vo.AnimalVO;

import lombok.Setter;

@Service
public class AnimalServiceImpl implements AnimalService{
	@Setter(onMethod_=@Autowired)
	private AnimalDAO animalDAO;
	
	@Override
	public int animalListCnt(AnimalVO avo) {
		return animalDAO.animalListCnt(avo);
	}
	
	@Override
	public AnimalVO animalDetail(AnimalVO avo) {
		animalDAO.readCntUpdate(avo);
		
		AnimalVO detail = animalDAO.animalDetail(avo);
		if(detail != null) {
			detail.setAnimalMemo(detail.getAnimalMemo().replaceAll("\n", "<br/>"));
		}
		
		return detail;
	}

	@Override
	public List<AnimalVO> animalList(AnimalVO avo) {
		List<AnimalVO> list = null;
		list = animalDAO.animalList(avo);
		return list;
	}

	@Override
	public int pwdConfirm(AnimalVO avo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnimalVO updateForm(AnimalVO avo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int animalInsert(AnimalVO avo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int animalUpdate(AnimalVO avo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int animalDelete(AnimalVO avo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AnimalVO> mainani(AnimalVO avo) {
		// TODO Auto-generated method stub
		return null;
	}
}
