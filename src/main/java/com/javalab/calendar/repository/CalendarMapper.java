package com.javalab.calendar.repository;

import com.javalab.calendar.vo.CalendarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CalendarMapper {
    void addEvent(CalendarVo calendarVo);
    List<CalendarVo> getAllEvents();
    CalendarVo getEventById(int id);
    void updateEvent(CalendarVo calendarVo);
    void deleteEvent(int id);
    List<CalendarVo> getEventsByUsername(@Param("memberId") String memberId);
}
