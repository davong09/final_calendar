package com.javalab.calendar.service;

import com.javalab.calendar.vo.CalendarVo;

import java.util.List;
/*
 * @author sujin
 */
public interface CalendarService {
    void addEvent(CalendarVo calendarVo);
    List<CalendarVo> getAllEvents();
    CalendarVo getEventById(int id);
    void updateEvent(CalendarVo calendarVo);
    void deleteEvent(int id);
    List<CalendarVo> getEventsByUsername(String username); // 사용자가 등록한 일정만 가져오기
}
