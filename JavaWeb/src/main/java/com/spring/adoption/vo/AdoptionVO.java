package com.spring.adoption.vo;

import com.spring.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AdoptionVO extends CommonVO { 
	private int adoptionId=0;
	private String adoptionContent="";
	private String adoptionDate;
	private String adoptionTitle="";
	private int adoptionCnt=0;
	private String adoptionStatus="";
	private String adoptionLevel="";
	
	private String adminId;
	
	private int animalId=0;
	private String animalSpecies="";
	private String animalAge="";
	private String animalGender="";
	private String animalStatus="";
	private String animalKg="";
	private String animalColor="";
	private String animalMemo="";
	private String animalTemp="";
	private String animalRegist="";
	private String animalName="";
	private String animalPasswd="";
	private int readcnt=0;
	
	private String animalFile="";
	
	//private MultipartFile file;
	private String adoptionFile="";

}
