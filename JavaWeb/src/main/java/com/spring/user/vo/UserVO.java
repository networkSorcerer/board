package com.spring.user.vo;

import java.sql.Date;

import com.spring.common.vo.CommonVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserVO  extends CommonVO{ 
	private String userId ="";
	private String userPasswd = "";
	private String userName ="";
	private String userPhone = "";
	private String userEmail = "";
	private Date userDate;
	private int userAct=0;
	private int userRepcnt=0;
	private int userVolcnt = 0;
	private int userAdoptChk=0;
}
