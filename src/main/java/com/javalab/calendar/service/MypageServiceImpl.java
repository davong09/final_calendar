package com.javalab.calendar.service;

import com.javalab.calendar.repository.MemberMapper;
import com.javalab.calendar.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 게시물 서비스 클래스
 * @Service : 나는 서비스 레이어의 스프링 빈 역할을 할 수 있도록 빈으로 생성해라.라는 표시.
 * - root-context.xml 빈 환경설정 파일에 패키지의 위치가 지정되어 있다.
 *   <context:component-scan 
 *   		base-package="com.javalab.mybatis.service">
 */
@Service
@Slf4j
public class MypageServiceImpl implements MypageService{
	
	// 멤버 매퍼 인터페이스
	@Autowired
    private MemberMapper memberMapper;
	
	// 게시물 내용 보기
	@Override
	public MemberVo getMember(String memberId) {
		MemberVo memberVo = memberMapper.getMember(memberId);
		return memberVo;
	}
}
