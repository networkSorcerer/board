package com.spring.adoption.possible.service;

import java.util.List;

import com.spring.adoption.possible.vo.AdoptionPossibleVO;

public interface AdoptionPossibleService {
	public List<AdoptionPossibleVO> apList(AdoptionPossibleVO apvo);
	
	public int apListCnt(AdoptionPossibleVO apvo);
	public AdoptionPossibleVO apDetail(AdoptionPossibleVO apvo);
	public int pwdConfirm(AdoptionPossibleVO apvo);
	public AdoptionPossibleVO updateForm(AdoptionPossibleVO apvo);
	
	public int apInsert(AdoptionPossibleVO apvo) throws Exception;
	public int apUpdate(AdoptionPossibleVO apvo) throws Exception;
	public int apDelete(AdoptionPossibleVO apvo) throws Exception;
	
}
