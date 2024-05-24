package com.spring.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.user.vo.UserVO;

@Mapper
public interface UserDao {
	public UserVO userLoginProcess(UserVO uvo);
	
	public UserVO findId(UserVO uvo);
	public int findUserByIdAndEmail(UserVO uvo);
	public int resetPasswd(UserVO uvo);
	
	public int userJoin(UserVO uvo);
	public int idCheck(UserVO uvo);
	public int phoneCheck(UserVO uvo);
	public int emailCheck(UserVO uvo);
	
	public UserVO userInfo(UserVO uvo);
	public int updateProfile(UserVO uvo);
	public int pwdConfirm(UserVO uvo);
	
	public int userWithdrawal(UserVO uvo);
	public int userDelete(UserVO uvo);
	
	public List<UserVO> userList(UserVO uvo);
	public int userListCnt(UserVO uvo);
}
