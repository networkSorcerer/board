package com.spring.adoption.possible.vo;




import org.springframework.web.multipart.MultipartFile;

import com.spring.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AdoptionPossibleVO extends CommonVO {
	private int animalId =0;
	private String animalSpecies="";
	private String animalAge="";
	private String animalGender="";
	private String animalStatus="";
	private String animalKg="";
	private String animalColor="";
	private String animalMemo="";
	private String animalTemp;
	private String animalRegist;
	private String animalName="";
	private String animalPasswd="";
	private int readcnt=0;
	
	private int adoptionId=0;
	private String adoptionContent="";
	private String adoptionDate;
	private String adoptionTitle="";
	private int adoptionCnt=0;
	private String adoptionStatus="";
	private String adoptionLevel="";
	private String adoptionPasswd="";
	private String adminId="";

	private int centerId=0;
	private String centerName="";
	private String centerAddress="";
	private String centerOperating="";
	private String centerTell="";
	private int centerLat=0;
	private int centerLot=0;
	
	private String admin_id="";
	private String admin_pwd="";
	
	private MultipartFile file;
	private String animalFile = "";
	private String adoptionFile = "";
}
