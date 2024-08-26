// CalendarServiceImpl 구현 클래스 수정
package com.javalab.calendar.service;

import com.javalab.calendar.repository.CalendarMapper;
import com.javalab.calendar.vo.CalendarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final CalendarMapper calendarMapper;

    @Autowired
    public CalendarServiceImpl(CalendarMapper calendarMapper) {
        this.calendarMapper = calendarMapper;
    }

    @Override
    public CalendarVo getCalendarByUserId(String memberId) {
        return calendarMapper.findByMemberId(memberId);
    }

    @Override
    public void updateEvent(CalendarVo calendarVo) {
        calendarMapper.update(calendarVo);
    }

    @Override
    public void saveEvent(CalendarVo eventVo) {
        calendarMapper.saveEvent(eventVo);
    }

    @Override
    public List<CalendarVo> getEventsByMonth(String memberId, YearMonth month) {
        return calendarMapper.findEventsByMonth(memberId, month.toString());
    }
}
