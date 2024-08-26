package com.javalab.calendar.service;

import com.javalab.calendar.vo.CalendarVo;
import com.javalab.calendar.repository.CalendarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    private CalendarMapper calendarMapper;

    @Override
    public void addEvent(CalendarVo calendarVo) {
        calendarMapper.addEvent(calendarVo);
    }

    @Override
    public List<CalendarVo> getAllEvents() {
        return calendarMapper.getAllEvents();
    }

    @Override
    public CalendarVo getEventById(int id) {
        return calendarMapper.getEventById(id);
    }

    @Override
    public void updateEvent(CalendarVo calendarVo) {
        calendarMapper.updateEvent(calendarVo);
    }

    @Override
    public void deleteEvent(int id) {
        calendarMapper.deleteEvent(id);
    }

    @Override
    public List<CalendarVo> getEventsByUsername(String username) {
        return calendarMapper.getEventsByUsername(username);
    }
}
