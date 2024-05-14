package com.spring.volunteer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.volunteer.dao.VolunteerDAO;
import com.spring.volunteer.vo.VolunteerVO;

@Service
public class VolunteerServiceImpl implements VolunteerService {
	
	@Autowired
	private VolunteerDAO volunteerDAO;
	
	@Override
	public List<VolunteerVO > volunteerList(VolunteerVO volunteerVO) {
		List<VolunteerVO> volunteerList = volunteerDAO.volunteerList(volunteerVO);
		return volunteerList;
	}
	
//	@Override
//	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO) {
//		VolunteerVO volunteerDetail = null;
//		volunteerDetail = volunteerDAO.volunteerDetail(volunteerVO);
//		if(volunteerDetail != null) {
//			volunteerDetail.setVolunteerDetail(volunteerDetail.getVolunteerDetail().replaceAll("\n", "<br />"));
//		}
//		return volunteerDetail;
//	}

	@Override
	public int volunteerInsert(VolunteerVO volunteerVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int volunteerUpdate(VolunteerVO volunteerVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int volunteerDelete(VolunteerVO volunteerVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<VolunteerVO> mainVol(VolunteerVO volunteerVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
