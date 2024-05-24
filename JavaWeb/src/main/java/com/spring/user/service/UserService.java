package com.spring.user.service;

import java.util.List;

import com.spring.user.vo.UserVO;

public interface UserService {
	public UserVO userLoginProcess(UserVO uvo); // 회원 로그인
	public UserVO findId(UserVO uvo); 			// 아이디 찾기
	public int findUserByIdAndEmail(UserVO uvo);// 아이디, 이메일로 회원 확인
	public int resetPasswd(UserVO uvo); 		// 임시 비밀번호 재설정 
	String generateTempPasswd();				// 임시 비밀번호 생성
	//public int findIdCheck(UserVO uvo); 		// 회원 아이디 확인	
	
	public int userJoin(UserVO uvo); 			// 회원 가입
	public int idCheck(UserVO uvo);				// 회원 아이디 중복 체크
	public int phoneCheck(UserVO uvo);			// 핸드폰번호 중복 체크
	public int emailCheck(UserVO uvo);			// 이메일 중복 체크
	//public int checkDuplicate(UserVO uvo); // 중복 체크 : 아이디, 핸드폰번호, 이메일
	
	
	public UserVO userInfo(String userId);		// 회원 정보 조회	
	public int pwdConfirm(UserVO uvo);			// 비밀번호 확인
	public int updateProfile(UserVO uvo); 		// 회원 정보 수정
	public int userWithdrawal(UserVO uvo); 		// 회원 탈퇴 : 상태값 변경
	public int userDelete(UserVO uvo); 			// 회원 탈퇴 : 회원 레코드 삭제
	
	public List<UserVO> userList(UserVO uvo);   // 회원 목록 조회 + 마스킹처리
	public int userListCnt(UserVO uvo); 		// users 테이블의 전체 레코드 수 : 페이징처리시 필요
}
