package com.javalab.calendar.repository;

import com.javalab.calendar.vo.EventVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserEventMapper {

	// 회원 ID를 기준으로 이벤트 목록을 조회합니다.
	List<EventVo> findEventsByMemberId(String memberId);

	// 새로운 이벤트를 추가합니다.
	void insertuserEvent(EventVo event);

	// 이벤트 ID를 기준으로 이벤트를 조회합니다.
	EventVo findEventById(int id);
}
