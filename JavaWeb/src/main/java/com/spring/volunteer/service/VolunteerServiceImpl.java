package com.spring.volunteer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.common.file.FileUploadUtil;
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
		int volunteerInsert = 0;
		if(volunteerVO.getFile().getSize() > 0) {
			String fileName = FileUploadUtil.fileUpload(volunteerVO.getFile(), "volunteer");
			volunteerVO.setVolunteerFile(fileName);
		}
		volunteerInsert = volunteerDAO.volunteerInsert(volunteerVO);
		return volunteerInsert;
	}

	@Override
	public int volunteerUpdate(VolunteerVO volunteerVO) throws Exception {
		int volunteerUpdate = 0;
		if(volunteerVO.getFile().isEmpty()) {
			if(!volunteerVO.getVolunteerFile().isEmpty()) {
				FileUploadUtil.fileDelete(volunteerVO.getVolunteerFile());
			}
			String fileName = FileUploadUtil.fileUpload(volunteerVO.getFile(), "volunteer");
			volunteerVO.setVolunteerFile(fileName);
		}
		volunteerUpdate = volunteerDAO.volunteerUpdate(volunteerVO);
		return volunteerUpdate;
	}

	@Override
	public int volunteerDelete(VolunteerVO volunteerVO) throws Exception {
		int volunteerDelete =0;
		if(!volunteerVO.getVolunteerFile().isEmpty()) {
			FileUploadUtil.fileDelete(volunteerVO.getVolunteerFile());
		}
		volunteerDelete = volunteerDAO.volunteerDelete(volunteerVO);
		return volunteerDelete;
	}

	@Override
	public List<VolunteerVO> mainVol(VolunteerVO vvo) {
		List<VolunteerVO> mainVol = volunteerDAO.mainVol(vvo);
		return mainVol;
	}

	@Override
	public VolunteerVO volunteerDetail(VolunteerVO volunteerVO) {
		VolunteerVO volunteerDetail = null;
		volunteerDetail = volunteerDAO.volunteerDetail(volunteerVO);
		if(volunteerDetail != null) {
			volunteerDetail.setVolunteerDetail(volunteerDetail.getVolunteerDetail().replaceAll("\n","<br/>"));
		}
		return volunteerDetail;
	}

	@Override
	public VolunteerVO volunteerUpdateForm(VolunteerVO volunteerVO) {
		VolunteerVO volunteerUpdateForm = null;
		volunteerUpdateForm = volunteerDAO.volunteerDetail(volunteerVO);
		if(volunteerUpdateForm != null) {
			volunteerUpdateForm.setVolunteerDetail(volunteerUpdateForm.getVolunteerDetail().replaceAll("<br/>", "/n"));
		}
		return volunteerUpdateForm;
	}
	
	
}
