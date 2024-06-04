package com.spring.adoption.possible.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.adoption.possible.vo.AdoptionPossibleVO;


@Mapper
public interface AdoptionPossibleDAO {
	public List<AdoptionPossibleVO>apList(AdoptionPossibleVO apvo);
	public int apInsert(AdoptionPossibleVO apvo);
	public AdoptionPossibleVO apDetail(AdoptionPossibleVO apvo);
	public int readCntUpdate(AdoptionPossibleVO apvo);
	public int pwdConfirm(AdoptionPossibleVO apvo);
	public int apUpdate(AdoptionPossibleVO apvo);
	public int apDelete(AdoptionPossibleVO apvo);
	public int apListCnt(AdoptionPossibleVO apvo);
}
