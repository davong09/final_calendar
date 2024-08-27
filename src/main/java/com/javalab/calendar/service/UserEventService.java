package com.javalab.calendar.service;

import com.javalab.calendar.vo.EventVo;

import java.util.List;

public interface UserEventService {

    List<EventVo> getEventsForUser(String memberId);

    void createEvent(EventVo event);

    EventVo getEventById(int id);
}
