package com.spring.adoption.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.adoption.dao.AdoptionDAO;
import com.spring.adoption.vo.AdoptionVO;

import lombok.Setter;

@Service
public class AdoptionServiceImpl implements AdoptionService{
	
	@Setter(onMethod_=@Autowired)
	private AdoptionDAO adoptionDAO;

	@Override
	public List<AdoptionVO> adoptionList(AdoptionVO adoptionvo) {
		List<AdoptionVO> list =null;
		list = adoptionDAO.adoptionList(adoptionvo);
		return list;
	}

	@Override
	public int adoptionListCnt(AdoptionVO adoptionvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdoptionVO adoptionDetail(AdoptionVO adoptionvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pwdConfirm(AdoptionVO adoptionvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdoptionVO updateForm(AdoptionVO adoptionvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adoptionInsert(AdoptionVO adoptionvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adoptionUpdate(AdoptionVO adoptionvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adoptionDelete(AdoptionVO adoptionvo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
