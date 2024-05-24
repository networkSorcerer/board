package com.spring.volunteer.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class VolunteerVO {
	private int volunteerId=0;
	private String volunteerDetail;
	private String volunteerDate;
	private int volunteerCnt;
	private String volunteerTime;
	private String volunteerDue;
	private int volunteerLimit;
	private String volunteerCost;
	private String volunteerLocation;
	private int volunteerProgress;
	private String volunteerTitle;		// 봉사활동 게시물 제목

	private MultipartFile file;
	private String volunteerFile;

}
