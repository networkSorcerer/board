package com.spring.adoption.service;

import java.util.List;

import com.spring.adoption.vo.AdoptionVO;

public interface AdoptionService {
	public List<AdoptionVO> adoptionList(AdoptionVO adoptionvo);
	
	public int adoptionListCnt(AdoptionVO adoptionvo);
	public AdoptionVO adoptionDetail(AdoptionVO adoptionvo);
	public int pwdConfirm(AdoptionVO adoptionvo);
	public AdoptionVO updateForm(AdoptionVO adoptionvo);
	
	public int adoptionInsert(AdoptionVO adoptionvo) throws Exception;
	public int adoptionUpdate(AdoptionVO adoptionvo) throws Exception;
	public int adoptionDelete(AdoptionVO adoptionvo) throws Exception;
}
