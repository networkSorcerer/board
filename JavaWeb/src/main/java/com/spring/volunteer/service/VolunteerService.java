package com.spring.volunteer.service;

import java.util.List;

import com.spring.volunteer.vo.VolunteerVO;

public interface VolunteerService {
	
	public List<VolunteerVO> volunteerList(VolunteerVO volunteerVO);
	
	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO);
	
	public int volunteerInsert(VolunteerVO volunteerVO) throws Exception;
	
	public VolunteerVO volunteerUpdateForm(VolunteerVO volunteerVO);
	
	public int volunteerUpdate(VolunteerVO volunteerVO) throws Exception;
	
	public int volunteerDelete(VolunteerVO volunteerVO) throws Exception;
	
	public List<VolunteerVO> mainVol(VolunteerVO volunteerVO);
}
