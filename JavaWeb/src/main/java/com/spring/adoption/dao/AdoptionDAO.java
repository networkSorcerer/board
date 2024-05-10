package com.spring.adoption.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.adoption.vo.AdoptionVO;

@Mapper
public interface AdoptionDAO {
	public List<AdoptionVO> adoptionList(AdoptionVO adoptionvo);
	public int readCntUpdate(AdoptionVO adoptionvo);
	public int adoptionListCnt(AdoptionVO adopitonvo);
	public int adoptionInsert(AdoptionVO adoptionvo);
	public AdoptionVO adoptionDetail(AdoptionVO adoptionvo);
	
	public int pwdConfirm(AdoptionVO adoptionvo);
	public int adoptionUpddate(AdoptionVO adoptionvo);
	public int adoptionDelete(AdoptionVO adoptionvo);
}
