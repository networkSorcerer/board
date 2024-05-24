package com.spring.volunteer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.volunteer.vo.VolunteerVO;

@Mapper
public interface VolunteerDAO {
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO);
	
	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO);
	
	public int volunteerInsert(VolunteerVO volunteerVO);
	
	public int volunteerUpdate(VolunteerVO volunteerVO);
	
	public int volunteerDelete(VolunteerVO volunteerVO);
	
	public List<VolunteerVO> mainVol(VolunteerVO volunteerVO);
}
