package com.javalab.calendar.service;

import com.javalab.calendar.vo.EventVo;

import java.time.LocalDate;
import java.util.List;

public interface EventService {

    // 특정 ID의 이벤트 조회
    EventVo getEvent(int eventId);

    // 모든 이벤트 조회
    List<EventVo> listEvent();

    // 새로운 이벤트 생성
    void createEvent(EventVo eventVo);

    // 이벤트 수정
    void updateEvent(EventVo eventVo);

    // 이벤트 삭제
    void deleteEvent(int eventId);

    // 특정 월의 일정 목록 조회
    List<EventVo> findEventsByMonth(String memberId, String startDate, LocalDate endDate);

    List<EventVo> getEventsByMonth(String memberId, String month);
}
