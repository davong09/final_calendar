package com.javalab.calendar.service;

import com.javalab.calendar.vo.MemberVo;

import java.util.List;


/**
 * MypageService 인터페이스
 */
public interface MypageService {
	// 회원 상세 보기
	public MemberVo getMember(String memberId);

}
