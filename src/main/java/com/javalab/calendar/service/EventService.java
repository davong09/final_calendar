package com.javalab.calendar.service;

import com.javalab.calendar.vo.EventVo;

import java.util.List;

public interface EventService {
    void createEvent(EventVo eventVo);  // 이벤트 생성
    List<EventVo> getAllEvents();       // 모든 이벤트 조회
    EventVo getEventById(int id);       // ID로 특정 이벤트 조회
    void updateEvent(EventVo eventVo);  // 이벤트 업데이트
    void deleteEvent(int id);           // ID로 이벤트 삭제
}
