package com.javalab.calendar.service;

import com.javalab.calendar.vo.EventVo;

import java.util.List;

public interface EventService {
    List<EventVo> findAllEvents();
    EventVo findEventById(int eventId);
    void saveEvent(EventVo event);
    void saveEventWithMemberId(EventVo event); // 새로운 메서드 추가
    void updateEvent(EventVo event);
    void deleteEvent(int eventId);
}
