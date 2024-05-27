package com.spring.user.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.user.dao.UserDao;
import com.spring.user.vo.UserVO;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService{
	
	private static final char [] CHAR_SET =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	private static final SecureRandom random = new SecureRandom();
	private static int PASSWORD_LENGTH = 10;
	
	@Setter(onMethod_=@Autowired)
	private UserDao userDao;
	
	@Override
	public UserVO userLoginProcess(UserVO uvo) {
		UserVO result = userDao.userLoginProcess(uvo);
		return result;
	}
	@Override
	public UserVO findId(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int findUserByIdAndEmail(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int resetPasswd(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String generateTempPasswd() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int userJoin(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int idCheck(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int phoneCheck(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int emailCheck(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserVO userInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int pwdConfirm(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateProfile(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int userWithdrawal(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int userDelete(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<UserVO> userList(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int userListCnt(UserVO uvo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
