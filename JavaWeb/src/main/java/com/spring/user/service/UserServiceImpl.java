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
		UserVO result = userDao.findId(uvo);
		return result;
	}
	@Override
	public int findUserByIdAndEmail(UserVO uvo) {
		int result = userDao.findUserByIdAndEmail(uvo);
		return result;
	}
	@Override
	public int resetPasswd(UserVO uvo) {
		int result = userDao.resetPasswd(uvo);
		return result;
	}
	@Override
	public String generateTempPasswd() {
		StringBuilder tempPassword = new StringBuilder(PASSWORD_LENGTH);
		for(int i =0; i < PASSWORD_LENGTH; i++) {
			char randomChar = CHAR_SET[random.nextInt(CHAR_SET.length)];
			tempPassword.append(randomChar);
		}
		return tempPassword.toString();
	}
	@Override
	public int userJoin(UserVO uvo) {
		int result = userDao.userJoin(uvo);
		return result;
	}
	@Override
	public int idCheck(UserVO uvo) {
		int result = 0;
		result = userDao.idCheck(uvo);
		return result;
	}
	@Override
	public int phoneCheck(UserVO uvo) {
		int result = 0;
		result = userDao.phoneCheck(uvo);
		return result;
	}
	@Override
	public int emailCheck(UserVO uvo) {
		int result = 0;
		result = userDao.emailCheck(uvo);
		return result;
	}
	@Override
	public UserVO userInfo(String userId) {
		UserVO uvo = new UserVO();
		uvo.setUserId(userId);
		UserVO info = userDao.userInfo(uvo);
		return info;
	}
	@Override
	public int pwdConfirm(UserVO uvo) {
		int result = 0;
		result = userDao.pwdConfirm(uvo);
		return result;
	}
	@Override
	public int updateProfile(UserVO uvo) {
		int result = userDao.updateProfile(uvo);
		return result;
	}
	@Override
	public int userWithdrawal(UserVO uvo) {
		int result = userDao.userWithdrawal(uvo);
		return result;
	}
	@Override
	public int userDelete(UserVO uvo) {
		int result = userDao.userDelete(uvo);
		return result;
	}
	@Override
	public List<UserVO> userList(UserVO uvo) {
		List<UserVO> list = null;
		list = userDao.userList(uvo);
		
		if(list != null && !list.isEmpty()) {
			for(UserVO user : list) {
				maskUserData(user);
			}
		}
		return list;
		
	}
	
	@Override
	public int userListCnt(UserVO uvo) {
		return userDao.userListCnt(uvo);
	}
	
	private void maskUserData(UserVO user) {
		String maskedId = transferMasking(user.getUserId(), 2, user.getUserId().length() -10);
		String maskedName = transferNameMasking(user.getUserName());
		String maskedEmail = transferEmailMasking(user.getUserEmail());
		String maskedPhone = transferPhoneMasking(user.getUserPhone());
		
		user.setUserId(maskedId);
		user.setUserName(maskedName);
		user.setUserEmail(maskedEmail);
		user.setUserPhone(maskedPhone);
		
	}
	
	private String transferMasking(String target, int startIndex, int endIndex) {
		if(target == null) {
			return "";
		} else {
			String result ="";
			target = target.trim();
			int length = target.length();
			String[] alphabets = target.split("");
			for(int i = 0; i < length; i++) {
				result += (i < startIndex || i >= (length - endIndex)) ? alphabets[i] : "*";
			}
			return result;
		}
	}
	
	private String transferNameMasking(String name) {
		if(name == null) {
			return "";
		} else {
			if(name.length() >2) {
				return transferMasking(name, 1, 1);
			} else {
				return transferMasking(name, 1, 0);
			}
		}
	}
	
	private String transferEmailMasking(String email) {
		if(email == null) {
			return "";
		} else {
			if(email.contains("@")) {
				String [] data = email.split("@");
				int endIndex = data[1].length() - data[1].indexOf(".");
				return transferMasking(data[0], 1, 0) + "@" + transferMasking(data[1], 1, endIndex);
			} else {
				return email;
			}
		}
	}
	
	private String transferPhoneMasking(String phone) {
		if(phone == null) {
			return "";
		} else {
			if(phone.contains("-")) {
				String [] data = phone.split("-");
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < data.length; i++) {
					sb.append(i > 0 ? "-" : "");
					sb.append(i == 1 ? transferMasking(data[i], 0, 0) : data[i]);
				} 
				return sb.toString();
			} else {
				return transferMasking(phone, 3, phone.length()-7);
			}
		}
	}

}
